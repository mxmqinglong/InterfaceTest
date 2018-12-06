package com.hxsb.service.BUY_ERP_PRODUCT_VERIFY;

import java.util.List;

import com.hxsb.model.BUY_ERP_PRODUCT_VERIFY.CP_HX01_EquModel;

public interface BUY_ERP_PRODUCT_VERIFY_Service {  
	public List<CP_HX01_EquModel> selectData(String product_erp_number);
}  