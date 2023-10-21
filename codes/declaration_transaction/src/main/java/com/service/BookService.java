package com.service;

import com.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    BookService(BookDao bookDao){
        this.bookDao=bookDao;
    }
    @Transactional(timeout = 3,noRollbackFor = {ArithmeticException.class})
    public void checkout(String isbn,String username){
        /***
         * 购买图书操作
         */

        int price=bookDao.getBookPrice(isbn);//查价格
        bookDao.updateBalance(username,price);//-余额
        bookDao.updateStock(isbn);//-库存
        int x=10/0;

    }
}
