/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.bind.DatatypeConverter;

import com.DayDream.model.dao.AccountDao;
import com.DayDream.model.entity.Account;

/**
 *
 * @author huynh
 */
@WebServlet(urlPatterns = { "/DangNhap" })
public class login extends HttpServlet {

    private AccountDao accountdao = new AccountDao();

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String Tk = request.getParameter("SoTK");
        String Mk = request.getParameter("Matkhau");
        if (session == null || Tk == null || Mk == null) {
            session = request.getSession(true);
            response.sendRedirect("/Project_Web/login.jsp");
            return;
        }

        if (Tk.length() != 0 && Mk.length() != 0) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] digest = md.digest(Mk.getBytes());
                Mk = DatatypeConverter.printHexBinary(digest).toUpperCase();
            } catch (Exception e) {
                System.out.println(e);
            }
            List<Account> account = accountdao.FindByAccount(Tk, Mk);
            if (account == null) {
                response.sendRedirect("/Project_Web/handle_error");
                return;
            }
            if (account.isEmpty() == false) {

                if (account.get(0).getCustomer() == null) {
                    session.setAttribute("status", true);
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                } else {
                    if (account.get(0).getCustomer().getStatus() == true) {
                        session.setAttribute("cus", account.get(0).getCustomer());
                        session.setAttribute("customerId", account.get(0).getCustomer().getCustomerID());
                        response.sendRedirect("/Project_Web/index");
                    } else {
                        request.setAttribute("TaiKhoan", Tk);
                        request.setAttribute("mess", "Tài khoản này đã bị khoá");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                }
            } else {
                request.setAttribute("TaiKhoan", Tk);
                request.setAttribute("mess", "Tài khoản hoặc mật khẩu không chính xác");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {

            if (Tk.length() != 0) {
                request.setAttribute("TaiKhoan", Tk);
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
