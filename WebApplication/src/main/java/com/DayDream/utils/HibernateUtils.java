package com.DayDream.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static final SessionFactory FACTORY = createFACTORY();

    private static SessionFactory createFACTORY() {
        try {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Loi khong theo tao SessionFACTORY" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
