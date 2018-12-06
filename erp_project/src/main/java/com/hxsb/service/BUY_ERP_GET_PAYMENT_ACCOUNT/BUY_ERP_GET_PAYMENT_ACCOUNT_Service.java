package com.hxsb.service.BUY_ERP_GET_PAYMENT_ACCOUNT;

import java.util.List;

import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.PaymentRecord2;

public interface BUY_ERP_GET_PAYMENT_ACCOUNT_Service {  
	public List<PaymentRecord2> selectData(String time);
}  