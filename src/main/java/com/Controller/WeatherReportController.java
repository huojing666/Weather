package com.Controller;


import com.service.CityDataService;
import com.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sweeney
 * @date 2020/6/27 12:04 AM
 */

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;

   // @GetMapping("/cityId/{cityId}")
    @RequestMapping(path = {"/bycityId/"} ,method = {RequestMethod.GET})
    public ModelAndView getReportByCityId(@RequestParam("cityId") String cityId, Model model) throws Exception {
        model.addAttribute("title", "何静爸爸的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
