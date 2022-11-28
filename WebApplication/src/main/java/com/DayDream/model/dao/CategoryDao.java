package com.DayDream.model.dao;

import com.DayDream.model.entity.Category;

public class CategoryDao extends HibernateDao<Category> implements IHibernateDao<Category> {

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
    
}
