/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.net.URLDecoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import com.DayDream.model.dao.ProductDao;
import com.DayDream.model.entity.Product;

import com.DayDream.model.dao.CategoryDao;
import com.DayDream.model.entity.Category;

/**
 *
 * @author bounmykhamsavath
 */
@WebServlet(urlPatterns = {"/Edit"})
public class LoadEditProductPage extends HttpServlet {
    private ProductDao productDao = new ProductDao();
    private CategoryDao categoryDao = new CategoryDao();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String imgurl = req.getParameter("image");
         String productName = req.getParameter("productName");
         String productPrice = req.getParameter("price");
         String productDesc = req.getParameter("desc");
         Integer cateID = Integer.parseInt(req.getParameter("cateId"));
         Integer productID = Integer.parseInt(req.getParameter("id"));

         List<Category> categories = categoryDao.getAllCategory();
         req.setAttribute("categories", categories);
         
        req.setAttribute("productimg", imgurl);
        req.setAttribute("productName", productName);
        req.setAttribute("productPrice", productPrice);
        req.setAttribute("productDesc", productDesc);
        req.setAttribute("cateId", cateID);
        req.setAttribute("productId", productID);



        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/edit.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
   }

