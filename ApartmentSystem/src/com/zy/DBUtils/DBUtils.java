package com.zy.DBUtils;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String Url = "jdbc:mysql://127.0.0.1:3306/apartment";
	private static final String UserName = "root";
	private static final String PassWord = "123456";

	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setDriverClassName(Driver);
		dataSource.setUrl(Url);
		dataSource.setUsername(UserName);
		dataSource.setPassword(PassWord);
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}
