/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import com.DayDream.model.dao.CartDao;
import com.DayDream.model.dao.CustomerDao;
import com.DayDream.model.dao.DetailInvoiceDao;
import com.DayDream.model.dao.InvoiceDao;
import com.DayDream.model.entity.Cart;
import com.DayDream.model.entity.Customer;
import com.DayDream.model.entity.DetailInvoice;
import com.DayDream.model.entity.Invoice;
import com.DayDream.model.entity.Product;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OrderCart")
public class OrderCartServlet extends HttpServlet {

    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private DetailInvoiceDao detailInvoiceDao;
    private CartDao cartDao;

    @Override
    public void init() throws ServletException {
        customerDao = new CustomerDao();
        invoiceDao = new InvoiceDao();
        detailInvoiceDao = new DetailInvoiceDao();
        cartDao = new CartDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String address = request.getParameter("address");
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute("customerId");
        List<Cart> cartItem = (ArrayList<Cart>) session.getAttribute("cartItem");

        Customer customer = customerDao.getById(customerId);
        customer.setAddress(address);
        customerDao.update(customer);     

        // The value default of this type is current date
        Date date = new Date();

        // Create Invoice before create detailInvoice                   
        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setStatus(Boolean.TRUE);
        invoice.setThoigian(date);
        
        BigDecimal totalAmount = (BigDecimal)session.getAttribute("totalAmount");
        invoice.setTotal(totalAmount.add(new BigDecimal(30)));
        invoiceDao.insert(invoice);

        for (Cart item : cartItem) {         
            DetailInvoice detailInvoice = new DetailInvoice();
            detailInvoice.setInvoice(invoice);
            detailInvoice.setProduct(item.getProduct());
            detailInvoice.setQuantity(item.getQuantity());
            detailInvoiceDao.insert(detailInvoice);
            cartDao.delete(item);
        }
        
        session.removeAttribute("cartItem");
        session.removeAttribute("totalProduct");
        session.removeAttribute("totalAmount");
        
        response.sendRedirect("index.jsp");
    }     
}
