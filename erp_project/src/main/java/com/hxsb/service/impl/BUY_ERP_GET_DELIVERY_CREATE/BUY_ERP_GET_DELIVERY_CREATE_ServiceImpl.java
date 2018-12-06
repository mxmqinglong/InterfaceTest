package com.hxsb.service.impl.BUY_ERP_GET_DELIVERY_CREATE;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hxsb.dao.BUY_ERP_GET_ORDERS.SCM_HX03_ROHead_Dao;
import com.hxsb.model.BUY_ERP_GET_DELIVERY_CREATE.BUY_ERP_GET_DELIVERY_CREATE_Request;
import com.hxsb.model.BUY_ERP_GET_DELIVERY_CREATE.ReceiptRecord;
import com.hxsb.service.BUY_ERP_GET_DELIVERY_CREATE.BUY_ERP_GET_DELIVERY_CREATE_Service;
  
  
@Service("buy_ERP_GET_DELIVERY_CREATE_Service")  
public class BUY_ERP_GET_DELIVERY_CREATE_ServiceImpl implements BUY_ERP_GET_DELIVERY_CREATE_Service {
	@Autowired
	private SCM_HX03_ROHead_Dao scm_HX03_ROHead_Dao;
	
	
	public List<ReceiptRecord> selectData(String data) {
		JsonObject obj = new JsonParser().parse(data).getAsJsonObject();
		BUY_ERP_GET_DELIVERY_CREATE_Request bean = new Gson().fromJson(obj,BUY_ERP_GET_DELIVERY_CREATE_Request.class);
		List<Long> erp_order_ids = bean.getErp_order_ids();
		String delivery_type = bean.getDelivery_type();
		List<ReceiptRecord> receiptRecordList = null;
	    if("001".equals(delivery_type)){//进场交接
	    	receiptRecordList = scm_HX03_ROHead_Dao.selectDataByBillID0(erp_order_ids);
	    }else if("002".equals(delivery_type)){//退场交接
	    	receiptRecordList = scm_HX03_ROHead_Dao.selectDataByBillID1(erp_order_ids);
	    }
		return receiptRecordList;
	} 
	
	
  
}  
