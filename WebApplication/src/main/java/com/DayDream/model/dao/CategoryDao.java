package com.DayDream.model.dao;

import com.DayDream.model.entity.Category;
import com.DayDream.model.entity.Customer;
import com.DayDream.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class CategoryDao extends HibernateDao<Category> implements IHibernateDao<Category> {
   private SessionFactory sessionfactory = HibernateUtils.getFACTORY();

    @Override
    public boolean delete(Category entity) {
        // TODO Auto-generated method stub
        return super.delete(entity);
    }

    @Override
    public boolean insert(Category entity) {
        // TODO Auto-generated method stub
        return super.insert(entity);
    }

    @Override
    public boolean update(Category entity) {
        // TODO Auto-generated method stub
        return super.update(entity);
    }
    
    
    public List<Category> getAllCategory()
    {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM Category";
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
    

    public List<Category> FindCateByID(int cateId)
    {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM category WHERE category_id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", cateId);
            return query.list();
        } catch (Exception e) {
            // TODO: handle exception\\\
            System.out.println("co loi xay ra ở AccountDao");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;


        // Product entity = null;
		// Transaction transaction = null;
		// try (Session session = sessionfactory.openSession()) {
		// 	transaction = session.beginTransaction();

		// 	entity = session.get(Product.class, id);

		// 	session.flush();		
		// 	session.refresh(entity);		
		// 	transaction.commit();
		// } catch (Exception e) {
		// 	if (transaction != null) {
		// 		transaction.rollback();
		// 	}
		// 	e.printStackTrace();
		// }
		// return entity;
    }




    public Category getCategoryByID(int id) {
        Category entity = null;
        Transaction transaction = null;
        try (Session session = sessionfactory.openSession()) {
            transaction = session.beginTransaction();

            entity = session.get(Category.class, id);

            session.flush();
            session.refresh(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return entity;
    }
}
