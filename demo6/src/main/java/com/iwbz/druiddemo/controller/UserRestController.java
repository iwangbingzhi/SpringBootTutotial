package com.iwbz.druiddemo.controller;

import com.iwbz.druiddemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.iwbz.druiddemo.service.UserService2;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserService2 userService2;

    @RequestMapping(value = "/getUserAndCity",method = RequestMethod.GET)
    public User findUserAndCity(@RequestParam(value = "userName",required = true) String userName){
        return userService2.findByName(userName);
    }
}
