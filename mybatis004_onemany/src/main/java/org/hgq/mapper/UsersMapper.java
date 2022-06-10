package org.hgq.mapper;

import org.apache.ibatis.annotations.Param;
import org.hgq.pojo.Users;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    //按指定的条件进行多条件查询
    List<Users> getByConditions(Users users);


    //有选择的更新
    int updateBySet(Users users);

    //查询指定id的用户信息
    List<Users> getByIds(Integer[] arr);

    //批量删除
    int deleteByIds(Integer[] arr);

    //批量增加
    int insertBatch(List<Users> usersList);

    //查询指定日期范围内的用户信息.
    List<Users> getByBirthday(Date begin, Date end);

    //入参是map
    List<Users> getByMap(Map map);

    //返回值是map(一行)
    Map getReturnMap(Integer id);

    //返回多行的map
    List<Map> getMulMap();
}
