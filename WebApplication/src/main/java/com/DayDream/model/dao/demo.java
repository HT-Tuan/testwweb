package com.DayDream.model.dao;

import com.DayDream.model.entity.Account;

public class demo {
    public static void main(String[] args) {
        Account t1= new Account();
        t1.setAccountID("20110212");
        t1.setPassWord("123456");
        t1.setCustomer(null);

        AccountDao f1 = new AccountDao();
        f1.delete(t1); 
    }
}
