package com.service;

import com.vo.Weather;
import com.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sweeney
 * @date 2020/6/27 12:02 AM
 */


@Service
public class WeatherReportServiceimpl implements WeatherReportService {

    @Autowired
    WeatherDataService weatherDataService;
    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse response =  weatherDataService.GetDataByCityId(cityId);
        return response.getData();
    }
}
