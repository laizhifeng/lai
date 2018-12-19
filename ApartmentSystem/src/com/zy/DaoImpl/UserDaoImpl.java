package com.zy.DaoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zy.DBUtils.DBUtils;
import com.zy.Dao.UserDao;
import com.zy.entity.User;

public class UserDaoImpl implements UserDao {
	private static QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
	private static String sql;

	@Override
	public boolean selectUserName(User user) throws SQLException {
		sql = "select * from user where u_username = ?";
		Object[] param = { user.getUsername() };
		User u = qr.query(sql, new BeanHandler<>(User.class), param);
		if (u != null) {
			return true;
		}
		return false;
	}

	@Override
	public int selectUser(User user) throws SQLException {
		int rs = 0;
		if (selectUserName(user)) {
			sql = "select * from user where u_username = ? and u_password = ?";
			Object[] params = { user.getUsername(), user.getPassword() };
			User u = qr.query(sql, new BeanHandler<>(User.class), params);
			if (u == null) {
				rs = 1;
			} else {
				if (u.getStatus() == 0) {
					rs = 2;
				} else if (u.getStatus() == 1) {
					rs = 3;
				}
			}
		} else {
			rs = 0;
		}
		return rs;
	}

	@Override
	public int insertUser(User user) throws SQLException {

		int rs = 0;
		if (!selectUserName(user)) {
			sql = "insert into user(u_username,u_password) values(?,?)";
			Object[] params = { user.getUsername(), user.getPassword() };
			rs = qr.update(sql, params);
		}
		return rs;
	}
}
