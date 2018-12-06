package com.hxsb.dao.BUY_ERP_GET_ORDERS;

import com.hxsb.model.BUY_ERP_GET_ORDERS.CP_HX02_Customer;

public interface CP_HX02_Customer_Dao {
    int insert(CP_HX02_Customer record);
    int insertSelective(CP_HX02_Customer record);
}