package com.library.management.dao;

import com.library.management.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book=new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAbout(rs.getString("about"));
        book.setAuthor(rs.getString("author"));
        book.setLanguage(rs.getString("language"));
        book.setAvailable(rs.getBoolean("available"));
        book.setPriceOfDay(rs.getInt("price_for_day"));
        return book;
    }
}
