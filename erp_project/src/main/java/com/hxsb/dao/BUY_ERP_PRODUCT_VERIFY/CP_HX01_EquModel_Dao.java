package com.hxsb.dao.BUY_ERP_PRODUCT_VERIFY;

import java.util.List;
import com.hxsb.model.BUY_ERP_PRODUCT_VERIFY.CP_HX01_EquModel;

public interface CP_HX01_EquModel_Dao {
	List<CP_HX01_EquModel> selectData(String product_erp_number);
	Long selectIdByCode(String code);
}