package org.hgq;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hgq.mapper.UsersMapper;
import org.hgq.pojo.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MyTest {

    //日期格式化工具
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    SqlSession sqlSession;
    UsersMapper mapper;
    @Before
    public void openSqlSession() throws IOException {
        //1、读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、取出sqlSession
        sqlSession = factory.openSession();

        //4、获取UserMapper的动态代理对象
        mapper = sqlSession.getMapper(UsersMapper.class);
    }
    @After
    public void closeSqlSession(){
        sqlSession.close();
    }

    @Test
    public void testGetAll(){
//        sqlSession.selectList("")  //老方法

        // 新方法：取出动态代理的对象，完成接口中方法的调用，实则是调用xml文件中相应的标签的功能

        //1、获取动态代理对象
        //2、调用方法
        List<Users> list = mapper.getAll();
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testGetNameById(){
        Users user = mapper.getNameById(7);
        System.out.println(user);
    }
    @Test
    public void testGetInfoMoHu(){

        List<Users> users = mapper.getInfoMoHu("张");
        users.forEach(users1 -> System.out.println(users1));
    }
    @Test
    public void testUpdate() throws ParseException {
        int num = mapper.update(new Users(7,"何国庆",sf.parse("1998-10-01"),"2","重庆市"));
        System.out.println(num);

        //切记手工提交事务
        sqlSession.commit();
    }
    @Test
    public void testDelete(){
        int res = mapper.delete(2);
        System.out.println(res);
        sqlSession.commit();
    }
    @Test
    public void testInsert() throws ParseException {
        Users user = new Users("yyyyyyyyyyy", sf.parse("1998-10-01"), "2", "重庆市");
        System.out.println(user);
        System.out.println("---------------");
        int insert = mapper.insert(user);
        System.out.println(user);
        sqlSession.commit();
    }

    @Test
    public void testGetByNameOrAddress(){
        List<Users> byNameOrAddress = mapper.getByNameOrAddress("address", "庆");
        byNameOrAddress.forEach(users -> System.out.println(users));

    }

    @Test
    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-",""));
    }


    @Test
    public void testCache(){
        //第一次取id=5的用户
        Users u1 = mapper.getNameById(5);
        System.out.println("第一次取出用户+"+u1);
        System.out.println("*************");
        Users u2 = mapper.getNameById(5);
        System.out.println("第二次取出用户+"+u2);
        System.out.println(u1==u2);


    }
}
