package com.bobby.loansystem.admin.Dao;

import com.bobby.loansystem.admin.Domain.User;

import java.sql.SQLException;

public interface IUserDAO {
     User find(String username); //查询账号
     void update(User user); //修改账号信息
     void remove(User user); //删除账号信息
     void create(User user) throws SQLException;  //增加用户
}
