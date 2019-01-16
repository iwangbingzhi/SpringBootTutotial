package com.iwbz.druiddemo.service.impl;


import com.iwbz.druiddemo.dao.cluster.CityDao;
import com.iwbz.druiddemo.dao.master.UserDao;
import com.iwbz.druiddemo.domain.City;
import com.iwbz.druiddemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iwbz.druiddemo.service.UserService2;

@Service
public class UserServiceImpl implements UserService2 {
    @Autowired
    private UserDao userDao;

    @Autowired
    private CityDao cityDao;

    @Override
    public User findByName(String username) {
        User u = userDao.findByName(username);
        City c = cityDao.findByName("德阳市");
        u.setCity(c);
        return u;
    }
}
