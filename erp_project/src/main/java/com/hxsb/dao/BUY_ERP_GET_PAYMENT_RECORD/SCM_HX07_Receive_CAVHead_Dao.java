package com.hxsb.dao.BUY_ERP_GET_PAYMENT_RECORD;

import java.util.ArrayList;
import java.util.List;
import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.PaymentRecord;
import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.PaymentRecord2;
import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.SCM_HX07_Receive_CAVHead;

public interface SCM_HX07_Receive_CAVHead_Dao {
	List<PaymentRecord> selectData(ArrayList<String> erp_order_ids);
	List<SCM_HX07_Receive_CAVHead> selectBillidBySerialNo(String SerialNo);
	void insert(SCM_HX07_Receive_CAVHead bean);
    List<PaymentRecord2> selectDataByTime(String time);
    
}