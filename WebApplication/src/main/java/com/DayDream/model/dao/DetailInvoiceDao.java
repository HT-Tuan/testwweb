/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.DayDream.model.entity.DetailInvoice;
import com.DayDream.utils.HibernateUtils;
import com.DayDream.model.entity.Product;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DetailInvoiceDao extends HibernateDao<DetailInvoice> implements IHibernateDao<DetailInvoice> {

    private SessionFactory sessionfactory = HibernateUtils.getFACTORY();

    @Override
    public boolean insert(DetailInvoice detailInvoice) {
        return super.insert(detailInvoice);
    }

    @Override
    public boolean update(DetailInvoice detailInvoice) {
        return super.update(detailInvoice);
    }

    @Override
    public boolean delete(DetailInvoice detailInvoice) {
        return super.delete(detailInvoice);
    }

    public List<Product> ProBest() {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM Product p WHERE p.productID IN (SELECT d.product.productID FROM DetailInvoice d GROUP BY d.product.productID  ORDER BY SUM(d.quantity) DESC)";
            Query query = session.createQuery(hql);
            query.setFirstResult(0);
            query.setMaxResults(3);
            return query.list();
        } catch (Exception e) {
            // TODO: handle exception\\\
            System.out.println("Loi khong the lay tat ca san pham");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<DetailInvoice> getAllDetailInvoice() {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM DetailInvoice";
            Query query = session.createQuery(hql);
            return query.list();

        } catch (Exception e) {
            // TODO: handle exception\\\
            System.out.println("Loi khong the lay tat ca san pham");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<DetailInvoice> getDetailById(int invoiceID) {
        List<DetailInvoice> DetailInvoices = null;
        Session session = sessionfactory.openSession();
        String HQL = "from DetailInvoice p where p.invoice.invoiceID= :id";
        try {
            DetailInvoices = session.createQuery(HQL).setParameter("id", invoiceID).list();
            return DetailInvoices;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
