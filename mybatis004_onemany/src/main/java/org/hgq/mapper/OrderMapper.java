package org.hgq.mapper;

import org.hgq.pojo.Order;

public interface OrderMapper {

    //根据主键查询订单，并同时查询此订单下的所有客户信息
    Order getById(Integer id);
}
