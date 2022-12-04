/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author huynh
 */
@WebServlet(urlPatterns = { "/DangXuat" })
public class Logout extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("cus");
        session.removeAttribute("cartItem");
        session.removeAttribute("customerId");
        session.removeAttribute("totalProduct");
        session.removeAttribute("totalAmount");
        response.sendRedirect("/Project_Web/index");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
