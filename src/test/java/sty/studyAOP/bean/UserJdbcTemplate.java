package sty.studyAOP.bean;

import org.aspectj.weaver.ast.Var;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.Assert.*;

public class UserJdbcTemplate {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
    }

    /**
     * update
     */
    @Test
    public void testUpdate() {
        String sql = "insert into user(name,password) value(?,?)";
        jdbcTemplate.update(sql,"aaaaaa","qwe123");
    }

    /**
     * queryForObject
     */
    @Test
    public void testQueryForObject(){
        String sql = "select id,name,password from user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(user);
    }

    /**
     * Query
     */
    @Test
    public void testQuery(){
        String sql = "select id,name,password from user";
        RowMapper<User> rm = new BeanPropertyRowMapper<User>(User.class);

        List<User> users = jdbcTemplate.query(sql, rm);
        System.out.println(users);
    }
}