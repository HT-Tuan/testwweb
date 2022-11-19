/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import com.DayDream.model.entity.Account;
import com.DayDream.model.entity.Cart;
import com.DayDream.model.entity.Customer;
import com.DayDream.model.entity.DetailInvoice;
import com.DayDream.model.entity.Invoice;
import com.DayDream.model.entity.Product;
import com.DayDream.utils.HibernateUtils;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class test {

    public static void main(String[] args) {
        System.out.println("oke");
        Session session = HibernateUtils.getFACTORY().openSession();
        /* try {
            session.getTransaction().begin();
            Customer customer = session.get(Customer.class, "0003");
            Set<Account> accounts = customer.getAccounts();
            for (Account account : accounts) {
                System.out.println(account.getAccountID());
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        } */
        
        try {
            session.getTransaction().begin();     
            Query q = session.createQuery("FROM Product p WHERE p.productID = 10");
            Product customer = (Product)q.getSingleResult();
            Set<DetailInvoice> carts = customer.getDetailInvoices();
            for (DetailInvoice cart : carts) {
                System.out.println(cart.getInvoice().getInvoiceID());
                System.out.println(cart.getQuantity());
            }                
            session.getTransaction().commit();
            System.out.println("Thanh cong");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
