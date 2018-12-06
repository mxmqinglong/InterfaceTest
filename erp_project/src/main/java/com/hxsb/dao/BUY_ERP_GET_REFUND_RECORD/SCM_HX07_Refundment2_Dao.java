package com.hxsb.dao.BUY_ERP_GET_REFUND_RECORD;

import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundment2;

public interface SCM_HX07_Refundment2_Dao {
	void updateBySelective(SCM_HX07_Refundment2 bean);
	int selectRefundStatusCountByBillId(Long billid);
	
}