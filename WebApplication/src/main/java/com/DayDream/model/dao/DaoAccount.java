package com.DayDream.model.dao;

import com.DayDream.model.entity.Account;
import com.DayDream.utils.HibernateUtils;
import org.hibernate.Session;

public class DaoAccount {

    public static void main(String[] args) {
        create();
    }

    public static void create() {
      Session em = HibernateUtils.getFACTORY().openSession();
        try {
            em.getTransaction().begin();
            System.out.println("bat dau chay");
            Account entity = new Account();
            entity.setAccountID("20110160");
            entity.setMatkhau("123456");
            entity.setCustomer(null);

            em.save(entity);
            em.getTransaction().commit();
            System.out.println("Them thanh cong");

        } catch (Exception e) {
            // TODO: handle exception
            em.getTransaction().rollback();
            System.out.println("Them moi that bai");

        } finally {
            em.close();
        }
    }
}
