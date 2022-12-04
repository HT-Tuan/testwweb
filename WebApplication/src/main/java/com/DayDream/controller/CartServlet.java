/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import com.DayDream.model.dao.CartDao;
import com.DayDream.model.dao.CustomerDao;
import com.DayDream.model.dao.ProductDao;
import com.DayDream.model.entity.Cart;
import com.DayDream.model.entity.Customer;
import com.DayDream.model.entity.Product;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {

    private CartDao cartDao;
    private ProductDao productDao;
    private CustomerDao customerDao;
    private List<Cart> cartItem;

    @Override
    public void init() throws ServletException {
        super.init();
        cartDao = new CartDao();
        productDao = new ProductDao();
        customerDao = new CustomerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isLogin(request, response) == false) {
            response.sendRedirect("login.jsp");
            return;
        }
        String url = "index.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute("customerId");

        cartItem = (List<Cart>) session.getAttribute("cartItem");

        if (cartItem == null) {
            cartItem = cartDao.getAllProduct(customerId);
        }

        if (action.equals("addProduct")) {
            if (cartItem == null) {
                cartItem = new ArrayList<Cart>();
            }
            int productId = Integer.parseInt(request.getParameter("productId"));
            boolean isExist = false;
            for (Cart cart : cartItem) {
                if (cart.getProduct().getProductID() == productId && cart.getCustomer().getCustomerID() == customerId) {
                    cart.setQuantity(cart.getQuantity() + 1);
                    cartDao.update(cart);
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                Product product = productDao.getProductByID(productId);
                Customer customer = customerDao.getById(customerId);
                Cart item = new Cart();
                item.setProduct(product);
                item.setCustomer(customer);
                item.setQuantity(1);
                cartItem.add(item);
                cartDao.insert(item);
            }

            for (Cart item : cartItem) {
                System.out.println(item.getProduct().getProductName());
            }
            url = "ThucDon";
        } else if (action.equals("view")) {
            url = "cart.jsp";
        }

        session.setAttribute("cartItem", cartItem);
        session.setAttribute("totalProduct", getTotalProduct(cartItem));
        session.setAttribute("totalAmount", getTotalAmount(cartItem));
        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private boolean isLogin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("cus");
        if (customer == null) {
            return false;
        }
        return true;
    }

    private int getTotalProduct (List<Cart> cartItem) {
        int total = 0;
        for (Cart item : cartItem) {
            total = total + item.getQuantity();
        }
        return total;
    }
    
    private BigDecimal getTotalAmount (List<Cart> cartItem) {
        BigDecimal total = new BigDecimal(0.00);
        for (Cart item : cartItem) {
            BigDecimal price = item.getProduct().getPrice();
            BigDecimal temp = price.multiply(BigDecimal.valueOf(item.getQuantity()));
            total = total.add(temp);
        }
        
        return total;
    }
}
