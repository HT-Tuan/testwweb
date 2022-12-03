/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import com.DayDream.model.entity.Cart;
import com.DayDream.model.entity.Product;
import com.DayDream.utils.HibernateUtils;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class CartDao extends HibernateDao<Cart> implements IHibernateDao<Cart> {
    @Override
    public boolean insert(Cart cart) {
        return super.insert(cart);
    }
    
    @Override
    public boolean update(Cart cart) {
        return super.update(cart);
    }
    
    @Override
    public boolean delete(Cart cart) {
        return super.delete(cart);
    }
    
    public List<Cart> getAllProduct(int customerId) {    
        try {
            Session session = HibernateUtils.getFACTORY().openSession();
            String hqlQuery = "SELECT DISTINCT cart FROM Cart cart WHERE cart.customer.customerID=:id";
            
            Query query = session.createQuery(hqlQuery);
            query.setParameter("id", customerId);
            
            List<Cart> cartItem = query.list();
            
            return cartItem;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }                               
    }
}
