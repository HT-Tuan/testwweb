/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.DayDream.model.entity.Account;
import com.DayDream.utils.HibernateUtils;

public class AccountDao extends HibernateDao<Account> implements IHibernateDao<Account> {

    private SessionFactory sessionfactory = HibernateUtils.getFACTORY();

    @Override
    public boolean insert(Account account) {
        return super.insert(account);
    }

    @Override
    public boolean update(Account account) {
        return super.update(account);
    }

    @Override
    public boolean delete(Account account) {
        return super.delete(account);
    }

    public List<Account> FindByAccount(String TaiKhoan, String MatKhau)
    {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM Account WHERE accountID = :id AND maukhau = :pass";
            Query query = session.createQuery(hql);
            query.setParameter("id", TaiKhoan);
            query.setParameter("pass", MatKhau);
            return query.list();
        } catch (Exception e) {
            // TODO: handle exception\\\
            System.out.println("Co loi xay ra ở AccountDao");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Account> FindByID(String TaiKhoan)
    {
        Session session = sessionfactory.openSession();
        try {
            String hql = "FROM Account WHERE accountID = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", TaiKhoan);
            return query.list();
        } catch (Exception e) {
            // TODO: handle exception\\\
            System.out.println("co loi xay ra ở AccountDao");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

}