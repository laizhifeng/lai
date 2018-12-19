package com.zy.Dao;

import java.sql.SQLException;
import java.util.List;

import com.zy.entity.HouseInfo;
import com.zy.entity.HouseSelect;

public interface HouseDao {
	List<HouseSelect> HouseSelectAll() throws SQLException;
	List<HouseSelect> HouseSelectByField(String field) throws SQLException;
	HouseInfo ShowSouseInfo(int h_id) throws SQLException;
	int HouseInsert(HouseInfo house) throws SQLException;
	int HouseUpdata(HouseInfo house) throws SQLException;
	int HouseDelete(int h_id) throws SQLException;
	int HouseDeleteBatch(String[] arr) throws SQLException;
}
