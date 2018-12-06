package com.hxsb.service.BUY_ERP_GET_REFUND_RECORD;

import java.util.List;

import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord;

public interface BUY_ERP_GET_REFUND_RECORD_Service {  
	public List<RefundRecord> selectData(String erp_order_id);
}  