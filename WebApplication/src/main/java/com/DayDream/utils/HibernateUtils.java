package com.DayDream.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

    private static final SessionFactory FACTORY = createFACTORY();

    private static SessionFactory createFACTORY() {
        try {

            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            return configuration.buildSessionFactory();

        } catch (Throwable ex) {

            System.err.println("Loi khong theo tao SessionFACTORY" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
