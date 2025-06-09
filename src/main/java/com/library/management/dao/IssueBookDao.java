package com.library.management.dao;

import com.library.management.entity.Book;
import com.library.management.entity.IssueBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Repository
public class IssueBookDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BookDao bookDao;

    public IssueBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public  int issueBook(IssueBook issueBook){
        String sql="insert into issued_book ( id , user_id , isusedate , issue_for_day , price_total , subdate , penalty_amount , returned) values(?,?,?,?,?,?,?,?) ";

        KeyHolder keyHolder=new GeneratedKeyHolder();

        jdbcTemplate.update(
                con -> {
                    PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1,issueBook.getBookId());
                    ps.setInt(2,issueBook.getUserId());
                    ps.setDate(3, Date.valueOf(issueBook.getIssueDate()));
                    ps.setInt(4,issueBook.getIssuedForDay());
                    ps.setInt(5,issueBook.getTotalAmount());
                    ps.setDate(6,Date.valueOf(issueBook.getSubmitDate()));
                    ps.setInt(7,issueBook.getPenalty());
                    ps.setBoolean(8,issueBook.isReturned());
                    return ps;
                }

                ,keyHolder);


        Map<String,Object> keys=keyHolder.getKeys();
        if(keys!=null && keys.containsKey("ib_id")){
            return ((Number) keys.get("ib_id")).intValue();
        }else {
            throw new RuntimeException("Generated key 'ib_id' not found");
        }

    }

    public int returnBook(int ib_id){
        //get the book id first
        String query="select id from issued_book where ib_id=?";
        int id=jdbcTemplate.queryForObject(query,
                Integer.class,
                ib_id);
        System.out.println("Id we found:"+id);

        String sql1="delete from issued_book where ib_id=?";
        int deletedRows=jdbcTemplate.update(sql1,ib_id);
        System.out.println("Book  returned:"+deletedRows);
        return id;
    }
    public List<Book> getAllIssuedBooks(){
        String query=" select * from books where available=false";

        List<Book> books=jdbcTemplate.query(
                query,
                new BookRowMapper()
        );
        return  books;


    }
}
