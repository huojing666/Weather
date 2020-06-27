package com.service;

import com.vo.Weather;

/**
 * @author Sweeney
 * @date 2020/6/27 12:01 AM
 */
public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
