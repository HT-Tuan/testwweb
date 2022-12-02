package com.DayDream.model.dao;

import com.DayDream.model.entity.Category;
import com.DayDream.model.entity.Customer;
import com.DayDream.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    
}
