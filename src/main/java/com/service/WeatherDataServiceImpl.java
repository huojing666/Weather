package com.service;


/**
 * @author Sweeney
 * @date 2020/6/22 9:53 PM
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    /**
     * redis过期时间
     * */
    private static final long TIME_OUT = 10L;

    /* http 响应成功状态码*/
    private static final  int OK_REQUEST = 200;
    @Autowired
    RestTemplate restTemplate;

    /**
     * redis连接池
     * */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Override
    public WeatherResponse getDataByCityID(String cityId) {
        String uri = WEATHER_URI +"citykey=" +cityId;
        System.out.println("getbyId:::"+uri);
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataBycityName(String cityName) {
        String uri = WEATHER_URI +"city=" +cityName;
        return this.doGetWeather(uri);
    }


    private WeatherResponse doGetWeather(String uri) {

        /*定义key为uri*/
        String key = uri;
        /* 响应body*/
        String body = null;

        ObjectMapper mapper = new ObjectMapper();
        /* 返回解析后的对象*/
        WeatherResponse weatherResponse = null;
        /**
         * 定义对redis操作的对象
         * */
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        /**
         * 先从缓存中获取数据
         * */

        /*判断缓存中是否有数据 */
        if (stringRedisTemplate.hasKey(key)){
            /* 从缓存中获取数据*/
            logger.info("redis has date");
            body = ops.get(key);
        }else{ /* 缓存中无数据就去调用服务接口*/
            logger.info("redis no date");
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri,String.class);

            /* 判断响应码是否为200 */
            if (responseEntity.getStatusCodeValue() == OK_REQUEST){
                body = responseEntity.getBody();
            }
            /* 将读取到的数据写入缓存 并设置在缓存中的过期时间*/
            logger.info("数据写入缓存");
            ops.set(key,body,TIME_OUT, TimeUnit.SECONDS);
        }


        try{
            /* 反序列化操作*/
            weatherResponse = mapper.readValue(body,WeatherResponse.class);
        }catch (IOException e){
            logger.error("ERROR:"+e);
        }
        return weatherResponse;
    }


}
