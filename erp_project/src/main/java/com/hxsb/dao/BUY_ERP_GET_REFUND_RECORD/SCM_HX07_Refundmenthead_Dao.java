package com.hxsb.dao.BUY_ERP_GET_REFUND_RECORD;

import java.util.ArrayList;
import java.util.List;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord2;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundmenthead;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.SMSTemplate;

public interface SCM_HX07_Refundmenthead_Dao {
	List<RefundRecord> selectData(ArrayList<String> erp_order_ids);
	SCM_HX07_Refundmenthead selectByBillId(Long billid);
	void updateBySelective(SCM_HX07_Refundmenthead bean);
	List<RefundRecord2> selectDataByTime(String time);
	List<SMSTemplate> selectSMSByBillId(Long billid);
}