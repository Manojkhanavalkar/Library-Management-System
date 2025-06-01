package com.library.management.dao;


import com.library.management.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {
    private JdbcTemplate jdbcTemplate;


    //constructor injection is automatic in  the springBoot
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //save the book
    public void save(Book book){
        String query="insert into books (title,about,author,language,available) values(?,?,?,?,?)";
        int rowsAffected=jdbcTemplate.update(
                query,
                book.getTitle(),
                book.getAbout(),
                book.getAuthor(),
                book.getLanguage(),
                book.getAvailable()
        );
        System.out.println("Number of rows inserted= "+rowsAffected);

    }
    //delete the book
    public void delete(int id){
        String query="delete from books where id=?";
        int rowsAffected=jdbcTemplate.update(query,id);
    }

    public void update(int id, Book newBook){
        String query="update books set title=?,about=?,author=?,language=?,available=? where id=?";
        int rowsAffected=jdbcTemplate.update(
                query,
                newBook.getTitle(),
                newBook.getAbout(),
                newBook.getAuthor(),
                newBook.getLanguage(),
                newBook.getAvailable(),
                id
                );
        System.out.println("number of rows updated = "+rowsAffected);
    }

    //get the book
    public  Book get(int bookId){
        String query="Select * from books where id=?";
        Book book=jdbcTemplate.queryForObject(
                query,
                new BookRowMapper(),
                bookId
        );
        return book;
    }
    public List<Book> getAll(){
        String query="select * from books";
        List<Book> books=jdbcTemplate.query(
                query,
                new BookRowMapper()
        );
        return  books;
    }

    public List<Book> search(String titleKeyword){
        String query="select * from books where title like ?";
        List<Book> books=jdbcTemplate.query(
                query,
                new BookRowMapper(),
                "%"+titleKeyword+"%"
        );
        return books;
    }

}
