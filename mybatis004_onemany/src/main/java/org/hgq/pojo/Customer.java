package org.hgq.pojo;

import java.util.List;

public class Customer {
    private Integer id;
    private String name;
    private Integer age;

    //该客户下的所有订单集合，一方持有多方的集合
    private List<Order> orders;


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", orders=" + orders +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer(Integer id, String name, Integer age, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.orders = orders;
    }

    public Customer() {
    }
}
