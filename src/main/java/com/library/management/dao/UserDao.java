package com.library.management.dao;

import com.library.management.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user){
        String query="insert into users( user_name , user_phone_no,user_address ) values(?,?,?)";
        int noOfRows=jdbcTemplate.update(query,
                user.getUser_name(),
                user.getUser_phone_no(),
                user.getUser_address());
        System.out.println("Number of user inserted="+noOfRows);

    }

    public User get(int userId){
        String query="select * from users where user_id=?";
        User user=jdbcTemplate.queryForObject(
                query,
                new UserRowMapper(),
                userId);
        return  user;

    }
    public List<User> getAll(){
        String query="select * from users ";
        List<User> users=jdbcTemplate.query(query,
                new UserRowMapper());
        return users;

    }
    public void delete(int userId){
        String query="delete from users where user_id=?";
        int noOfRows=jdbcTemplate.update(query,userId);
        System.out.println("Number of rows deleted:"+noOfRows);
    }
    public void update(int userId,User user)  {
        String query="update users set user_name=?,user_phone_no=?,user_address=? where user_id=?";
        int noOfRows=jdbcTemplate.update(query,
                user.getUser_name(),
                user.getUser_phone_no(),
                user.getUser_address(),
                userId);
        System.out.println("Number of rows updated :"+noOfRows);

    }

}
