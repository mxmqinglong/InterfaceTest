package com.hxsb.service.impl.BUY_ERP_REFUND_CONFIRM;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.hxsb.dao.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundment2_Dao;
import com.hxsb.dao.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundmenthead_Dao;
import com.hxsb.dao.BUY_ERP_REFUND_CONFIRM.SCM_CSS_HttpRepeatSendLog_Dao;
import com.hxsb.dao.BUY_ERP_REFUND_CONFIRM.SCM_CSS_HttpSendLog_Dao;
import com.hxsb.dao.BUY_ERP_USER_SYNC.SCM_HX00_MemberInfoHead_Dao;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundment2;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.SCM_HX07_Refundmenthead;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.SMSTemplate;
import com.hxsb.model.BUY_ERP_REFUND_CONFIRM.SCM_CSS_HttpRepeatSendLog;
import com.hxsb.model.BUY_ERP_REFUND_CONFIRM.SCM_CSS_HttpSendLog;
import com.hxsb.model.BUY_ERP_USER_SYNC.MemberInfo;
import com.hxsb.service.BUY_ERP_REFUND_CONFIRM.BUY_ERP_REFUND_CONFIRM_Service;
import com.hxsb.service.css.Css_Service;
import com.hxsb.util.ConstantProperties;
import com.hxsb.util.EncryptUtils;
import com.hxsb.util.HttpSendUtil1;
import com.hxsb.util.RefParameter;
  
@Service("buy_ERP_REFUND_CONFIRM_Service")  
@Transactional
public class BUY_ERP_REFUND_CONFIRM_ServiceImpl implements BUY_ERP_REFUND_CONFIRM_Service { 
	@Autowired
	private SCM_HX07_Refundmenthead_Dao scm_HX07_Refundmenthead_Dao;
	@Autowired
	private SCM_HX07_Refundment2_Dao scm_HX07_Refundment2_Dao;
	@Autowired
	private SCM_HX00_MemberInfoHead_Dao scm_HX00_MemberInfoHead_Dao;
	@Autowired
	private SCM_CSS_HttpSendLog_Dao scm_CSS_HttpSendLog_Dao;
	@Autowired
	private SCM_CSS_HttpRepeatSendLog_Dao scm_CSS_HttpRepeatSendLog_Dao;
	@Autowired 
	private Css_Service css_Service;


	public void refundConfirm(Map<String, Object> map) {
		Long BillID = Long.valueOf(map.get("erp_refund_record_id").toString());
		Long billDtlID = Long.valueOf(map.get("erp_refund_record_details_id").toString());
	    String no = map.get("erp_refund_record_number").toString();//编号
	    int refundStatus = Integer.valueOf(map.get("refund_status").toString());//退款状态
	    if( null == BillID || BillID <= 0 || "".equals(BillID)){
	        throw new RuntimeException("无效的ERP退款单ID");
	    }
	    String pSerialNum = map.get("payment_serial_number").toString();//付款流水号
	    
	    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(map.get("refund_time").toString());
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 System.out.println(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		SCM_HX07_Refundmenthead returnRefundRecord = scm_HX07_Refundmenthead_Dao.selectByBillId(BillID);
		if(returnRefundRecord != null){
			List<SCM_HX07_Refundment2> details = returnRefundRecord.getDetails();
			if(details != null){
				for(SCM_HX07_Refundment2 detail:details){ 
					if(detail.getBilldtlid().equals(billDtlID)){
						SCM_HX07_Refundment2 scm_HX07_Refundment2 = new SCM_HX07_Refundment2();
						scm_HX07_Refundment2.setBilldtlid(detail.getBilldtlid());
						scm_HX07_Refundment2.setDtlRefundstatus(refundStatus);//退款状态
						
						
						scm_HX07_Refundment2.setDtlRefundtime(date);
						scm_HX07_Refundment2.setDtlRefserialno(map.get("refund_serial_number").toString());
						scm_HX07_Refundment2_Dao.updateBySelective(scm_HX07_Refundment2);
					}
				}
				
				int count = scm_HX07_Refundment2_Dao.selectRefundStatusCountByBillId(BillID);
				if(details.size() == count){	
					SCM_HX07_Refundmenthead scm_HX07_Refundmenthead = new SCM_HX07_Refundmenthead();
					scm_HX07_Refundmenthead.setBillid(returnRefundRecord.getBillid());
					scm_HX07_Refundmenthead.setReceiveacount("57658553");//我司银行账号 待财务提供
					scm_HX07_Refundmenthead.setReceivedate(date);
					scm_HX07_Refundmenthead_Dao.updateBySelective(scm_HX07_Refundmenthead);
					
					
					List<SMSTemplate> smsTemplateList = scm_HX07_Refundmenthead_Dao.selectSMSByBillId(returnRefundRecord.getBillid());
					
					JSONObject returnData = null;
				    List<Object> datas = null;//短信模板中参数集合
				    if(smsTemplateList.size() > 0){
				    	returnData = new JSONObject();
				        datas = new ArrayList<Object>();
				    	for(SMSTemplate smsTemplate:smsTemplateList){
				    		String mobile = smsTemplate.getMobile();
				    		if(null != mobile && mobile.trim().length()>0){
					            //【宏信商城】您的退款申请已完成，款项${amount}金额已支付至您的账户，预计到账时间5个工作日内，请您注意查收，亦可登陆宏信商城{2}。如有疑问，可联系4008218001。   
					            returnData.put("template_id", 259957);//模板ID
					            returnData.put("mobile", mobile);//手机号

					            Double amount = smsTemplate.getAmount();//总金额
					            if(null!=amount && amount.toString().trim().length()>0){
					                datas.add(amount.toString());
					            } else{
					                datas.add(" ");
					            }
					            datas.add("www.hongxinshop.com");
					            returnData.put("datas", datas);//短信中的参数
					            if(null != returnData && returnData.size()>0){
					                //sendData("HX07_Refundment", BillID, returnData);
					            	//检查是否为电商会员
					        	    String mobileStr = returnData.getString("mobile");
					        	    List<MemberInfo> memberInfoList = scm_HX00_MemberInfoHead_Dao.selectByUserMobile(mobileStr);
					        	    if(memberInfoList.size() > 0){
					        	    	sendData("ERP_BUY_SMS_SEND", "HX07_Refundment", returnRefundRecord.getBillid().toString(), returnData.toString(),"ERP_BUY_SMS_SEND",true);
					        	    	//sendData("ERP_BUY_SMS_SEND", billKey, billID.toString(), returnData.toString(),"ERP_BUY_SMS_SEND",true);
					        	    }
					        	    
					            	
					            }
					        }
					    }
				    }
				}
			}
		}
		
	}
    
    
	
	
	/**
	 * 
	 * @param mid 
	 * @param method 调用CSS接口的方法
	 * @param billkey ERP中对应的单据，null表示没有
	 * @param unique ERP-CSS 交互的唯一编码，null表示没有
	 * @param dataJsonStr 发送到报文
	 * @param action 传送失败后，重传执行的代码，Groovy文件名
	 * @param isLog 是否记录日志，true-同一个数据第一次传递；false-定时重传的情况下使用
	 * @return
	 */
	// 发送数据
	public int sendData(String method, String billkey, String unique, 
			String dataJsonStr, String action, boolean isLog) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("account", "HXB2B");
		map.put("version", ConstantProperties.Version);
		map.put("log_open", "1");
		map.put("method", method);
		map.put("unique", unique);
		map.put("data", dataJsonStr);
		map.put("sign", EncryptUtils.signCreater(dataJsonStr));
		// 记录日志
		RefParameter<String> rstMSG = new RefParameter<String>();
		Map info = HttpSendUtil1.sendInfo(ConstantProperties.GATEURL, map, rstMSG);
		int responseCode=0;
		String beginDate="";
		String endDate="";
		Iterator it = info.entrySet().iterator(); 
	    while (it.hasNext()) {  
	    	Map.Entry entry = (Map.Entry) it.next();  
	    	String name = entry.getKey().toString();  
	    	String value = entry.getValue().toString();  
	    	if(name.equals("responseCode")){
	    		responseCode=Integer.parseInt(value);
	    	}else if(name.equals("beginDate")){
	    		beginDate=value;
	    	}else if(name.equals("endDate")){
	    		endDate=value;
	    	}
	    }

		// 记录日志
		if(isLog){
			try {
				// 记录发送日志
				String msg = rstMSG.getValue().substring(0, Math.min(rstMSG.getValue().length(), 7800)); // oralce字段最多4000字符
				//Long billID = css_Service.dbGetNumber("SCM_CSS_HTTPSENDLOG", 1);
				//Long maxId = scm_CSS_HttpSendLog_Dao.selectMaxId();
				SCM_CSS_HttpSendLog scm_CSS_HttpSendLog = new SCM_CSS_HttpSendLog();
				//scm_CSS_HttpSendLog.setId(billID);
				scm_CSS_HttpSendLog.setBillkey(billkey);
				scm_CSS_HttpSendLog.setUnique(unique);
				scm_CSS_HttpSendLog.setMethod(method);
				scm_CSS_HttpSendLog.setDatajsonstr(dataJsonStr);
				scm_CSS_HttpSendLog.setResponsecode(responseCode);
				scm_CSS_HttpSendLog.setMsg(msg);
				scm_CSS_HttpSendLog.setResponsedate(new Timestamp((new java.util.Date()).getTime()));
				scm_CSS_HttpSendLog_Dao.insert(scm_CSS_HttpSendLog);
				// 发送失败，在重发日志中做记录
				if(responseCode != 200){
					//Long maxId1 = scm_CSS_HttpRepeatSendLog_Dao.selectMaxId();
					SCM_CSS_HttpRepeatSendLog scm_CSS_HttpRepeatSendLog = new SCM_CSS_HttpRepeatSendLog();
					//scm_CSS_HttpRepeatSendLog.setId(billID);
					scm_CSS_HttpRepeatSendLog.setBillkey(billkey);
					scm_CSS_HttpRepeatSendLog.setUnique(unique);
					scm_CSS_HttpRepeatSendLog.setMethod(method);
					scm_CSS_HttpRepeatSendLog.setDatajsonstr(dataJsonStr);
					scm_CSS_HttpRepeatSendLog.setResponsecode(responseCode);
					scm_CSS_HttpRepeatSendLog.setMsg(msg);
					scm_CSS_HttpRepeatSendLog.setResponsedate(new Timestamp((new java.util.Date()).getTime()));
					scm_CSS_HttpRepeatSendLog_Dao.insert(scm_CSS_HttpRepeatSendLog);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		return responseCode;
	}
}  
