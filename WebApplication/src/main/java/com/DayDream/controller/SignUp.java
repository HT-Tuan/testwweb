package com.DayDream.controller;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

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

@WebServlet(urlPatterns = { "/DangKy" })
public class SignUp extends HttpServlet {
    private Customer KHnew = new Customer();
    private CustomerDao khdao = new CustomerDao();
    private AccountDao accountDao = new AccountDao();
    private Account acc = new Account();
    private mailxn send = new mailxn();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hoten = req.getParameter("Hovaten");
        String didong = req.getParameter("Didong");
        String email = req.getParameter("Email");
        String sotk = req.getParameter("SoTK");
        String pass = req.getParameter("Matkhau");
        String xacnhan = req.getParameter("Xacnhan");

        if (hoten == null || didong == null || email == null || sotk == null || pass == null || xacnhan == null) {
            resp.sendRedirect("/Project_Web/signup.jsp");
            return;
        }

        if (hoten.length() != 0 && didong.length() != 0 && email.length() != 0 && sotk.length() != 0
                && pass.length() != 0 && xacnhan.length() != 0) {

            req.setAttribute("fullname", hoten);
            req.setAttribute("sdt", didong);
            req.setAttribute("diachiemail", email);
            req.setAttribute("taikhoan", sotk);
            List<Account> accounts = accountDao.FindByID(sotk);
            if (accounts == null) {
                resp.sendRedirect("/Project_Web/handle_error");
                return;
            }
            if (accounts.isEmpty() == false) {
                req.setAttribute("messerror", "Số tài khoản này không có sẵn");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            }

            if (!pass.equals(xacnhan)) {
                req.setAttribute("messerror", "Mật khẩu không trùng khớp");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            }
            List<Customer> cus = khdao.findbyPhone(didong);
            if (cus == null) {
                resp.sendRedirect("/Project_Web/handle_error");
                return;
            }
            if (cus.isEmpty() == false) {
                req.setAttribute("messerror", "Số điện thoại này đã được sử dụng");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            } else {
                KHnew.setFullName(hoten);
                KHnew.setPhone(didong);
                KHnew.setEmail(email);
                KHnew.setStatus(true);
                //
                try {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] digest = md.digest(pass.getBytes());
                    pass = DatatypeConverter.printHexBinary(digest).toUpperCase();
                } catch (Exception e) {
                    System.out.println(e);
                }
                acc.setAccountID(sotk);
                acc.setPassWord(pass);
                //
                String number = send.getRandom();
                if (send.sendEmail(email, number, hoten) == false) {
                    resp.sendRedirect("/Project_Web/handle_error");
                    return;
                }
                HttpSession session = req.getSession();
                session.setAttribute("KH", KHnew);
                session.setAttribute("acc", acc);
                session.setAttribute("codenumber", number);
                session.setAttribute("email", email);
                resp.sendRedirect("/Project_Web/chungthuc.jsp");
            }
        } else {
            if (hoten.length() != 0) {
                req.setAttribute("fullname", hoten);
            }

            if (didong.length() != 0) {
                req.setAttribute("sdt", didong);
            }

            if (email.length() != 0) {
                req.setAttribute("diachiemail", email);
            }

            if (sotk.length() != 0) {
                req.setAttribute("taikhoan", sotk);
            }
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
