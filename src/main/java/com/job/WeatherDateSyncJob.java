package com.job;

import com.service.CityDataService;
import com.service.WeatherDataService;
import com.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author Sweeney
 * @date 2020/6/25 3:55 PM
 */

/**
 *  天气数据同步
 * */
public class WeatherDateSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDateSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        logger.info("Weather Data Sync Job. Start！");
        logger.info("何静大王八蛋！！！！！！！！");

        /**
         * 获取城市id列表
         * */
        List<City> cityList = null;

        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        // 遍历城市ID获取天气
        for (City city : cityList) {
            /* 先获取id*/
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId:" + cityId);
            /* 根据城市id获取天气*/
            weatherDataService.syncDateByCityId(cityId);
        }

        logger.info("Weather Data Sync Job. End！");


    }
}
