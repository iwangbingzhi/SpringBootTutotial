package com.iwbz;

import static org.junit.Assert.*;

import com.iwbz.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo4Application.class)
public class Demo4ApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void testBase() throws Exception{
        stringRedisTemplate.opsForValue().set("1","111");
        assertEquals("111",stringRedisTemplate.opsForValue().get("1"));


        //redisTemplate
        User user = new User("2",222);
        redisTemplate.opsForValue().set(user.getUsername(),user);

        user = new User("3",333);
        redisTemplate.opsForValue().set(user.getUsername(),user);

        assertEquals(222,redisTemplate.opsForValue().get("2").getAge().longValue());
        assertEquals(333,redisTemplate.opsForValue().get("3").getAge().longValue());
    }
}

