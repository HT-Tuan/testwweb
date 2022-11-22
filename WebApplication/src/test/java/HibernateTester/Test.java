/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HibernateTester;

import com.DayDream.model.entity.Account;
import com.DayDream.utils.HibernateUtils;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Account t = new Account();
        t.setAccount_id("45");
        t.setCustomer_id("0003");
        t.setPassword("1234");
        session.save(t);
        
        session.close();
    }
}
