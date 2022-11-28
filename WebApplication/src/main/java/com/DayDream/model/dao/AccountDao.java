/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import com.DayDream.model.entity.Account;

public class AccountDao extends HibernateDao<Account> implements IHibernateDao<Account> {

    @Override
    public boolean insert(Account account) {
        return super.insert(account);
    }
    
    @Override
    public boolean update(Account account) {
        return super.update(account);
    }
    
    @Override
    public boolean delete(Account account) {
        return super.delete(account);
    }
    
    public Account get(Account account) {
        return null;
    }
}