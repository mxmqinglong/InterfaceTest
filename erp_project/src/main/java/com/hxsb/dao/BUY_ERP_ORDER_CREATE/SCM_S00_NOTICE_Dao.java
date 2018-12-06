package com.hxsb.dao.BUY_ERP_ORDER_CREATE;

import java.util.ArrayList;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.SCM_S00_NOTICE;

public interface SCM_S00_NOTICE_Dao {
	/**
	 * 批量新增
	 * @param bean
	 */
	public void batchAdd(ArrayList<SCM_S00_NOTICE> bean);
	void insert(SCM_S00_NOTICE bean);
}