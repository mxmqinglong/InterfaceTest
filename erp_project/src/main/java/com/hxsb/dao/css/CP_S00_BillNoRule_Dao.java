package com.hxsb.dao.css;

import java.util.List;

import com.hxsb.model.css.CP_S00_BillNoRule;

public interface CP_S00_BillNoRule_Dao {
	List<CP_S00_BillNoRule> selectRules(String strObjName);
}