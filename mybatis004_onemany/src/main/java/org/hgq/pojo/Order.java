package org.hgq.pojo;

import java.util.List;

public class Order {
    private Integer id;
    private String orderNumber;
    private double orderPrice;

    //关联此订单的客户信息，多方持有一方的对象
    private Customer customer;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderPrice=" + orderPrice +
                ", customer=" + customer +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order(Integer id, String orderNumber, double orderPrice, Customer customer) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.customer = customer;
    }

    public Order() {
    }
}
