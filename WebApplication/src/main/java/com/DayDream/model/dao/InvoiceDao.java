package com.DayDream.model.dao;

import com.DayDream.model.entity.Invoice;

/**
 *
 * @author ADMIN
 */
public class InvoiceDao extends HibernateDao<Invoice> implements IHibernateDao<Invoice> {
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
    
    public Invoice get(Invoice invoice) {
        return null;
    }
}
