/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DayDream.model.dao.ProductDao;
import com.DayDream.model.entity.Product;

/**
 *
 * @author bounmykhamsavath
 */
@WebServlet(urlPatterns = {"/DeleteSP"})
public class DeleteSP extends HttpServlet {

    private ProductDao productDao = new ProductDao();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product delProduct = productDao.getProductByID(id);
        delProduct.setStatus(Boolean.FALSE);
        System.out.println("toons"+delProduct.getStatus());
        productDao.update(delProduct);

        // resp.sendRedirect("/Project_Web/Items");
        // resp.sendRedirect("/Project_Web/Invoice");
        // resp.sendRedirect("/Project_Web/DetailInvoice?invoiceID=1");
        // resp.sendRedirect("/Project_Web/customer");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Items");
        requestDispatcher.forward(req, resp);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
