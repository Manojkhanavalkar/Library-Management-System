package com.library.management.dao;

import com.library.management.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user=new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_name(rs.getString("user_name"));
        user.setUser_phone_no(rs.getInt("user_phone_no"));
        user.setUser_address(rs.getString("user_address"));
        return user;
    }
}
