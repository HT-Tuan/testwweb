package com.DayDream.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                req.setAttribute("error4", "Số tài khoản này không có sẵn");
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
                req.setAttribute("error2", "Số điện thoại này đã được sử dụng");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            } else {
                KHnew.setFullName(hoten);
                KHnew.setPhone(didong);
                KHnew.setEmail(email);
                if (khdao.insert(KHnew) == true) {
                    cus = khdao.findbyPhone(didong);
                    if (cus == null) {
                        resp.sendRedirect("/Project_Web/handle_error");
                        return;
                    }
                    acc.setAccountID(sotk);
                    acc.setPassWord(pass);
                    acc.setCustomer(cus.get(0));
                    if (accountDao.insert(acc) == true) {
                        req.setAttribute("messuc", "Đăng ký thành công");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("messerror", "Đăng ký thất bại");
                        if (khdao.delete(cus.get(0)) == false) {
                            resp.sendRedirect("/Project_Web/handle_error");
                            return;
                        }
                        req.getRequestDispatcher("signup.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("messtb", "Đăng ký thất bại");
                    req.getRequestDispatcher("signup.jsp").forward(req, resp);
                }
            }
        } else {
            if (hoten.length() == 0) {
                req.setAttribute("error1", "Chưa nhập họ và tên");
            } else {
                req.setAttribute("fullname", hoten);
            }

            if (didong.length() == 0) {
                req.setAttribute("error2", "Chưa nhập số điện thoại");
            } else {
                req.setAttribute("sdt", didong);
            }

            if (email.length() == 0) {
                req.setAttribute("error3", "Chưa nhập địa chỉ email");
            } else {
                req.setAttribute("diachiemail", email);
            }

            if (sotk.length() == 0) {
                req.setAttribute("error4", "Chưa nhập số tài khoản");
            } else {
                req.setAttribute("taikhoan", sotk);
            }

            if (pass.length() == 0) {
                req.setAttribute("error5", "Chưa nhập mật khẩu");
            }

            if (xacnhan.length() == 0) {
                req.setAttribute("error6", "Chưa nhập xác nhận mật khẩu");
            }
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
