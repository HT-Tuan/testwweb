
package com.DayDream.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DayDream.model.dao.DetailInvoiceDao;
import com.DayDream.model.dao.ProductDao;
import com.DayDream.model.entity.Product;

@WebServlet(urlPatterns = { "/index" })
public class Wellcome extends HttpServlet {
    DetailInvoiceDao detailInvoiceDao = new DetailInvoiceDao();
    ProductDao productDao = new ProductDao();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productbest = detailInvoiceDao.ProBest();
        List<Product> productgood = productDao.getProGood();
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("status");
        }
        if (productbest == null || productgood == null) {
            resp.sendRedirect("/Project_Web/handle_error");
            return;
        }
        req.setAttribute("productbest", productbest);
        req.setAttribute("productgood", productgood);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
