package com.DayDream.model.dao.impl;

import com.DayDream.model.entity.Account;

public class demo {
    public static void main(String[] args) {
        Account t1= new Account();
        t1.setAccountID("20110212");
        t1.setMatkhau("123456");
        t1.setCustomer(null);

        DaoAccount f1 = new DaoAccount();
        f1.delete(t1);
    }
}
