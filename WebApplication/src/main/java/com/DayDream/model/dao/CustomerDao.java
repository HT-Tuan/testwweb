/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import com.DayDream.model.entity.Customer;

/**
 *
 * @author ADMIN
 */
public class CustomerDao extends HibernateDao<Customer> implements IHibernateDao<Customer> {
    @Override
    public Customer insert(Customer customer) {
        return super.insert(customer);
    }
    
    @Override
    public Customer update(Customer customer) {
        return super.update(customer);
    }
    
    @Override
    public Customer delete(Customer customer) {
        return super.delete(customer);
    }
    
    @Override
    public Customer get(Customer customer) {
        return null;
    }
}
