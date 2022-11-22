/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import com.DayDream.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDao<E> {
    private Session session = HibernateUtils.getFACTORY().openSession();
    
    public E insert(E entity) {     
        Transaction transaction = null;
        try {
           transaction = session.beginTransaction();
           session.save(entity);
           transaction.commit();           
        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return entity;
    }
    
    public E update(E entity) {
        Transaction transaction = null;
        try {
           transaction = session.beginTransaction();
           session.update(entity);
           transaction.commit();           
        }
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return entity;
    }

    public E delete(E entity) {
        Transaction transaction = null;
        try {
           transaction = session.beginTransaction();
           session.delete(entity);
           transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return entity;
    } 
    
    public void closeSessionFactory() {
        if (HibernateUtils.getFACTORY() != null) {
            HibernateUtils.getFACTORY().close();
        }
    }
}
