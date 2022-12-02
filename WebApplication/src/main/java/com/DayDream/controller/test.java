package com.DayDream.controller;

import java.util.List;

import com.DayDream.model.dao.AccountDao;
import com.DayDream.model.dao.CustomerDao;
import com.DayDream.model.dao.DetailInvoiceDao;
import com.DayDream.model.entity.Customer;
import com.DayDream.model.entity.DetailInvoice;

public class test {
    public static void main(String[] args) {
        // Customer x1 = new Customer();
        // CustomerDao c1 = new CustomerDao();
        // x1.setFullName("Thanhtuan");
        // x1.setPhone("090909");
        // x1.setEmail("1234@gmail.com");
        // List<Customer> v1 = c1.findbyPhone("0911161111");
        // if(v1.isEmpty() == false)
        //     System.out.println("Thanh cong");
        // else
        //     System.out.println("That bai");
        // if (c1.insert(x1))
        //     System.out.println("Thanh cong");
        // else
        //     System.out.println("That bai");
        DetailInvoiceDao detailInvoiceDao = new DetailInvoiceDao();
        int invoiceID = 1;

        List<DetailInvoice> detailInvoice = detailInvoiceDao.getDetailById(invoiceID);
        for(DetailInvoice x : detailInvoice)
        {
            System.out.println(x.getProduct().getProductName());
        }
    }
}
