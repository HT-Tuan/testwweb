/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import com.DayDream.model.entity.Invoice;

/**
 *
 * @author ADMIN
 */
public class InvoiceDao extends HibernateDao<Invoice> implements IHibernateDao<Invoice> {
    @Override
    public Invoice insert(Invoice invoice) {
        return super.insert(invoice);
    }
    
    @Override
    public Invoice update(Invoice invoice) {
        return super.update(invoice);
    }
    
    @Override
    public Invoice delete(Invoice invoice) {
        return super.delete(invoice);
    }
    
    @Override
    public Invoice get(Invoice invoice) {
        return null;
    }
}
