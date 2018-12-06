package com.hxsb.service.impl.css;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxsb.dao.css.CP_S00_BillNoRule_Dao;
import com.hxsb.dao.css.GP_BILL_NO_RUNNING_Dao;
import com.hxsb.dao.css.SCM_CSS_HTTPRECEIVELOG_Dao;
import com.hxsb.dao.css.S_AutoNumber_Dao;
import com.hxsb.model.css.CP_S00_BillNoRule;
import com.hxsb.model.css.GP_BILL_NO_RUNNING;
import com.hxsb.model.css.SCM_CSS_HTTPRECEIVELOG;
import com.hxsb.service.css.Css_Service;
import com.hxsb.util.DateUtil;
import com.hxsb.util.StringUtil;
import com.hxsb.util.VariantConvertor;
  
  
@Service("css_Service")  
public class Css_ServiceImpl implements Css_Service { 
	@Autowired
	private SCM_CSS_HTTPRECEIVELOG_Dao scm_CSS_HTTPRECEIVELOG_Dao;
	@Autowired
	private S_AutoNumber_Dao s_AutoNumber_Dao;
	@Autowired
	private CP_S00_BillNoRule_Dao cp_S00_BillNoRule_Dao;
	@Autowired
	private GP_BILL_NO_RUNNING_Dao gp_BILL_NO_RUNNING_Dao;

	public void insertHttpReceiveLog(SCM_CSS_HTTPRECEIVELOG bean) {
		scm_CSS_HTTPRECEIVELOG_Dao.insert(bean);
	}

	

	public synchronized String getNO(String strObjName) {
		String sBillNo = null;
		List<CP_S00_BillNoRule> cp_S00_BillNoRuleList = cp_S00_BillNoRule_Dao.selectRules(strObjName);
		
		
		String sResetPattern = "";
		String sPreNo = "";
		String sNumber = "";
		String sSuNo = "";
		String dateStr = "";
		
		for(CP_S00_BillNoRule cp_S00_BillNoRule:cp_S00_BillNoRuleList){
			String sPatternType = cp_S00_BillNoRule.getDt_PatternType();
			String dt_ResetNumber = cp_S00_BillNoRule.getDt_ResetNumber();
			Boolean bRESET = true;
			String sPattern = cp_S00_BillNoRule.getDt_Pattern();
			String judgeCond = cp_S00_BillNoRule.getJudgeCond();
			if (sPattern.length() > 0) {
				if (sPatternType.equalsIgnoreCase("string")) {
					if (bRESET) {
						sResetPattern = sResetPattern + sPattern;
					}
					if (sNumber.length() <= 0) {
						sPreNo = sPreNo + sPattern;
					} else {
						sSuNo = sSuNo + sPattern;
					}
	
				} else if (sPatternType.equalsIgnoreCase("date")) {
					String sDate = DateUtil.format(DateUtil.getCurrTime(),
							sPattern);
					dateStr = sDate;
					if (bRESET) {
						sResetPattern = sResetPattern + sDate;
					}
					if (sNumber.length() <= 0) {
						sPreNo = sPreNo + sDate;
					} else {
						sSuNo = sSuNo + sDate;
					}
				} else if (sPatternType.equalsIgnoreCase("number")) {
					if (sNumber.length() <= 0) {
						sNumber = sPattern;
					} else {
						/*throw new BKError(oTable.Caption
								+ "对应的单据编号规则，其中有多个流水号，不能生成自动编号。");*/
					}
				} else {
					/*String sValue = VariantConvertor.toString(oExp.evaluate(
							sPattern, "计算" + oTable.Caption + "对应的单据编号规则中的公式"
									+ sPattern + "错误"));
					if (bRESET) {
						sResetPattern = sResetPattern + sValue;
					}
					if (sNumber.length() <= 0) {
						sPreNo = sPreNo + sValue;
					} else {
						sSuNo = sSuNo + sValue;
					}*/
				}
			}
	
		
		}
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		/*if("HX00_MemberInfo".equals(strObjName)){
			hashMap.put("sResetPattern", sResetPattern);
		}else{
			hashMap.put("sResetPattern", dateStr);
		}*/
		hashMap.put("sResetPattern", dateStr);
		hashMap.put("sBillKey", strObjName);
		List<GP_BILL_NO_RUNNING> resdata = null;
		resdata = gp_BILL_NO_RUNNING_Dao.selectData(hashMap);
		
		if (resdata.size() == 0) {
			//Long billid = dbGetNumber("BILL", 1);
			GP_BILL_NO_RUNNING gp_BILL_NO_RUNNING = new GP_BILL_NO_RUNNING();
			//gp_BILL_NO_RUNNING.setId(billid);
			gp_BILL_NO_RUNNING.setBnrBillTypeCode(strObjName);
			gp_BILL_NO_RUNNING.setBnrResetPattern(dateStr);
			int iNumber = 1;
			gp_BILL_NO_RUNNING.setBnrMaxRunningNumber(iNumber);
			gp_BILL_NO_RUNNING_Dao.insert(gp_BILL_NO_RUNNING);
			sNumber = StringUtil.formatNum(iNumber, sNumber);
		} else {
			int BNR_MAX_RUNNING_NUMBER = 0;
			gp_BILL_NO_RUNNING_Dao.updateBySelective(hashMap);
			BNR_MAX_RUNNING_NUMBER = gp_BILL_NO_RUNNING_Dao.selectMaxNumber(hashMap);
			
			
			int iNumber = BNR_MAX_RUNNING_NUMBER;
			String sRunningNumber = VariantConvertor.toString(iNumber);
			if (sRunningNumber.length() > sNumber.length()) {
				/*throw new BKError(oTable.Caption + "编号最大流水号为：" + iNumber
						+ "位数长度：" + sRunningNumber.length() + "，超过编号规则中流水号模板："
						+ sNumber + "位数长度：" + sNumber.length() + "，不能生成自动编号。");*/
			}
			sNumber = StringUtil.formatNum(iNumber, sNumber);
			
		}
		sBillNo = sPreNo + sNumber + sSuNo;
		return sBillNo;
	}
}  
