package com.zy.Dao;

import java.sql.SQLException;

import com.zy.entity.User;

public interface UserDao {
	
	boolean selectUserName(User user) throws SQLException;
	int selectUser(User user) throws SQLException;
	int insertUser(User user) throws SQLException;
}
