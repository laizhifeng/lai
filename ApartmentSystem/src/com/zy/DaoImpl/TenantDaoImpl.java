package com.zy.DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zy.DBUtils.DBUtils;
import com.zy.Dao.TenantDao;
import com.zy.entity.HouseInfo;
import com.zy.entity.Tenant;
import com.zy.entity.TenantList;

public class TenantDaoImpl implements TenantDao {
	private static QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
	private static String sql;
	@Override
	public List<TenantList> selectAll() throws SQLException {
		sql = "select t.t_id,t.t_name, h.h_address from tenant t inner join house h where t.h_id = h.h_id";
		List<TenantList> list = qr.query(sql, new BeanListHandler<>(TenantList.class));
		return list;
	}

	@Override
	public List<TenantList> selectByField(String field) throws SQLException {
		sql = "select t.t_id,t.t_name, h.h_address from tenant t inner join house h "
				+ "where (t.t_id=? or t.t_id like ? or h.h_address like ? or h.h_address like ?) and t.h_id = h.h_id";
		Object[] params = {field,"%"+field+"%","%"+field+"%",field+"%"};
		List<TenantList> list = qr.query(sql, new BeanListHandler<>(TenantList.class),params);
		return list;
	}
	
	@Override
	public List<Tenant> showTenantInfo(int t_id) throws SQLException {
		sql = "select * from tenant where t_id = ?";
		List<Tenant> list = qr.query(sql, new BeanListHandler<>(Tenant.class), t_id);
		return list;
	}
	
	@Override
	public int addTenant(Tenant tenant) throws SQLException {
		
		int rs = 0;		
		if(foundH_id(tenant.getH_id())){
			sql = "insert into tenant (t_name,t_phone,t_sex,t_native,t_IDnumber,h_id,t_addtime,t_updatetime)"
					+ "values(?,?,?,?,?,?,now(),now())";
			Object[] params = {tenant.getT_name(),tenant.getT_phone(),tenant.getT_sex(),
						tenant.getT_native(),tenant.getT_IDnumber(),tenant.getH_id()};
			rs = qr.update(sql, params);
			whenUpdateStatus(tenant.getH_id());
		}else{
			rs = 2;
		}
		return rs;
	}

	@Override
	public int updateTenant(Tenant tenant) throws SQLException {
		UpdateOldStatus(tenant.getH_id());
		sql = "update tenant set t_name = ?, t_phone = ?, t_sex = ?, t_native = ?,"
				+ "t_IDnumber = ?, h_id = ?, t_updatetime = now() where t_id = ?";
		Object[] params = {tenant.getT_name(),tenant.getT_phone(),tenant.getT_sex(),tenant.getT_native(),
							tenant.getT_IDnumber(),tenant.getH_id(),tenant.getT_id()};
		
		int rs = qr.update(sql, params);
		whenUpdateStatus(tenant.getH_id());
		return rs;
	}

	@Override
	public int deleteTenant(int t_id,int h_id) throws SQLException {
		whenDeleteStatus(h_id);
		sql = "delete from tenant where t_id = ?";
		int rs = qr.update(sql, t_id);
		return rs;
	}
	
	public static void UpdateOldStatus(int t_id) throws SQLException{
		sql = "update house set h_status = 0 where h_id in"
				+ "(select h_id from tenant where t_id =?)";
		qr.update(sql, t_id);
	}
	public static void whenUpdateStatus(int h_id) throws SQLException {
		sql = "update house set h_status = 1 where h_id = ?";
		qr.update(sql, h_id);
	}
	public static void whenDeleteStatus(int h_id) throws SQLException {
		sql = "update house set h_status = 0 where h_id = ?";
		qr.update(sql, h_id);
	}
	public static boolean foundH_id(int h_id) throws SQLException{
		sql = "select h_id from house where h_id = ?";
		Object obj = qr.query(sql,new BeanHandler<>(HouseInfo.class),h_id);
		boolean result = false;
		if(obj != null){
			result = true;
		}
		return result;	
	}

	@Override
	public int deleteTenantBatch(String[] arr) throws SQLException {
		int result = 0;
		sql = "delete from tenant where t_id = ?";
		for(String i : arr){
			int rs = qr.update(sql,i);
			if(rs == 1){
				result++;
			}
		}	
		return result;
	}
}
