/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> f198efadec4c4f5414e7dad3992b0d5dae76d6bf
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

<<<<<<< HEAD
import com.DayDream.utils.HibernateUtils;
=======
>>>>>>> f198efadec4c4f5414e7dad3992b0d5dae76d6bf
import com.DayDream.model.entity.Customer;
import com.DayDream.utils.HibernateUtils;


/**
 *
 * @author ADMIN
 */
public class CustomerDao extends HibernateDao<Customer> implements IHibernateDao<Customer> {
<<<<<<< HEAD
   private SessionFactory sessionfactory = HibernateUtils.getFACTORY();
   
=======
    private SessionFactory sessionfactory = HibernateUtils.getFACTORY();

>>>>>>> f198efadec4c4f5414e7dad3992b0d5dae76d6bf
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
    
    
    public List<Customer> getAllCustomers()
    {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM Customer";
            Query query = session.createQuery(hql);
            return query.list();

        } catch (Exception e) {
            // TODO: handle exception\\\
            System.out.println("Loi khong the lay tat ca san pham");
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return null;
    }
}
