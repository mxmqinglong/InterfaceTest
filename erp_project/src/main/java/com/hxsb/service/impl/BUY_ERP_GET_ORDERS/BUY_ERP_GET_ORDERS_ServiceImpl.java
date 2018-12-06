package com.hxsb.service.impl.BUY_ERP_GET_ORDERS;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxsb.dao.BUY_ERP_GET_ORDERS.SCM_CSS_HttpSendOrderLog_Dao;
import com.hxsb.dao.BUY_ERP_GET_ORDERS.SCM_HX03_ROHead_Dao;
import com.hxsb.dao.BUY_ERP_USER_SYNC.SCM_HX00_MemberInfoHead_Dao;
import com.hxsb.model.BUY_ERP_GET_ORDERS.OrderRecord;
import com.hxsb.model.BUY_ERP_GET_ORDERS.SCM_CSS_HttpSendOrderLog;
import com.hxsb.service.BUY_ERP_GET_ORDERS.BUY_ERP_GET_ORDERS_Service;
  
  
@Service("buy_ERP_GET_ORDERS_Service") 
@Transactional
public class BUY_ERP_GET_ORDERS_ServiceImpl implements BUY_ERP_GET_ORDERS_Service { 
	
	
	@Autowired
	private SCM_HX03_ROHead_Dao scm_HX03_ROHead_Dao;
	@Autowired
	private SCM_CSS_HttpSendOrderLog_Dao scm_CSS_HttpSendOrderLog_Dao;
	@Autowired
	private SCM_HX00_MemberInfoHead_Dao scm_HX00_MemberInfoHead_Dao;

	public Map<String, Object> selectByNameAndMobile(Map<String, Object> map) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int  recordcount= scm_HX03_ROHead_Dao.selectTotalAmout(map);
		int pagesize = Integer.parseInt(map.get("pagesize").toString());
		int currentpage = Integer.parseInt(map.get("pageindex").toString());
		int pagecount = 0;
		if (recordcount > 0) {
			if ((recordcount % pagesize) == 0) {
				pagecount = recordcount / pagesize;
			} else {
				pagecount = recordcount / pagesize + 1;
			}

			if (currentpage > pagecount) {
				currentpage = pagecount + 1;
			}

		} else {
			pagecount = 0;
		}
		List<OrderRecord> orderRecordList = scm_HX03_ROHead_Dao.selectData(map);
		ArrayList<SCM_CSS_HttpSendOrderLog> list = new ArrayList<SCM_CSS_HttpSendOrderLog>();
		SCM_CSS_HttpSendOrderLog bean = null;
		if(orderRecordList != null){
			for(int i=0;i<orderRecordList.size();i++){
			//for(OrderRecord orderRecord:orderRecordList){
				bean = new SCM_CSS_HttpSendOrderLog();
				bean.setBillid(orderRecordList.get(i).getErp_order_id());
				bean.setMethods("BUY_ERP_GET_ORDERS");
				bean.setIspushenterexit(0L);
				bean.setLogdate(new Timestamp((new java.util.Date()).getTime()));
				list.add(bean);
				scm_CSS_HttpSendOrderLog_Dao.insert(bean);
			}
			//scm_CSS_HttpSendOrderLog_Dao.batchAdd(list);
			
		}
		
		
		//查询订单条数大于0则默认绑定成功,更新会员的绑定状态
		if(recordcount > 0){
			scm_HX00_MemberInfoHead_Dao.updateByMobile(map.get("mobile").toString());
		}
		
		returnMap.put("orders", orderRecordList);
		returnMap.put("pagesize", pagesize);
		returnMap.put("pagecount", pagecount);
		returnMap.put("recordcount", recordcount);
		returnMap.put("currentpage", currentpage);
		return returnMap;
	}
    
    
  
}  
