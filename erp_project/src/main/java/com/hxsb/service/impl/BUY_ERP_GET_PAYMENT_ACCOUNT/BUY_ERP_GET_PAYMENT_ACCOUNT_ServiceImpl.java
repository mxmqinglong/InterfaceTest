package com.hxsb.service.impl.BUY_ERP_GET_PAYMENT_ACCOUNT;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxsb.dao.BUY_ERP_GET_PAYMENT_RECORD.SCM_HX07_Receive_CAVHead_Dao;
import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.PaymentRecord2;
import com.hxsb.service.BUY_ERP_GET_PAYMENT_ACCOUNT.BUY_ERP_GET_PAYMENT_ACCOUNT_Service;
import com.hxsb.util.PayWayEnum;
  
  
@Service("buy_ERP_GET_PAYMENT_ACCOUNT_Service")  
public class BUY_ERP_GET_PAYMENT_ACCOUNT_ServiceImpl implements BUY_ERP_GET_PAYMENT_ACCOUNT_Service { 
	@Autowired
	private SCM_HX07_Receive_CAVHead_Dao scm_HX07_Receive_CAVHead_Dao;

	public List<PaymentRecord2> selectData(String time) {
		List<PaymentRecord2> paymentRecord2List = scm_HX07_Receive_CAVHead_Dao.selectDataByTime(time);
		if(paymentRecord2List.size() > 0){
			for(PaymentRecord2 paymentRecord2:paymentRecord2List){
				paymentRecord2.setPay_way(PayWayEnum.explainByCode(paymentRecord2.getPay_way()));
			}
		}
		return paymentRecord2List;
	}
}  
