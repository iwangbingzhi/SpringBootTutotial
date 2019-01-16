package com.iwbz.dao;

import com.iwbz.domain.City;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CityMapper {
    @Select("select * from city where city_name=#{cityName}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findByName(@Param("cityName")String cityName);
}
