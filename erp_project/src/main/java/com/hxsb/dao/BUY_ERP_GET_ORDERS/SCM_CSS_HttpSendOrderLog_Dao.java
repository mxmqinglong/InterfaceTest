package com.hxsb.dao.BUY_ERP_GET_ORDERS;

import java.util.ArrayList;
import com.hxsb.model.BUY_ERP_GET_ORDERS.SCM_CSS_HttpSendOrderLog;

public interface SCM_CSS_HttpSendOrderLog_Dao {
    void insert(SCM_CSS_HttpSendOrderLog bean);
    /**
	 * 批量新增log
	 * @param bean
	 */
	public void batchAdd(ArrayList<SCM_CSS_HttpSendOrderLog> list);
	
	
}