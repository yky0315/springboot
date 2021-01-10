package com.oracle.mapper;

import com.oracle.pojo.Users;
import com.oracle.pojo.UsersExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UsersMapper {
    @Select("select * from users where loginname=#{loginname} and pwd=#{pwd}")
    Users findUser(@Param("loginname") String loginname,@Param("pwd") String pwd);

    @Update("update users set status='Y' where loginname=#{loginname}")
    void updateUserStatus(@Param("loginname") String loginname);
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}