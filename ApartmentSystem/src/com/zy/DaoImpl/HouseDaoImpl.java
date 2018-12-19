package com.zy.DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zy.DBUtils.DBUtils;
import com.zy.Dao.HouseDao;
import com.zy.entity.HouseInfo;
import com.zy.entity.HouseSelect;

public class HouseDaoImpl implements HouseDao {

	private static QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
	private static String sql;

	@Override
	public List<HouseSelect> HouseSelectAll() throws SQLException {
		sql = "select h_id,h_address from house";
		List<HouseSelect> list = qr.query(sql, new BeanListHandler<>(HouseSelect.class));
		return list;
	}

	@Override
	public List<HouseSelect> HouseSelectByField(String filed) throws SQLException {
		sql = "select h_id,h_address from house where h_region like ? or h_estate like ? or h_address like ?";
		Object[] param = { filed+"%", filed+"%", "%"+filed+"%" };
		List<HouseSelect> 
		list = qr.query(sql, new BeanListHandler<>(HouseSelect.class),param);
		return list;
	}

	@Override
	public int HouseInsert(HouseInfo house) throws SQLException {
		int rs = 0;
		sql = "select * from house where h_region = ? and h_estate = ? and h_unitNumber = ? and h_roomNo = ? ";
		Object[] param = { house.getH_region(), house.getH_estate(), house.getH_unitNumber(), house.getH_roomNo() };
		HouseInfo h = qr.query(sql, new BeanHandler<>(HouseInfo.class), param);
		if (h == null) {
			sql = "insert into house values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),now())";
			Object[] params = { house.getH_region(),house.getH_estate(),house.getH_unitNumber(),house.getH_roomNo(),
					house.getH_area(),house.getH_orientation(),house.getH_fitment(),house.getH_isDoubleAir(),
					house.getH_limit(),house.getH_facility(),house.getH_price(),house.getH_status(),house.getH_img(),
					house.getH_address() };
			rs = qr.update(sql, params);
		}
		return rs;
	}

	@Override
	public int HouseUpdata(HouseInfo house) throws SQLException {
		
		sql = "update house set h_region = ?,h_estate=?,h_unitNumber=?,h_roomNo=?,h_area=?,h_orientation=?,"
				+ "h_fitment=?,h_isDoubleAir=?,h_limit=?,h_facility=?,h_price=?,h_status=?,h_img=?,h_address=?,"
				+ "h_updatetime=now() where h_id = ?";
		Object[] params = {house.getH_region(),house.getH_estate(),house.getH_unitNumber(),house.getH_roomNo(),
							house.getH_area(),house.getH_orientation(),house.getH_fitment(),house.getH_isDoubleAir(),
							house.getH_limit(),house.getH_facility(),house.getH_price(),house.getH_status(),house.getH_img(),
							house.getH_address(),house.getH_id()};
		int rs = qr.update(sql, params);
		
		return rs;
	}

	@Override
	public int HouseDelete(int h_id) throws SQLException {
		
		sql = "delete from house where h_id = ?";
		int rs = qr.update(sql,h_id);
		return rs;
	}

	@Override
	public HouseInfo ShowSouseInfo(int h_id) throws SQLException {
		sql = "select * from house where h_id = ?";
		HouseInfo list = qr.query(sql, new BeanHandler<>(HouseInfo.class),h_id);
		
		return list;
	}

	@Override
	public int HouseDeleteBatch(String[] arr) throws SQLException {
		int result = 0;
		sql = "delete from house where h_id = ?";
		for(String i : arr){
			int rs = qr.update(sql,i);
			if(rs == 1){
				result++;
			}
		}	
		return result;
	}
}
