package com.iwbz.dao;

import com.iwbz.Demo3Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo3Application.class)
public class JDBCTemplateDemoTest {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Before
    public void setUp() throws Exception {
        jdbcTemplate1.update("DELETE FROM USER ");
        jdbcTemplate2.update("DELETE FROM USER ");
    }

    @Test
    public void test(){
        //通过jdbctemplate1向user中插入2条数据
        jdbcTemplate1.update("insert into user (id,name,age) values (?,?,?)",1,"111",1);
        jdbcTemplate1.update("insert into user (id,name,age) values (?,?,?)",2,"222",2);

        //通过jdbctemplate2向user中插入1条数据
        jdbcTemplate2.update("insert into user (id,name,age) values (?,?,?)",1,"111",1);

        // 查一下第一个数据源中是否有两条数据，验证插入是否成功
        assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));

        // 查一下第一个数据源中是否有两条数据，验证插入是否成功
        assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));

    }
}