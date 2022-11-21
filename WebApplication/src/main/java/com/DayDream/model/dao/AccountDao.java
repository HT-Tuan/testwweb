package com.DayDream.model.dao;

import com.DayDream.model.entity.Account;

/**
 * AccountDao
 */
public interface AccountDao {
    Account create(Account entity);
    
    Account update(Account entity);
    
    Account delete(Account entity);
}