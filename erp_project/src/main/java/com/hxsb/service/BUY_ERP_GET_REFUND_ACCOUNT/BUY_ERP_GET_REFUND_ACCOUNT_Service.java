package com.hxsb.service.BUY_ERP_GET_REFUND_ACCOUNT;

import java.util.List;

import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord2;

public interface BUY_ERP_GET_REFUND_ACCOUNT_Service {  
	public List<RefundRecord2> selectData(String time);
}  