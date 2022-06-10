package org.hgq;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hgq.pojo.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    SqlSession sqlSession;

    @Before //在所有的@Test方法执行前先执行的代码
    public void openSqlSession() throws IOException {
        //使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //取出sqlSession对象
        sqlSession = factory.openSession();
    }

    @After//在所有的@Test方法执行前先执行的代码
    public void closeSqlSession() throws IOException {
        sqlSession.close();
    }


    @Test
    public void testGetAll() throws IOException {


        //完成查询操作
        List<Student> studentList = sqlSession.selectList("zar.getAll");
        studentList.forEach(student -> System.out.println(student));

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetById() throws IOException {

        //完成查询操作(按照主键查询学生)
        Student student = sqlSession.selectOne("zar.getById",1);
        System.out.println(student);

    }

    @Test
    public void testGetByName() throws IOException {


        //4、完成查询操作
        List<Student> studentList = sqlSession.selectList("zar.getByName", "zha");
        studentList.forEach(student -> System.out.println(student));


    }

    @Test
    public void testInsert() throws IOException {


        //4、完成插入操作
        int num = sqlSession.insert("zar.insert", new Student("heguoqing99", "haha@qq.com", 24));

        //切记切记：在所有增删改后必须手工提交事务
        sqlSession.commit();



    }

    @Test
    public void testDelete() throws IOException {


        //4、完成删除操作
        int num = sqlSession.delete("zar.delete", 3);

        //切记切记：在所有增删改后必须手工提交事务
        sqlSession.commit();



    }

    @Test
    public void testUpdate() throws IOException {


        //4、完成更新操作
        int num = sqlSession.update("zar.update", new Student(6,"wangjiaer","wangjiaer@qq.com",30));
        System.out.println(num);

        //切记切记：在所有增删改后必须手工提交事务
        sqlSession.commit();


    }
}
