package com.hxsb.service.impl.BUY_ERP_PRODUCT_VERIFY;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxsb.dao.BUY_ERP_GET_ORDERS.SCM_HX03_ROHead_Dao;
import com.hxsb.dao.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundmenthead_Dao;
import com.hxsb.dao.BUY_ERP_PRODUCT_VERIFY.CP_HX01_EquModel_Dao;
import com.hxsb.model.BUY_ERP_GET_ORDERS.ChangeLog;
import com.hxsb.model.BUY_ERP_GET_ORDERS.Contact;
import com.hxsb.model.BUY_ERP_GET_ORDERS.OrderRecord;
import com.hxsb.model.BUY_ERP_GET_ORDERS.OrderRecordDetail;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecordDetail;
import com.hxsb.model.BUY_ERP_PRODUCT_VERIFY.CP_HX01_EquModel;
import com.hxsb.service.BUY_ERP_GET_ORDERS.BUY_ERP_GET_ORDERS_Service;
import com.hxsb.service.BUY_ERP_GET_REFUND_RECORD.BUY_ERP_GET_REFUND_RECORD_Service;
import com.hxsb.service.BUY_ERP_PRODUCT_VERIFY.BUY_ERP_PRODUCT_VERIFY_Service;
  
  
@Service("buy_ERP_PRODUCT_VERIFY_Service")  
public class BUY_ERP_PRODUCT_VERIFY_ServiceImpl implements BUY_ERP_PRODUCT_VERIFY_Service { 
	@Autowired
	private CP_HX01_EquModel_Dao cp_HX01_EquModel_Dao;

	public List<CP_HX01_EquModel> selectData(String product_erp_number) {
		List<CP_HX01_EquModel> cp_HX01_EquModelList = cp_HX01_EquModel_Dao.selectData(product_erp_number);
		return cp_HX01_EquModelList;
	}
}  
