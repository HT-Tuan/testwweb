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
@WebServlet(urlPatterns = { "/AddSanPham" })
public class LoadAddProductPage extends HttpServlet {

    private CategoryDao categoryDao = new CategoryDao();

    @Override
    public void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        List<Category> categories = categoryDao.getAllCategory();
        req.setAttribute("categories", categories);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/inputmenu.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
