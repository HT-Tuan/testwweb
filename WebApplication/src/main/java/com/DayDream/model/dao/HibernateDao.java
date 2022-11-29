package com.DayDream.model.dao;

import com.DayDream.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateDao<E> {
    private SessionFactory sessionfactory = HibernateUtils.getFACTORY();
    
    public boolean insert(E entity) {  
        Session session = sessionfactory.openSession();   
        Transaction transaction = null;
        try {
           transaction = session.beginTransaction();
           session.save(entity);
           transaction.commit();      
           return true;     
        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return false;
    }
    
    public boolean update(E entity) {
        Session session = sessionfactory.openSession();
        Transaction transaction = null;
        try {
           transaction = session.beginTransaction();
           session.update(entity);
           transaction.commit();   
           return true;        
        }
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return false;
    }

    public boolean delete(E entity) {
        Session session = sessionfactory.openSession();
        Transaction transaction = null;
        try {
           transaction = session.beginTransaction();
           session.delete(entity);
           transaction.commit();
           return true;
        }
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return false;
    }
}
