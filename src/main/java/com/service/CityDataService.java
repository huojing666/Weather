package com.service;

import com.vo.City;

import java.util.List;

/**
 *
 * @author Sweeney
 * @date 2020/6/26 10:17 PM
 */
public interface CityDataService {

    /**
     * 获取city列表
     * */
    List<City> listCity()throws Exception;
}
