package com.library.management.dao;

import com.library.management.entity.IssueBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IssueBookDao {
    private JdbcTemplate jdbcTemplate;

    public IssueBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public  int issueBook(IssueBook issueBook){
        String sql="insert into issued_book ( id , user_id , isusedate , issue_for_day , price_total , subdate , penalty_amount , returned) values(?,?,?,?,?,?,?,?) ";
        int rowsAdded=jdbcTemplate.update(sql,
                issueBook.getBookId(),
                issueBook.getUserId(),
                issueBook.getIssueDate(),
                issueBook.getIssuedForDay(),
                issueBook.getTotalAmount(),
                issueBook.getSubmitDate(),
                issueBook.getPenalty(),
                issueBook.isReturned());
        return rowsAdded;
    }
}
