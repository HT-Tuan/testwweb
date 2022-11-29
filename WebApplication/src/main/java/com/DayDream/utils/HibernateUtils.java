package com.DayDream.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

    private static final SessionFactory FACTORY = createFACTORY();

    private static SessionFactory createFACTORY() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            
            return configuration.configure().buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("Không thể khởi tạo SessionFactory" + ex);
            throw new ExceptionInInitializerError(ex);               
        }
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void closeSessionFactory()
    {
         if (FACTORY != null) {
            FACTORY.close();
        }
    }
}
