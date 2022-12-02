
package com.DayDream.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DayDream.model.dao.CustomerDao;
import com.DayDream.model.entity.Customer;

/**
 *
 * @author bounmykhamsavath
 */
@WebServlet(urlPatterns = {"/customer"})
public class LoadCustomer extends HttpServlet {
        private CustomerDao customerDao = new CustomerDao();
        
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerDao.getAllCustomers();
        req.setAttribute("customers", customers);
        
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customer.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    
}

