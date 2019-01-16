package com.iwbz.druiddemo.dao.cluster;

import com.iwbz.druiddemo.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CityDao {
    City findByName(@Param("cityName") String cityName);
}
