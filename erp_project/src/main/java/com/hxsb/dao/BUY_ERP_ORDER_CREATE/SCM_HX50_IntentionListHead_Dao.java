package com.hxsb.dao.BUY_ERP_ORDER_CREATE;

import java.util.List;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.IntentionTemporary;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.SCM_HX50_IntentionListHead;

public interface SCM_HX50_IntentionListHead_Dao {
	List<SCM_HX50_IntentionListHead> selectDataByReceiptsNumber(String receiptsnumber);
	void insert(SCM_HX50_IntentionListHead bean);
	List<IntentionTemporary> selectDataByBillId(Long billid);
}