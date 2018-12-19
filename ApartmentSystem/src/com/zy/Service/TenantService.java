package com.zy.Service;


import java.sql.SQLException;
import java.util.List;

import com.zy.entity.Tenant;
import com.zy.entity.TenantList;

public interface TenantService {
	List<TenantList> selectAll();
	List<TenantList> selectByField(String field);
	List<Tenant> showTenantInfo(int t_id);
	int addTenant(Tenant tenant);
	int updateTenant(Tenant tenant) throws SQLException;
	int deleteTenant(int t_id,int h_id);
	int deleteTenantBatch(String[] arr) throws SQLException;
}
