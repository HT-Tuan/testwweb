package com.DayDream.utils;

import com.DayDream.model.entity.Account;
import com.DayDream.model.entity.Cart;
import com.DayDream.model.entity.Customer;
import com.DayDream.model.entity.DetailInvoice;
import com.DayDream.model.entity.Invoice;
import com.DayDream.model.entity.Product;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static final SessionFactory FACTORY;
    
    // Information configuration for Hibernate
    static {
        Configuration conf = new Configuration();
        conf.configure("src/conf/Hibernate.cfg.xml");
        
        /*Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        props.put(Environment.DRIVER, "org.postgresql.Driver");
        props.put(Environment.URL, "jdbc:postgresql://localhost:5432/mydb");
        props.put(Environment.USER, "postgres");
        props.put(Environment.PASS, "admin");
        props.put(Environment.SHOW_SQL, "true");
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Customer.class);
        conf.addAnnotatedClass(Account.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Cart.class);
        conf.addAnnotatedClass(Invoice.class);
        conf.addAnnotatedClass(DetailInvoice.class);*/
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }
    
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }   
}
