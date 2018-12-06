package com.hxsb.dao.BUY_ERP_ORDER_CREATE;

import java.util.ArrayList;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.SCM_HX50_IntentionList3;

public interface SCM_HX50_IntentionList3_Dao {
	SCM_HX50_IntentionList3 selectDetailByBillID(Long billid);
	/**
	 * 批量新增
	 * @param bean
	 */
	public void batchAdd(ArrayList<SCM_HX50_IntentionList3> bean);
	public void insert(SCM_HX50_IntentionList3 bean);
}