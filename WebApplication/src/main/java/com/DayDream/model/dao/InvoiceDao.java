package com.DayDream.model.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.DayDream.model.entity.Invoice;
import com.DayDream.utils.HibernateUtils;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class InvoiceDao extends HibernateDao<Invoice> implements IHibernateDao<Invoice> {
       private SessionFactory sessionfactory = HibernateUtils.getFACTORY();

    
    @Override
    public boolean insert(Invoice invoice) {
        return super.insert(invoice);
    }
    
    @Override
    public boolean update(Invoice invoice) {
        return super.update(invoice);
    }
    
    @Override
    public boolean delete(Invoice invoice) {
        return super.delete(invoice);
    }
    
    public Invoice get(int id ) {
        
        Invoice entity = null;
		Transaction transaction = null;
        Session session = sessionfactory.openSession();
		try {
			transaction = session.beginTransaction();

			entity = session.get(Invoice.class, id);

			session.flush();		
			session.refresh(entity);		
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
        finally
        {
            session.close();
        }
		return entity;
    }

    public List<Invoice> getAllInvoice() {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM Invoice";
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
