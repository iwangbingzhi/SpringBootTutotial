package com.iwbz.domian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userRepository.save(new User("wbzhyz",23));
        userRepository.save(new User("wbz",23));
        userRepository.save(new User("hyz",23));
        userRepository.save(new User("zly",23));
        userRepository.save(new User("lyf",23));
        userRepository.save(new User("zy",23));

        //测试是否是添加的6条数据
        assertEquals(6,userRepository.findAll().size());

        //测试findByName，查询名字为zy的用户
        assertEquals(23,userRepository.findByName("zy").getAge().longValue());

        //测试findUser
        assertEquals(23,userRepository.findUser("zy").getAge().longValue());

        //测试findByNameAndAge
        assertEquals("zy",userRepository.findByNameAndAge("zy",23).getName());

    }
}