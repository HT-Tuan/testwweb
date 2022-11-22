package com.DayDream.model.dao;

import com.DayDream.model.entity.Product;

public class ProductDao extends HibernateDao<Product> implements IHibernateDao<Product> {
    @Override
    public Product insert(Product product) {
        return super.insert(product);
    }
    
    @Override
    public Product update(Product product) {
        return super.update(product);
    }
    
    @Override
    public Product delete(Product product) {
        return super.delete(product);
    }
    
    @Override
    public Product get(Product product) {
        return null;
    }
}
