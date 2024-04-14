package com.example.fullStackProject.dao;

import com.example.fullStackProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.fullStackProject.vo.userVO;

import java.util.List;
import java.util.Properties;

@Component
public class daoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Environment env;




    public List<User> getAllUsers() {
//        String sql = "SELECT * FROM users";
        String sql = env.getProperty("user.select");
        System.out.println("env get property " + env);

        // Debugging
        System.out.println("SQL query: " + sql);

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("gender")
                )
        );
    }

    public void insertUser(userVO user) {
//        String insertQuey="insert into public.users (name,gender) values ('sunny','male')";
        System.out.println("Inserting user: " + user.getName() + ", " + user.getGender());
//        String insertQuery= "INSERT INTO users (name, gender) VALUES (?, ?)";
        String insertQuery= env.getProperty("user.insert");
        jdbcTemplate.update(insertQuery, user.getName(), user.getGender());
    }
}
