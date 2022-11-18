package com.DayDream.utils;

import com.DayDream.model.entity.Account;
import com.DayDream.model.entity.Cart;
import com.DayDream.model.entity.Customer;
import com.DayDream.model.entity.DetailInvoice;
import com.DayDream.model.entity.Invoice;
import com.DayDream.model.entity.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static final SessionFactory FACTORY;
    
    static {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Account.class);
        conf.addAnnotatedClass(Cart.class);
        conf.addAnnotatedClass(Customer.class);
        conf.addAnnotatedClass(DetailInvoice.class);
        conf.addAnnotatedClass(Invoice.class);
        conf.addAnnotatedClass(Product.class);
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }
    
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
