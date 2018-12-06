package com.hxsb.service.impl.BUY_ERP_GET_REFUND_RECORD;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hxsb.dao.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundmenthead_Dao;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecordDetail;
import com.hxsb.service.BUY_ERP_GET_REFUND_RECORD.BUY_ERP_GET_REFUND_RECORD_Service;
  
  
@Service("buy_ERP_GET_REFUND_RECORD_Service")  
public class BUY_ERP_GET_REFUND_RECORD_ServiceImpl implements BUY_ERP_GET_REFUND_RECORD_Service { 
	@Autowired
	private SCM_HX07_Refundmenthead_Dao scm_HX07_Refundmenthead_Dao;

	public List<RefundRecord> selectData(String erp_order_ids) {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray Jarray = parser.parse(erp_order_ids).getAsJsonArray();
		ArrayList<String> erp_order_idList = new ArrayList<String>();
		for(JsonElement obj : Jarray ){
			String cse = gson.fromJson( obj , String.class);
			erp_order_idList.add(cse);  
		}
		
		List<RefundRecord> refundRecordList = scm_HX07_Refundmenthead_Dao.selectData(erp_order_idList);
		
		for(RefundRecord refundRecord:refundRecordList){
			BigDecimal amount = BigDecimal.ZERO;
			List<RefundRecordDetail> details = refundRecord.getDetails();
			if(details != null){
				for(RefundRecordDetail detail:details){
					amount = amount.add(detail.getAmount());
				}
			}
			refundRecord.setAmount(amount);
		}
		
		return refundRecordList;
	}
}  
