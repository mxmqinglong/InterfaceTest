package com.hxsb.dao.BUY_ERP_ORDER_CREATE;

import com.hxsb.model.BUY_ERP_ORDER_CREATE.GP_Operator;

public interface GP_Operator_Dao {
	GP_Operator selectByADAccount(String adAccount);
}