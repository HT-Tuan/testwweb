/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.DayDream.model.entity.Customer;
import com.DayDream.utils.HibernateUtils;


/**
 *
 * @author ADMIN
 */
public class CustomerDao extends HibernateDao<Customer> implements IHibernateDao<Customer> {
    private SessionFactory sessionfactory = HibernateUtils.getFACTORY();

    @Override
    public boolean insert(Customer customer) {
        return super.insert(customer);
    }
    
    @Override
    public boolean update(Customer customer) {
        return super.update(customer);
    }
    
    @Override
    public boolean delete(Customer customer) {
        return super.delete(customer);
    }
    
    public List<Customer> findbyPhone(String phone) {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM Customer cus WHERE cus.phone = :didong";
            Query query = session.createQuery(hql);
            query.setParameter("didong", phone);
            return query.list();
        } catch (Exception e) {
            // TODO: handle exception\\\
            System.out.println("co loi xay ra o CustomerDao");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    
}
