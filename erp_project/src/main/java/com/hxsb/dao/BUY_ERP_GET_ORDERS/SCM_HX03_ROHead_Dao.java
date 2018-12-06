package com.hxsb.dao.BUY_ERP_GET_ORDERS;

import java.util.List;
import java.util.Map;
import com.hxsb.model.BUY_ERP_GET_DELIVERY_CREATE.ReceiptRecord;
import com.hxsb.model.BUY_ERP_GET_ORDERS.ChangeLog;
import com.hxsb.model.BUY_ERP_GET_ORDERS.Contact;
import com.hxsb.model.BUY_ERP_GET_ORDERS.OrderRecord;
import com.hxsb.model.BUY_ERP_GET_ORDERS.OrderRecordDetail;

public interface SCM_HX03_ROHead_Dao {
	List<OrderRecord> selectData(Map<String, Object> map);
	Integer selectTotalAmout(Map<String, Object> map);
	List<OrderRecord> selectByNameAndMobile(Map<String, Object> map);
	List<OrderRecordDetail> selectDetailByBillID(String billNo);
	List<ChangeLog> selectChangeLogsByBillID(String billNo);
	List<Contact> selectContactsByBillID(String billNo);
	List<ReceiptRecord> selectDataByBillID0(List<Long> billids);
	List<ReceiptRecord> selectDataByBillID1(List<Long> billids);
	
	
}