package com.zy.ServiceImpl;

import java.sql.SQLException;

import com.zy.Dao.UserDao;
import com.zy.DaoImpl.UserDaoImpl;
import com.zy.Service.UserService;
import com.zy.entity.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
		
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int Login(User user) {
		
		int rs = 0;
		try {
			rs = userDao.selectUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;
	}

	@Override
	public int SignIn(User user) {
		int rs = 0;
		try {
			rs = userDao.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

}
