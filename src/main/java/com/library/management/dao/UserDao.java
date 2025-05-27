package com.library.management.dao;

import com.library.management.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate;
    public void save(User user){
        String query="insert into users(user_id, user_name , user_phone_no,user_address ) values(?,?,?,?)";
        int noOfRows=jdbcTemplate.update(query,
                user.getUser_id(),
                user.getUser_name(),
                user.getUser_phone_no(),
                user.getUser_address());
        System.out.println("Number of user inserted="+noOfRows);

    }

    public void get(){
        String query="select * from users where user_id=?";

    }
    public void getAll(){

    }
    public void delete(){

    }
    public void update(){

    }
}
