/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.DayDream.model.dao.AccountDao;
import com.DayDream.model.entity.Account;

/**
 *
 * @author huynh
 */
@WebServlet(urlPatterns = { "/DangNhap" })
public class Login extends HttpServlet {

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
            List<Account> account = accountdao.FindByAccount(Tk, Mk);
            if (account == null) {
                response.sendRedirect("/Project_Web/handle_error");
                return;
            }
            if (account.isEmpty() == false) {

                if (account.get(0).getCustomer() == null) {
                    response.sendRedirect("/Project_Web/admin.jsp");
                } else {
                    session.setAttribute("username", account.get(0).getCustomer().getFullName());
                    session.setAttribute("phone", account.get(0).getCustomer().getPhone());
                    response.sendRedirect("/Project_Web/index");
                }
            } else {
                request.setAttribute("TaiKhoan", Tk);
                request.setAttribute("mess", "Tài khoản hoặc mật khẩu không chính xác");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {

            if (Tk.length() == 0) {
                request.setAttribute("mess1", "Chưa nhập tài khoản");
            } else {
                request.setAttribute("TaiKhoan", Tk);
            }
            if (Mk.length() == 0) {
                request.setAttribute("mess2", "Chưa nhập mật khẩu");
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
