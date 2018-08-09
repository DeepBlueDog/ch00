package com.bobby.loansystem.admin.Dao;

import com.bobby.loansystem.admin.Domain.User;

import java.sql.SQLException;

public interface IUserDAO {
     User find(String username); //��ѯ�˺�
     void update(User user); //�޸��˺���Ϣ
     void remove(User user); //ɾ���˺���Ϣ
     void create(User user) throws SQLException;  //�����û�
}
