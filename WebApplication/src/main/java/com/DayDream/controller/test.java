package com.DayDream.controller;

import java.util.List;

import com.DayDream.model.dao.CustomerDao;
import com.DayDream.model.entity.Customer;

public class test {
    public static void main(String[] args) {
        Customer x1 = new Customer();
        CustomerDao c1 = new CustomerDao();
        // x1.setFullName("Thanhtuan");
        // x1.setPhone("090909");
        // x1.setEmail("1234@gmail.com");
        List<Customer> v1 = c1.findbyPhone("090909");
        if (v1 == null) {
            System.out.println("That bai");
        }
        if (!v1.isEmpty()) {
            if (c1.delete(v1.get(0)) == true)
                System.out.println("Thanh cong");
            else
                System.out.println("That bai");
        }
        // if (c1.insert(x1))
        // System.out.println("Thanh cong");
        // else
        // System.out.println("That bai");
    }
}
