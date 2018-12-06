package com.hxsb.dao.css;

import java.util.HashMap;
import java.util.Map;

import com.hxsb.model.css.S_AutoNumber;

public interface S_AutoNumber_Dao {
	S_AutoNumber selectNumber(String strObjName);
	void updateBySelective(HashMap<String, Object> map);
	
}