package com.hxsb.service.BUY_ERP_GET_PAYMENT_RECORD;

import java.util.List;

import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.PaymentRecord;

public interface BUY_ERP_GET_PAYMENT_RECORD_Service {  
	public List<PaymentRecord> selectData(String erp_order_id);
}  