/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import com.DayDream.model.dao.CustomerDao;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DayDream.model.dao.DetailInvoiceDao;
import com.DayDream.model.dao.InvoiceDao;
import com.DayDream.model.entity.DetailInvoice;
import com.DayDream.model.entity.Invoice;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author bounmykhamsavath
 */
@WebServlet(urlPatterns = { "/DetailInvoice" })
public class LoadDetailInvoice extends HttpServlet {

    private DetailInvoiceDao DetailInvoiceDao = new DetailInvoiceDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int invoiceID = Integer.parseInt(req.getParameter("invoiceID"));

        List<DetailInvoice> detailInvoice = DetailInvoiceDao.getDetailById(invoiceID);
        req.setAttribute("DetailInvoice", detailInvoice);
        req.getRequestDispatcher("/detailinvoice.jsp").forward(req, resp);
    }
}
