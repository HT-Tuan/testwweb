package com.DayDream.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.DayDream.model.entity.Account;

public class DaoAccount {

    public static void main(String[] args) {
        create();
    }

    public static void create() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HCMUTE");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            System.out.println("bat dau chay");
            Account entity = new Account();
            entity.setAccountID("20110101");
            entity.setMatkhau("123456");
            entity.setCustomer(null);

            em.persist(entity);
            em.getTransaction().commit();
            System.out.println("Them thanh cong");

        } catch (Exception e) {
            // TODO: handle exception
            em.getTransaction().rollback();
            System.out.println("Them moi that bai");

        } finally {
            em.close();
            emf.close();
        }
    }
}
