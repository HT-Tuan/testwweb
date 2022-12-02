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

@WebServlet(urlPatterns = { "/DangKyThem" })
public class SignUpMore extends HttpServlet {
    private AccountDao accountDao = new AccountDao();
    private Account acc = new Account();
    private CustomerDao khdao = new CustomerDao();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sotk = req.getParameter("SoTK");
        String pass = req.getParameter("Matkhau");
        String xacnhan = req.getParameter("Xacnhan");
        HttpSession session = req.getSession();
        if (sotk == null || pass == null || xacnhan == null) {
            resp.sendRedirect("/Project_Web/signupmore.jsp");
            return;
        }

        if (sotk.length() != 0 && pass.length() != 0 && xacnhan.length() != 0) {

            req.setAttribute("taikhoan", sotk);
            List<Account> account = accountDao.FindByID(sotk);
            if (account == null) {
                resp.sendRedirect("/Project_Web/handle_error");
                return;
            }
            if ( account.isEmpty() == false) {
                req.setAttribute("error1", "Số tài khoản này không có sẵn");
                req.getRequestDispatcher("signupmore.jsp").forward(req, resp);
                return;
            }

            if (!pass.equals(xacnhan)) {
                req.setAttribute("messerror", "Mật khẩu không trùng khớp");
                req.getRequestDispatcher("signupmore.jsp").forward(req, resp);
                return;
            }

            acc.setAccountID(sotk);
            acc.setPassWord(pass);
            String phone = String.valueOf(session.getAttribute("phone"));
            List<Customer> cus = khdao.findbyPhone(phone);
            if (cus == null) {
                resp.sendRedirect("/Project_Web/handle_error");
                return;
            }
            acc.setCustomer(cus.get(0));
            if (accountDao.insert(acc) == true) {
                req.setAttribute("messuc", "Đăng ký thành công");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                req.setAttribute("messerror", "Đăng ký thất bại");
                req.getRequestDispatcher("signupmore.jsp").forward(req, resp);
            }
        } else {
            if (sotk.length() == 0) {
                req.setAttribute("error1", "Chưa nhập số tài khoản");
            } else {
                req.setAttribute("taikhoan", sotk);
            }

            if (pass.length() == 0) {
                req.setAttribute("error2", "Chưa nhập mật khẩu");
            }

            if (xacnhan.length() == 0) {
                req.setAttribute("error3", "Chưa nhập xác nhận mật khẩu");
            }
            req.getRequestDispatcher("signupmore.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
