package com.iwbz.Service.impl;

import com.iwbz.Service.CityService2;
import com.iwbz.dao.CityMapper;
import com.iwbz.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService2Impl implements CityService2 {
    @Autowired
    private CityMapper cityMapper;
    @Override
    public City findByName(String cityName) {
        return cityMapper.findByName(cityName);
    }
}
