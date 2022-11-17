/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    
    @Column(name = "product_name")
    private String productName;

    @Column
    private BigDecimal price;

    @Column
    private String image;

    @Column
    private String description;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Cart> carts;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<DetailInvoice> detailInvoices;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<DetailInvoice> getDetailInvoices() {
        return detailInvoices;
    }

    public void setDetailInvoices(Set<DetailInvoice> detailInvoices) {
        this.detailInvoices = detailInvoices;
    }
   
    
    
}
