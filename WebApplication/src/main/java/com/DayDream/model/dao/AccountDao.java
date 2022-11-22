/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import com.DayDream.model.dao.HibernateDao;
import com.DayDream.model.dao.IHibernateDao;
import com.DayDream.model.entity.Account;

public class AccountDao extends HibernateDao<Account> implements IHibernateDao<Account> {

    @Override
    public Account insert(Account account) {
        return super.insert(account);
    }
    
    @Override
    public Account update(Account account) {
        return super.update(account);
    }
    
    @Override
    public Account delete(Account account) {
        return super.delete(account);
    }
    
    @Override
    public Account get(Account account) {
        return null;
    }
}