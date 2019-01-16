package com.iwbz.druiddemo.dao.master;

import com.iwbz.druiddemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    User findByName(@Param("userName")String userName);
}
