/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import com.DayDream.model.entity.Cart;

/**
 *
 * @author ADMIN
 */
public class CartDao extends HibernateDao<Cart> implements IHibernateDao<Cart> {
    @Override
    public Cart insert(Cart cart) {
        return super.insert(cart);
    }
    
    @Override
    public Cart update(Cart cart) {
        return super.update(cart);
    }
    
    @Override
    public Cart delete(Cart cart) {
        return super.delete(cart);
    }
    
    @Override
    public Cart get(Cart cart) {
        return null;
    }
}
