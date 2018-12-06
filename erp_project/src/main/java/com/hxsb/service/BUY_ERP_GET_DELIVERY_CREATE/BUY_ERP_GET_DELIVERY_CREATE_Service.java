package com.hxsb.service.BUY_ERP_GET_DELIVERY_CREATE;

import java.util.List;

import com.hxsb.model.BUY_ERP_GET_DELIVERY_CREATE.ReceiptRecord;

public interface BUY_ERP_GET_DELIVERY_CREATE_Service {  
	public List<ReceiptRecord> selectData(String data);
}  