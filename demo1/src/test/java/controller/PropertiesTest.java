package controller;/*
package com.wbz.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import com.example.demo.propertiesdemo.HomeProperties;
import com.example.demo.propertiesdemo.UserProperties;
import com.example.demo.propertiesdemo.WBZProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesTest.class);
    @Autowired
    private HomeProperties homeProperties;

    @Autowired
    private UserProperties userProperties;

    @Autowired
    private WBZProperties wbzProperties;

    @Test
    public void getHomeProperties(){
        LOGGER.info("\n\n"+homeProperties.toString()+"\n");
    }

    */
/*random属性*//*

    @Test
    public void randomUserTest(){
        LOGGER.info("\n\n"+userProperties.toString()+"\n");
    }

    //自定义属性与加载，通过在POJO类的属性中添加了Value属性可以直接获得值
    @Test
    public void getName(){
        assertEquals(wbzProperties.getName(),"wangbingzhi");
        assertThat(wbzProperties.getAge(),is(23));
        LOGGER.info(wbzProperties.toString());
    }
}*/
