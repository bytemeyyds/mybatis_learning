package org.hgq.mapper;

import org.apache.ibatis.annotations.Param;
import org.hgq.pojo.Users;

import java.util.List;

/**
 * 数据访问层的接口，规定的数据库可进行的各种操作
 */
public interface UsersMapper {
    // 查询全部用户信息
    List<Users> getAll();

    //根据用户主键查询用户
    Users getNameById(Integer id);

    // 模糊查询
    List<Users> getInfoMoHu(String s);

    //优化后的模糊查询
    List<Users> getInfoMoHu2(String s);

    //用户更新
    int update(Users user);

    //删除用户
    int delete(Integer id);

    //新增用户
    int insert(Users user);

    //模糊用户名和地址查询
    List<Users> getByNameOrAddress(
            @Param("columnName")
            String columnName,
            @Param("columnValue")
            String columnValue);
}
