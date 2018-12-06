package com.hxsb.service.impl.BUY_ERP_GET_PAYMENT_RECORD;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hxsb.dao.BUY_ERP_GET_PAYMENT_RECORD.SCM_HX07_Receive_CAVHead_Dao;
import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.PaymentRecord;
import com.hxsb.service.BUY_ERP_GET_PAYMENT_RECORD.BUY_ERP_GET_PAYMENT_RECORD_Service;
import com.hxsb.util.PayWayEnum;
  
  
@Service("buy_ERP_GET_PAYMENT_RECORD_Service")  
public class BUY_ERP_GET_PAYMENT_RECORD_ServiceImpl implements BUY_ERP_GET_PAYMENT_RECORD_Service { 
	
	@Autowired
	private SCM_HX07_Receive_CAVHead_Dao scm_HX07_Receive_CAVHead_Dao;

	public List<PaymentRecord> selectData(String erp_order_ids) {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray Jarray = parser.parse(erp_order_ids).getAsJsonArray();
		ArrayList<String> erp_order_idList = new ArrayList<String>();
		for(JsonElement obj : Jarray ){
			String cse = gson.fromJson( obj , String.class);
			erp_order_idList.add(cse);  
		}
		
		
		List<PaymentRecord> paymentRecordList = scm_HX07_Receive_CAVHead_Dao.selectData(erp_order_idList);
		for(PaymentRecord paymentRecord:paymentRecordList){
			if("40".equals(paymentRecord.getPay_type())){//线下
				paymentRecord.setName(paymentRecord.getReceiveAccount());//付款人 对方帐号
            } else{
            	paymentRecord.setName(paymentRecord.getSerialNo());//付款人 流水号
            }
			
			//转换付款方式编号
			paymentRecord.setPay_type(PayWayEnum.explainByCode(paymentRecord.getPay_type()));
		}
		
		return paymentRecordList;
	}
}  
