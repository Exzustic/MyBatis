package com.springstudy.mybatisdemo.mapper;

import com.springstudy.mybatisdemo.module.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from sales")
    List<User> showUsers();

    @Select("select * from sales where id = #{id}")
    User showUserById(int id);

    @Select("SELECT name, CONCAT(ROUND(sales/(\n" +
            "    SELECT SUM(sales)\n" +
            "    FROM sales\n" +
            "    ) * 100 , 2),'%') AS persent\n" +
            "FROM sales;\n")
    List<List<String>> show();

    @Insert("insert into sales(name,sales) values (#{name},#{sales})")
    void insert(User user);

    @Update("update sales\n" +
            "set name=#{name}, sales = #{sales}\n" +
            "WHERE id = #{id};")
    void update(User user);

    @Delete("delete from sales where id=#{id}")
    void delete(int id);


    @Select("select count(*) from sales")
    int count();


}
