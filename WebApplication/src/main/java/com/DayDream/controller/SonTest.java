package com.DayDream.controller;

import com.DayDream.model.dao.CartDao;
import com.DayDream.model.dao.CustomerDao;
import com.DayDream.model.entity.Cart;
import com.DayDream.model.entity.Customer;
import com.DayDream.model.entity.Product;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SonTest {

    public static void main(String[] args) throws SQLException {

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        for (int item : list) {
            if (item == 2) {
                System.out.println(item);
                list.remove(item);       
                break;
            }       
        }
    }
}
