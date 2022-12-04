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

import com.DayDream.model.dao.ProductDao;
import com.DayDream.model.entity.Product;

@WebServlet(urlPatterns = {"/Items"})
public class LoadSPAdmin extends HttpServlet {
    private ProductDao productDao = new ProductDao();
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDao.getAllProducts();
        req.setAttribute("products", products);
        
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/items.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
   }
