package com.hxsb.dao.css;

import java.util.HashMap;
import java.util.List;

import com.hxsb.model.css.GP_BILL_NO_RUNNING;

public interface GP_BILL_NO_RUNNING_Dao {
	List<GP_BILL_NO_RUNNING> selectData(HashMap<String, Object> map);
	Integer selectMaxNumber(HashMap<String, Object> map);
	void updateBySelective(HashMap<String, Object> map);
	void insert(GP_BILL_NO_RUNNING record);
	List<GP_BILL_NO_RUNNING> selectData1(HashMap<String, Object> map);
	Integer selectMaxNumber1(HashMap<String, Object> map);
	void updateBySelective1(HashMap<String, Object> map);
}