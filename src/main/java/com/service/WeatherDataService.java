package com.service;


/**
 * @author Sweeney
 * @date 2020/6/22 9:51 PM
 */
import com.vo.WeatherResponse;

public interface WeatherDataService {
    /**
     * 根据城市id查询
     * */
    WeatherResponse getDataByCityID(String cityId);
    /**
     * 根据城市名称查询
     * */
    WeatherResponse getDataBycityName(String cityName);
}
