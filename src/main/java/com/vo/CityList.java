package com.vo;


import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Sweeney
 * @date 2020/6/26 10:01 PM
 */

@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
