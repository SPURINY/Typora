package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulService {
    @Autowired
    BookService bk;
    @Transactional
    public void mulTx(){
        //@Transactional(propagation = Propagation.REQUIRED)
        bk.checkout("ISBN-002","Tom");
        //@Transactional(propagation = Propagation.REQUIRED)
        bk.updatePrice("ISBN-003",99);
    }
}
