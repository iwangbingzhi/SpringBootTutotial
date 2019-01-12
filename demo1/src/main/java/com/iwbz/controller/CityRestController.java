package com.iwbz.controller;

import com.iwbz.domain.City;
import com.iwbz.service.CityService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityRestController {
    @Autowired
    CityService cityService;

    @ApiOperation(value = "获取城市列表",notes = "")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<City> cityList(){
        return cityService.findAllCity();
    }

    @ApiOperation(value = "获取城市信息",notes = "根据url传入的id获取到城市信息")
    @ApiImplicitParam(name = "id",value = "城市id",required = true,dataType = "Long",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public City findById(@PathVariable("id")Long id){
        return cityService.findCityById(id);
    }

    @ApiOperation(value = "添加城市",notes = "根据传入的城市实体添加城市")
    @ApiImplicitParam(name = "City",value = "城市实体",required = true,dataType = "City")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void insertCity(@RequestBody City city){
        cityService.insertCity(city);
    }

    @ApiOperation(value = "更新城市信息",notes = "根据传入的城市实体更新城市信息")
    @ApiImplicitParam(name = "City",value = "城市实体",required = true,dataType = "City")
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public void updateCity(@RequestBody City city){
        cityService.updateCity(city);
    }

    @ApiOperation(value = "删除城市",notes = "根据传入的城市id删除城市")
    @ApiImplicitParam(name = "id",value = "城市id",required = true,dataType = "Long",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable("id") Long id){
        cityService.deleteCity(id);
        //
    }
}
