package com.service;

/**
 * @author Sweeney
 * @date 2020/6/26 10:20 PM
 */
import com.until.XmlBuilder;
import com.vo.City;
import com.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {

    /**
     * 获取城市列表
     * */
    @Override
    public List<City> listCity() throws Exception {

        /**
         * 读取XML文件
         * */
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer bf = new StringBuffer();

        String line = "";
        while ((line = bufferedReader.readLine()) !=null){
            bf = bf.append(line);
        }
        bufferedReader.close();
        /**
         *XML转换成Java对象
         * */
        CityList cityList = (CityList) XmlBuilder.xmlstrToObject(CityList.class, bf.toString());
        return cityList.getCityList();
    }
}
