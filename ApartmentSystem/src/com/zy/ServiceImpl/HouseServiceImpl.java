package com.zy.ServiceImpl;


import java.sql.SQLException;
import java.util.List;

import com.zy.Dao.HouseDao;
import com.zy.DaoImpl.HouseDaoImpl;
import com.zy.Service.HouseService;
import com.zy.entity.HouseInfo;
import com.zy.entity.HouseSelect;

public class HouseServiceImpl implements HouseService {
	private HouseDao houseDao;
	
	public HouseDao getHouseDao() {
		return houseDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

	@Override
	public List<HouseSelect> HouseSelectAll() {
		List<HouseSelect> houseList = null;
		try {
			houseList = houseDao.HouseSelectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return houseList;
	}

	@Override
	public List<HouseSelect> HouseSelectByField(String field){
		List<HouseSelect> houseList=null;
		try {
			houseList = houseDao.HouseSelectByField(field);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return houseList;
	}

	@Override
	public int HouseInsert(HouseInfo house) throws SQLException {
		int rs = houseDao.HouseInsert(house);
		return rs;
	}

	@Override
	public int HouseUpdata(HouseInfo house) throws SQLException {
		int rs = houseDao.HouseUpdata(house);
		return rs;
	}

	@Override
	public int HouseDelete(int h_id) throws SQLException {
		int rs = houseDao.HouseDelete(h_id);
		return rs;
	}

	@Override
	public HouseInfo ShowSouseInfo(int h_id) throws SQLException {
		
		return houseDao.ShowSouseInfo(h_id);
	}

	@Override
	public int HouseDeleteBatch(String[] arr) throws SQLException {
		return houseDao.HouseDeleteBatch(arr);
	}	
}
