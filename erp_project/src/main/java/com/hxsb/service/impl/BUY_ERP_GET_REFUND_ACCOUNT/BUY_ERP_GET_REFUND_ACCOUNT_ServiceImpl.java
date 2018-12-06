package com.hxsb.service.impl.BUY_ERP_GET_REFUND_ACCOUNT;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hxsb.dao.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundmenthead_Dao;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord2;
import com.hxsb.service.BUY_ERP_GET_REFUND_ACCOUNT.BUY_ERP_GET_REFUND_ACCOUNT_Service;
  
  
@Service("buy_ERP_GET_REFUND_ACCOUNT_Service")  
public class BUY_ERP_GET_REFUND_ACCOUNT_ServiceImpl implements BUY_ERP_GET_REFUND_ACCOUNT_Service { 
	@Autowired
	private SCM_HX07_Refundmenthead_Dao scm_HX07_Refundmenthead_Dao;

	public List<RefundRecord2> selectData(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<RefundRecord2> refundRecord2List = scm_HX07_Refundmenthead_Dao.selectDataByTime(time);
		return refundRecord2List;
	}

    
  
}  
