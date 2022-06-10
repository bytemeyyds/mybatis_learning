package org.hgq;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hgq.mapper.CustomerMapper;
import org.hgq.mapper.OrderMapper;
import org.hgq.pojo.Customer;
import org.hgq.pojo.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyTest {

    //日期格式化工具
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    SqlSession sqlSession;
    OrderMapper mapper;
    @Before
    public void openSqlSession() throws IOException {
        //1、读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、取出sqlSession
        sqlSession = factory.openSession();

        //4、获取UserMapper的动态代理对象
        mapper = sqlSession.getMapper(OrderMapper.class);
    }
    @After
    public void closeSqlSession(){
        sqlSession.close();
    }

    @Test
    public void testGetOrderById(){
        Order order = mapper.getById(11);
        System.out.println(order);
    }




}
