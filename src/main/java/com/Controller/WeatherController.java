package com.Controller;

import com.service.WeatherDataService;
import com.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;


    @RequestMapping(path = {"/bycityId/"} ,method = {RequestMethod.GET})
    public WeatherResponse getWeatherByCityId(@RequestParam("cityId") String cityId) {
        return weatherDataService.getDataByCityID(cityId);
    }


    @RequestMapping(path = {"/bycityName/"} ,method = {RequestMethod.GET})
    public WeatherResponse getWeatherByCityName(@RequestParam("cityName") String cityName) {
        return weatherDataService.getDataBycityName(cityName);
    }
}

