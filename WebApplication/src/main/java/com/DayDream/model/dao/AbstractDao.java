package com.DayDream.model.dao;

import org.hibernate.Session;
import com.DayDream.model.utils.HibernateUtils;

public class AbstractDao<T> {
    Session em = HibernateUtils.getFACTORY().openSession();

    public T create(T entity) {
        try {
            em.getTransaction().begin();
            em.save(entity);
            em.getTransaction().commit();
            System.out.println("Tao Thanh Cong");
            return entity;
        } catch (Exception e) {
            // TODO: handle exception
            em.getTransaction().rollback();
            System.out.println("Khong the them entity " + entity.getClass().getSimpleName() + " toi DB.");
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

    }

    public T update(T entity) {
        try {
            em.getTransaction().begin();
            em.update(entity);
            em.getTransaction().commit();
            System.out.println("Cap Nhat Thanh Cong");
            return entity;
        } catch (Exception e) {
            // TODO: handle exception
            em.getTransaction().rollback();
            System.out.println("Khong the cap nhat entity " + entity.getClass().getSimpleName() + " toi DB.");
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public T delete(T entity) {
        try {
            em.getTransaction().begin();
            em.delete(entity);
            em.getTransaction().commit();
            System.out.println("Xoa Thanh Thanh Cong");
            return entity;
        } catch (Exception e) {
            // TODO: handle exception
            em.getTransaction().rollback();
            System.out.println("Khong the xoa entity " + entity.getClass().getSimpleName());
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }
}
