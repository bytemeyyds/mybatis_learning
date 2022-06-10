package org.hgq.mapper;

import org.hgq.pojo.Customer;

public interface CustomerMapper {

    //根据客户id查询所有信息，并查询客户名下的所有订单
    Customer getById(Integer id);
}
