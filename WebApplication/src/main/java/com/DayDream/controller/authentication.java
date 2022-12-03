package com.DayDream.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DayDream.model.dao.AccountDao;
import com.DayDream.model.dao.CustomerDao;
import com.DayDream.model.entity.Account;
import com.DayDream.model.entity.Customer;

@WebServlet(urlPatterns = { "/authentication" })
public class authentication extends HttpServlet {
    private CustomerDao khdao = new CustomerDao();
    private AccountDao accountDao = new AccountDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numbers1 = req.getParameter("one");
        String numbers2 = req.getParameter("two");
        String numbers3 = req.getParameter("three");
        String numbers4 = req.getParameter("four");
        String numbers5 = req.getParameter("five");
        String numbers6 = req.getParameter("six");
        HttpSession session = req.getSession(false);
        if (session == null || numbers1 == null || numbers2 == null || numbers3 == null || numbers4 == null
                || numbers5 == null || numbers6 == null) {
            req.setAttribute("mess", "Không chính xác");
            req.getRequestDispatcher("chungthuc.jsp").forward(req, resp);
        } else {
            Customer TTKH = (Customer) session.getAttribute("KH");
            Account account = (Account) session.getAttribute("acc");

            String codenumber = String.valueOf(session.getAttribute("codenumber"));
            String numbercode = numbers1.concat(numbers2).concat(numbers3).concat(numbers4).concat(numbers5)
                    .concat(numbers6);
            if (numbercode.equals(codenumber)) {
                if (TTKH != null) {
                    if (khdao.insert(TTKH) == false) {
                        resp.sendRedirect("/Project_Web/handle_error");
                        return;
                    }
                    List<Customer> cus = khdao.findbyPhone(TTKH.getPhone());
                    if (cus == null) {
                        resp.sendRedirect("/Project_Web/handle_error");
                        return;
                    }
                    account.setCustomer(TTKH);
                }
                if (accountDao.insert(account) == false) {
                    khdao.delete(TTKH);
                    resp.sendRedirect("/Project_Web/handle_error");
                    return;
                }
                if (TTKH != null) {
                    session.removeAttribute("KH");
                }
                session.removeAttribute("acc");
                session.removeAttribute("email");
                session.removeAttribute("codenumber");
                req.setAttribute("messuc", "Đăng ký thành công");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                req.setAttribute("mess", "Không chính xác");
                req.getRequestDispatcher("chungthuc.jsp").forward(req, resp);
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
