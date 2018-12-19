package com.zy.Dao;

import java.sql.SQLException;

import java.util.List;

import com.zy.entity.Tenant;
import com.zy.entity.TenantList;

public interface TenantDao {
	List<TenantList> selectAll() throws SQLException;
	List<TenantList> selectByField(String field) throws SQLException;
	List<Tenant> showTenantInfo(int t_id) throws SQLException;
	int addTenant(Tenant tenant) throws SQLException;
	int updateTenant(Tenant tenant) throws SQLException;
	int deleteTenant(int t_id,int h_id) throws SQLException;
	int deleteTenantBatch(String[] arr) throws SQLException;
}
