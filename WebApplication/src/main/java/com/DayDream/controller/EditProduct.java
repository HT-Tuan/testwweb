/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.net.URLDecoder;
import java.text.DecimalFormat;

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
@WebServlet(urlPatterns = { "/Edit-action" })
public class EditProduct extends HttpServlet {
    private ProductDao productDao = new ProductDao();
    private CategoryDao categoryDao = new CategoryDao();
    private DecimalFormat df = new DecimalFormat("0.000");

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imgurl = req.getParameter("img-url");
        String productName = req.getParameter("productName");
        String productPrice = req.getParameter("price");
        String productDesc = req.getParameter("desc");
        Integer cateID = Integer.parseInt(req.getParameter("category"));
        Integer productID = Integer.parseInt(req.getParameter("id"));

        Product updateProduct = productDao.getProductByID(productID);
        Category foundCate = categoryDao.getCategoryByID(cateID);

        updateProduct.setCategory(foundCate);
        updateProduct.setImage(imgurl);
        updateProduct.setProductName(productName);
        updateProduct.setPrice(new BigDecimal(productPrice).setScale(3, BigDecimal.ROUND_HALF_UP));
        updateProduct.setDescription(productDesc);

        Boolean result = productDao.update(updateProduct);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Items");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
