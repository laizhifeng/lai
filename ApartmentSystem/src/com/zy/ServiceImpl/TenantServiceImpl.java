package com.zy.ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import com.zy.Dao.TenantDao;
import com.zy.DaoImpl.TenantDaoImpl;
import com.zy.Service.TenantService;
import com.zy.entity.Tenant;
import com.zy.entity.TenantList;

public class TenantServiceImpl implements TenantService {
	private TenantDao tenantDao;
	List<TenantList> tenantList;
	List<Tenant> tenantShow;
	int rs;
	
	public TenantDao getTenantDao() {
		return tenantDao;
	}

	public void setTenantDao(TenantDao tenantDao) {
		this.tenantDao = tenantDao;
	}

	@Override
	public List<TenantList> selectAll() {
		try {
			tenantList = tenantDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenantList;
	}

	@Override
	public List<TenantList> selectByField(String field) {
		try {
			tenantList = tenantDao.selectByField(field);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenantList;
	}

	@Override
	public List<Tenant> showTenantInfo(int t_id) {
		try {
			tenantShow = tenantDao.showTenantInfo(t_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenantShow;
	}

	@Override
	public int addTenant(Tenant tenant) {
		try {
			rs = tenantDao.addTenant(tenant);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int updateTenant(Tenant tenant) throws SQLException {
		
		return tenantDao.updateTenant(tenant);
	}

	@Override
	public int deleteTenant(int t_id, int h_id) {
		try {
			rs = tenantDao.deleteTenant(t_id, h_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int deleteTenantBatch(String[] arr) throws SQLException {
		return tenantDao.deleteTenantBatch(arr);
	}

}
