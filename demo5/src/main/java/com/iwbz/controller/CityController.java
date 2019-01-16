package com.iwbz.controller;

import com.iwbz.Service.CityService2;
import com.iwbz.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService2 cityService2;

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public City findCityByName(@RequestParam(value = "cityName",required = true)String cityName){
        return cityService2.findByName(cityName);
    }
}
