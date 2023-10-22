package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateBalance(String username,int num){
        String sql="UPDATE account SET balance=balance-? WHERE username=?";
        jdbcTemplate.update(sql,num,username);
    }

    public void updateStock(String isbn){//假设只买一本，每次库存只-1
        String sql="UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
        jdbcTemplate.update(sql,isbn);
    }

    public int getBookPrice(String isbn){
        String sql="SELECT price FROM book where isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);

    }

    public int updatePrice(String isbn,int price){
        String sql="UPDATE book SET price=? WHERE isbn=?";
        return jdbcTemplate.update(sql,price,isbn);
    }

}
