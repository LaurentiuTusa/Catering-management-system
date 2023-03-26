package com.business_logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private int ordeId;
    private String clientName;
    private Date orderDate;
   // private List<MenuItems> productList;

    public Order(int ordeId, String clientName, Date orderDate/*, List<MenuItems> productList*/) {
        this.ordeId = ordeId;
        this.clientName = clientName;
        this.orderDate = orderDate;
    //    this.productList = productList;
    }

    public int getOrdeId() {
        return ordeId;
    }

    public void setOrdeId(int ordeId) {
        this.ordeId = ordeId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

//    public List<MenuItems> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<MenuItems> productList) {
//        this.productList = productList;
//    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int cost(List<MenuItem> productList) {
        int sum = 0;
        for (MenuItem m:productList) {
            sum += m.getPrice();
        }
        return sum;
    }

    public String bodyToString() {
        return String.valueOf(getOrdeId()) + "," + getClientName() + "," + String.valueOf(getOrderDate());
    }

//    public String listToString(List<MenuItems> list) {
//
//    }

}
