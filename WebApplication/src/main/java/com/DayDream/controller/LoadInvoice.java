/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DayDream.model.dao.InvoiceDao;
import com.DayDream.model.entity.Invoice;
/**
 *
 * @author bounmykhamsavath
 */
@WebServlet(urlPatterns = {"/Invoice"})
public class LoadInvoice extends HttpServlet {
        private InvoiceDao InvoiceDao = new InvoiceDao();
        
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Invoice> invoice = InvoiceDao.getAllInvoice();
        req.setAttribute("invoice", invoice);
        
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/invoice.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    
}
