/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import com.DayDream.model.dao.CartDao;
import com.DayDream.model.entity.Cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/UpdateCart")
public class UpdateCartServlet extends HttpServlet {    
    private CartDao cartDao;
    @Override
    public void init() throws ServletException {
        super.init(); 
        cartDao = new CartDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Cart> cartItem = new ArrayList<Cart>();
        cartItem = (List<Cart>) session.getAttribute("cartItem"); 
        int productId = Integer.parseInt(request.getParameter("productId"));
        int customerId = (int) session.getAttribute("customerId");
        
        String action = request.getParameter("action");
        if (action.equals("add")) {
            cartItem = updateQuantity(cartItem, productId, customerId, true);
        } else if (action.equals("substract")) {       
            cartItem = updateQuantity(cartItem, productId, customerId, false);
        } else {
            cartItem = deleteItemCart(cartItem, productId, customerId);
        }
        session.setAttribute("cartItem", cartItem);
        response.sendRedirect("Cart?action=view");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    
    
    private List<Cart> updateQuantity(List<Cart> cartItem, int productId, int customerId, boolean isAdd) {
        for (Cart item : cartItem) {
            if (item.getProduct().getProductID() == productId && item.getCustomer().getCustomerID() == customerId) {
                if (isAdd) {
                    item.setQuantity(item.getQuantity() + 1);
                    cartDao.update(item);
                }else {                  
                    if (item.getQuantity() == 1) {
                        cartDao.delete(item);
                        cartItem.remove(item);
                    }
                    else {
                        item.setQuantity(item.getQuantity() - 1);
                        cartDao.update(item);
                    }
                }           
                break;
            }
        }
        return cartItem;
    }
    
    private List<Cart> deleteItemCart(List<Cart> cartItem, int productId, int customerId) {
        for (Cart item : cartItem) {
            if (item.getProduct().getProductID() == productId && item.getCustomer().getCustomerID() == customerId) {
                cartDao.delete(item);
                cartItem.remove(item);
            }
            break;
        }
        return cartItem;
    }
}
