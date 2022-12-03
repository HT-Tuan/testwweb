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
import com.DayDream.model.dao.CategoryDao;

import com.DayDream.model.entity.Product;
import com.DayDream.model.entity.Category;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.*;

/**
 *
 * @author bounmykhamsavath
 */
@WebServlet(urlPatterns = { "/AddSanPham-action" })
public class AddProduct extends HttpServlet {

    private ProductDao productDao = new ProductDao();
    private CategoryDao categoryDao = new CategoryDao();

    @Override
    public void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        List<Category> categories = categoryDao.getAllCategory();
        req.setAttribute("categories", categories);

        String productName = req.getParameter("product-name");
        String imgurl = req.getParameter("img-url");

        String productPrice = null;
        if (req.getParameter("price") != null) {
            productPrice = req.getParameter("price");
        }

        String desc = req.getParameter("description");
        String strcateId = req.getParameter("category");

        
        Integer categoryId = Integer.parseInt(strcateId);


        Product addProduct = new Product();
        addProduct.setProductName(productName);
        addProduct.setImage(imgurl);
        addProduct.setPrice(new BigDecimal(productPrice).setScale(3, BigDecimal.ROUND_HALF_UP));
        addProduct.setDescription(desc);


        Category foundCate = categoryDao.getCategoryByID(categoryId);
        addProduct.setCategory(foundCate);

        addProduct.setStatus(true);
        Boolean result = productDao.insert(addProduct);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/inputmenu.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
