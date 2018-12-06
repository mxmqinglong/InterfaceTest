package com.hxsb.service.impl.BUY_ERP_ORDER_CREATE;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hxsb.dao.BUY_ERP_ORDER_CREATE.CP_HX00_BizUnit_Dao;
import com.hxsb.dao.BUY_ERP_ORDER_CREATE.CP_HX00_Shop_Dao;
import com.hxsb.dao.BUY_ERP_ORDER_CREATE.GP_Operator_Dao;
import com.hxsb.dao.BUY_ERP_ORDER_CREATE.SCM_HX50_IntentionList2_Dao;
import com.hxsb.dao.BUY_ERP_ORDER_CREATE.SCM_HX50_IntentionList3_Dao;
import com.hxsb.dao.BUY_ERP_ORDER_CREATE.SCM_HX50_IntentionListHead_Dao;
import com.hxsb.dao.BUY_ERP_ORDER_CREATE.SCM_S00_NOTICE_Dao;
import com.hxsb.dao.BUY_ERP_PRODUCT_VERIFY.CP_HX01_EquModel_Dao;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.BUY_ERP_ORDER_CREATE_Request;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.CP_HX00_Shop;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.Coupon;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.GP_Operator;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.IntentionTemporary;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.Product;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.SCM_HX50_IntentionList2;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.SCM_HX50_IntentionList3;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.SCM_HX50_IntentionListHead;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.SCM_S00_NOTICE;
import com.hxsb.service.BUY_ERP_ORDER_CREATE.BUY_ERP_ORDER_CREATE_Service;
import com.hxsb.service.css.Css_Service;
import com.hxsb.util.DateHelper;
  
  
@Service("buy_ERP_ORDER_CREATE_Service")  
@Transactional
public class BUY_ERP_ORDER_CREATE_ServiceImpl implements BUY_ERP_ORDER_CREATE_Service { 
	@Autowired
	private SCM_HX50_IntentionListHead_Dao scm_HX50_IntentionListHead_Dao;
	@Autowired
	private SCM_HX50_IntentionList2_Dao scm_HX50_IntentionList2_Dao;
	@Autowired
	private SCM_HX50_IntentionList3_Dao scm_HX50_IntentionList3_Dao;
	@Autowired
	private SCM_S00_NOTICE_Dao scm_S00_NOTICE_Dao;
	@Autowired
	private CP_HX00_BizUnit_Dao cp_HX00_BizUnit_Dao;
	@Autowired
	private CP_HX00_Shop_Dao cp_HX00_Shop_Dao;
	@Autowired
	private GP_Operator_Dao gp_Operator_Dao;
	@Autowired
	private CP_HX01_EquModel_Dao cp_HX01_EquModel_Dao;
	@Autowired 
	private Css_Service css_Service;

	public void insertOrUpateIntentionList(String data) {
		JsonObject obj = new JsonParser().parse(data).getAsJsonObject();
		BUY_ERP_ORDER_CREATE_Request bean = new Gson().fromJson(obj,BUY_ERP_ORDER_CREATE_Request.class);
		String buy_intention_receipts_number = bean.getBuy_intention_receipts_number();
		String erp_bu_number = bean.getErp_bu_number();
		
		List<SCM_HX50_IntentionListHead> SCM_HX50_IntentionListHeads = scm_HX50_IntentionListHead_Dao.selectDataByReceiptsNumber(buy_intention_receipts_number);
		if(SCM_HX50_IntentionListHeads.size() > 0){	
			throw new RuntimeException("意向单号重复");
		}else{
			SCM_HX50_IntentionListHead new_scm_HX50_IntentionListHead = new SCM_HX50_IntentionListHead();
			//Long BillID = css_Service.dbGetNumber("BILL", 1);
			String BillNo = css_Service.getNO("HX50_IntentionList");
			//System.out.println(BillID+"<<<<<"+BillNo);
			
			//new_scm_HX50_IntentionListHead.setBillid(BillID);
			new_scm_HX50_IntentionListHead.setNo(BillNo);
			/*单据日期*/
			//Date ts = new java.sql.Date((new java.util.Date()).getTime());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			  String sDate = simpleDateFormat.format(new Date());  
			  Date date = null;  
			  try {  
			   date = simpleDateFormat.parse(sDate);  
			  } catch (Exception e) {  
				  e.printStackTrace();
			  } 
			new_scm_HX50_IntentionListHead.setBilldate(date);
			Timestamp time=new Timestamp(System.currentTimeMillis());
			new_scm_HX50_IntentionListHead.setMakedate(time);
			new_scm_HX50_IntentionListHead.setBilltype(1873);
			new_scm_HX50_IntentionListHead.setCorpid(999);
			new_scm_HX50_IntentionListHead.setMaker(1L);
			/*意向单号*/
		    if (null!=buy_intention_receipts_number && buy_intention_receipts_number.trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setReceiptsnumber(buy_intention_receipts_number);
		    }
		    /*事业部*/
		    if(null != erp_bu_number && erp_bu_number.trim().length()>0){
		    	Long bizUnitId = cp_HX00_BizUnit_Dao.selectByCode(erp_bu_number);
		    	new_scm_HX50_IntentionListHead.setBizUnit(bizUnitId);
		    }
		    /*营业店*/
		    if (null!=bean.getErp_shop_number() && bean.getErp_shop_number().trim().length()>0) {
		    	CP_HX00_Shop cp_HX00_Shop = cp_HX00_Shop_Dao.selectByCode(bean.getErp_shop_number());
		    	new_scm_HX50_IntentionListHead.setBizShop(cp_HX00_Shop.getId());
		    	new_scm_HX50_IntentionListHead.setBizArea(cp_HX00_Shop.getBizareaid());
		    }
		    
		    /*AD账号*/
		    if (null!=bean.getErp_salesman_number() && bean.getErp_salesman_number().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setSalesmannumber(bean.getErp_salesman_number());
		    	GP_Operator gp_Operator = gp_Operator_Dao.selectByADAccount(bean.getErp_salesman_number());
		    	new_scm_HX50_IntentionListHead.setMaker(gp_Operator.getOperatorId());
		    	new_scm_HX50_IntentionListHead.setStaffid(gp_Operator.getId());
		    }
		    
		    /*采购人姓名*/
		    if (null!=bean.getPurchasing_agent_name() && bean.getPurchasing_agent_name().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setAgentname(bean.getPurchasing_agent_name());
		    }
		    
		    /*采购人手机号*/
		    if (null!=bean.getPurchasing_agent_mobile() && bean.getPurchasing_agent_mobile().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setAgentmobile(bean.getPurchasing_agent_mobile());
		    }
		    /*配送方式*/
		    if(null != bean.getDelivery_way() && bean.getDelivery_way().trim().length()>0){
		        if("送货上门".equals(bean.getDelivery_way())){
		        	new_scm_HX50_IntentionListHead.setDeliveryWay(10);
		        }else if("自提".equals(bean.getDelivery_way())){
		        	new_scm_HX50_IntentionListHead.setDeliveryWay(20);
		        }
		    }
		    
		    /*意向单总金额*/
		    if (null!=bean.getIntention_receipts_total_amount() && bean.getIntention_receipts_total_amount()>0) {
		    	new_scm_HX50_IntentionListHead.setTotalamount((double)bean.getIntention_receipts_total_amount());
		    }
		    /*确认时间*/
		    if (null!=bean.getAffirm_time() && bean.getAffirm_time().trim().length()>0) {
		        String affirm_time = bean.getAffirm_time().replace("T", " ");
		        // ios时间戳带有毫秒数，需要去掉
		        int dot = affirm_time.indexOf(".") == -1 ? affirm_time.length() : affirm_time.indexOf(".");
		        affirm_time = affirm_time.substring(0, dot);
		        Timestamp affirmTime =null;
		        affirmTime = DateHelper.hxbizString2Time(affirm_time);
		        new_scm_HX50_IntentionListHead.setAffirmtime(affirmTime);
		    }
		    /*收货地省份*/
		    if (null!=bean.getDelivery_province() && bean.getDelivery_province().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setDeliveryprovince(bean.getDelivery_province());
		    }
		    /*收货地城市*/
		    if (null!=bean.getDelivery_city() && bean.getDelivery_city().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setDeliverycity(bean.getDelivery_city());
		    }
		    /*收货地区县*/
		    if (null!=bean.getDelivery_county() && bean.getDelivery_county().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setDeliverycounty(bean.getDelivery_county());
		    }
		    /*收货地详细地址*/
		    if (null!=bean.getDelivery_address() && bean.getDelivery_address().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setDeliveryaddress(bean.getDelivery_address());
		    }
		    /*收货人*/
		    if (null!=bean.getDelivery_name() && bean.getDelivery_name().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setDeliveryname(bean.getDelivery_name());
		    }
		    /*收货人电话*/
		    if (null!=bean.getDelivery_mobile() && bean.getDelivery_mobile().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setDeliverymobile(bean.getDelivery_mobile());
		    }
		    /*发票类型*/
		    if (null!=bean.getInvoice_type()) {
		    	new_scm_HX50_IntentionListHead.setInvoicetype(bean.getInvoice_type());
		    }
		    /*发票抬头*/
		    if (null!=bean.getInvoice_title() ) {
		    	new_scm_HX50_IntentionListHead.setInvoicetitle(bean.getInvoice_title());
		    }
		    
		    
		    /*发票单位名称*/
		    if (null!=bean.getInvoice_company_name()&& bean.getInvoice_company_name().trim().length()>0) {	//???
		    	new_scm_HX50_IntentionListHead.setInvoicecompanyname(bean.getInvoice_company_name());
		    }
		    /*纳税人识别号*/
		    if (null!=bean.getInvoice_taxpayer_heading_code() && bean.getInvoice_taxpayer_heading_code().trim().length()>0) {//???
		    	new_scm_HX50_IntentionListHead.setInvoicetaxpayercode(bean.getInvoice_taxpayer_heading_code());
		    }
		    /*收货人电话*/
		    if (null!=bean.getDelivery_mobile() && bean.getDelivery_mobile().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setDeliverymobile(bean.getDelivery_mobile());
		    }
		    
		    
		    /*开户行*/
		    if (null!=bean.getInvoice_opening_bank() && bean.getInvoice_opening_bank().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setInvoiceopeningbank(bean.getInvoice_opening_bank());
		    }
		    /*地址及电话*/
		    if (null!=bean.getInvoice_addr_phoneno() && bean.getInvoice_addr_phoneno().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setInvoiceaddrphoneno(bean.getInvoice_addr_phoneno());
		    }
		    /*银行账号*/
		    if (null!=bean.getInvoice_bank_account() && bean.getInvoice_bank_account().trim().length()>0) {
		    	new_scm_HX50_IntentionListHead.setInvoicebankaccount(bean.getInvoice_bank_account());
		    }
		    /*备注*/
		    if (null!=bean.getNote() && bean.getNote().trim().length()>0 ) {
		    	new_scm_HX50_IntentionListHead.setNote(bean.getNote());
		    }
		    
		    new_scm_HX50_IntentionListHead.setCreateTime(new Timestamp((new java.util.Date()).getTime()));	
		    new_scm_HX50_IntentionListHead.setBilldescr("意向单");
		    new_scm_HX50_IntentionListHead.setStatus(30);
			
		    scm_HX50_IntentionListHead_Dao.insert(new_scm_HX50_IntentionListHead);
		    Long BillID = new_scm_HX50_IntentionListHead.getBillid();
		    
		    
		    ArrayList<SCM_HX50_IntentionList2> scm_HX50_IntentionList2s = new ArrayList<SCM_HX50_IntentionList2>();
		    List<Product> product_details = bean.getProduct_details();
		    if(null != product_details && product_details.size()>0){
		        //明细保存
	            /*if(lineRs.bkGetInt("BillDtlID")>0){
	             //修改
	            }else{//新增
	                lineRs.bkUpdateInt("BillDtlID", HXCSS__hx50_commonDemo.getNewBillID(yigoCtx));
	            }*/
		    	
	          
		    	
		    	
		    	SCM_HX50_IntentionList2 scm_HX50_IntentionList2 = null;
		    	/*Long startBillID = null;
		    	if(product_details != null && product_details.size()>0){
		    		startBillID = css_Service.dbGetNumber("BILL", product_details.size());
		    	}*/
		    	for(int i=0;i<product_details.size();i++){
		    		scm_HX50_IntentionList2 = new SCM_HX50_IntentionList2();
		    		scm_HX50_IntentionList2.setBillid(BillID);	
		    		
		    		//scm_HX50_IntentionList2.setBilldtlid(startBillID +i);
		    		
		    		if(null != product_details.get(i).getProduct_erp_number()) {
		    			//Long dtlProductnumber = cp_HX01_EquModel_Dao.selectIdByCode(product_details.get(i).getProduct_erp_number());
		    			scm_HX50_IntentionList2.setDtlProductnumber(cp_HX01_EquModel_Dao.selectIdByCode(product_details.get(i).getProduct_erp_number()));
		            }
		    		
		    		if(null != product_details.get(i).getPredict_enter_arena_time() && product_details.get(i).getPredict_enter_arena_time().trim().length()>0) {
		                String enterDate = product_details.get(i).getPredict_enter_arena_time().replace("T", " ");
		                // ios时间戳带有毫秒数，需要去掉
		                int dot = enterDate.indexOf(".") == -1 ? enterDate.length() : enterDate.indexOf(".");
		                enterDate = enterDate.substring(0, dot);
		                Timestamp enterTime =null;
		                enterTime = DateHelper.hxbizString2Time(enterDate);
		                scm_HX50_IntentionList2.setDtlEntertime(enterTime);
		            }
		            if(null != product_details.get(i).getTenancy() ) {
		            	scm_HX50_IntentionList2.setDtlTenancy(product_details.get(i).getTenancy());
		            }
		            if (null != product_details.get(i).getTenancy_unit() && product_details.get(i).getTenancy_unit().trim().length()>0) {
		            	scm_HX50_IntentionList2.setDtlTenancyunit(product_details.get(i).getTenancy_unit());
		            }
		            if(null != product_details.get(i).getLease_price() ) {
		            	scm_HX50_IntentionList2.setDtlLeaseprice(product_details.get(i).getLease_price());
		            }
		            if(null != product_details.get(i).getQuantity() ) {
		            	scm_HX50_IntentionList2.setDtlQuantity(product_details.get(i).getQuantity());
		            }
		            
		            scm_HX50_IntentionList2s.add(scm_HX50_IntentionList2);
		            System.out.println(scm_HX50_IntentionList2);
		            scm_HX50_IntentionList2_Dao.insert(scm_HX50_IntentionList2);
		    	}
		    	
		    	//scm_HX50_IntentionList2_Dao.batchAdd(scm_HX50_IntentionList2s);
	            
	            
		            
		    }
		    
		    
		    
		    ArrayList<SCM_HX50_IntentionList3> scm_HX50_IntentionList3s = new ArrayList<SCM_HX50_IntentionList3>();
		    List<Coupon> coupons = bean.getCoupons();
		    if(null != coupons && coupons.size()>0){
		    	/*Long startBillID1 = null;
		    	if(product_details != null && product_details.size()>0){
		    		startBillID1 = css_Service.dbGetNumber("BILL", product_details.size());
		    	}*/
		    	
		        //明细保存
	            /*if(lineRs.bkGetInt("BillDtlID")>0){
	             //修改        
	            }else{//新增
	                lineRs.bkUpdateInt("BillDtlID", HXCSS__hx50_commonDemo.getNewBillID(yigoCtx));
	            }*/
	            //lineRs.bkUpdateInt("BillID", BillID);
		    	SCM_HX50_IntentionList3 scm_HX50_IntentionList3 = null;
		    	for(int i=0;i< coupons.size();i++){
		    		scm_HX50_IntentionList3 = new SCM_HX50_IntentionList3();
		    		
		    		scm_HX50_IntentionList3.setBillid(BillID);//????
		    		
		    		//Long maxBilldtlid = scm_HX50_IntentionList3_Dao.selectMaxBilldtlid();
		    		//scm_HX50_IntentionList3.setBilldtlid(startBillID1+i);//????
		    		
		    		if(null != coupons.get(i).getCoupon_number()) {
		    			scm_HX50_IntentionList3.setDcCouponnumber(coupons.get(i).getCoupon_number());
		            }
		            if(null != coupons.get(i).getCoupon_name() && coupons.get(i).getCoupon_name().trim().length()>0 ) {
		            	scm_HX50_IntentionList3.setDcCouponname(coupons.get(i).getCoupon_name());
		            }
		            if(null != coupons.get(i).getCoupon_amount() ) {
		            	scm_HX50_IntentionList3.setDcCouponamount(coupons.get(i).getCoupon_amount());
		            }
		            
		            scm_HX50_IntentionList3s.add(scm_HX50_IntentionList3);
		            System.out.println(scm_HX50_IntentionList3);
		            scm_HX50_IntentionList3_Dao.insert(scm_HX50_IntentionList3);
		    	}
		    	
		    	//scm_HX50_IntentionList3_Dao.batchAdd(scm_HX50_IntentionList3s);
		    }
		    
		    
		    
		    List<IntentionTemporary> intentionTemporaryList = scm_HX50_IntentionListHead_Dao.selectDataByBillId(BillID);
		    if(intentionTemporaryList != null){
		    	ArrayList<SCM_S00_NOTICE> scm_S00_NOTICEList = new ArrayList<SCM_S00_NOTICE>();
		    	SCM_S00_NOTICE scm_S00_NOTICE = null;
		    	for(IntentionTemporary intentionTemporary:intentionTemporaryList){
		    		scm_S00_NOTICE = new SCM_S00_NOTICE();
		    		
		    		scm_S00_NOTICE.setReckey(BillID);	//???
		    		
		    		scm_S00_NOTICE.setTaskname("订单生成提醒");
		    		scm_S00_NOTICE.setDataname("意向单");
		    		scm_S00_NOTICE.setDatacode(buy_intention_receipts_number);//???
		    		
		    		scm_S00_NOTICE.setBizunitid(intentionTemporary.getBiz_Unit());
		    		scm_S00_NOTICE.setBizareaid(intentionTemporary.getBiz_Area());
		    		scm_S00_NOTICE.setBizshopid(intentionTemporary.getBiz_Shop());
		    		scm_S00_NOTICE.setDeptid(-1);
		    		
		    		scm_S00_NOTICE.setTitle(intentionTemporary.getTitle());
		    		scm_S00_NOTICE.setOperator(intentionTemporary.getOperatorID());
		    		scm_S00_NOTICE.setOptexp("HX_Notice_OpenBillInPage(HX50_IntentionList, "+BillID+")");//???
		    		scm_S00_NOTICE.setOptdata(-1);
		    		scm_S00_NOTICE.setNoticename("HX50-01");
		    		
		    		scm_S00_NOTICE.setCreatetime(new Timestamp((new java.util.Date()).getTime()));
		    		
		    		scm_S00_NOTICE.setCreator(intentionTemporary.getCreator());
		    		scm_S00_NOTICE.setBillid(BillID);//???
		    		scm_S00_NOTICE.setBillkey("HX50_IntentionList");
		    		
		    		
		    		scm_S00_NOTICEList.add(scm_S00_NOTICE);
		    		scm_S00_NOTICE_Dao.insert(scm_S00_NOTICE);
			    }
		    	
		    	//scm_S00_NOTICE_Dao.batchAdd(scm_S00_NOTICEList);
		    	
		    	//批量插入有问题
		    	/*ArrayList<SCM_S00_NOTICE> scm_S00_NOTICEList1 = new ArrayList<SCM_S00_NOTICE>();
		    	scm_S00_NOTICEList1.add(scm_S00_NOTICEList.get(0));
		    	scm_S00_NOTICE_Dao.insert(scm_S00_NOTICEList.get(1));*/
		    	//scm_S00_NOTICE_Dao.batchAdd(scm_S00_NOTICEList1);
		    	//scm_S00_NOTICE_Dao.batchAdd(scm_S00_NOTICEList);
		    }
		    
		    
		    
		}
	}
    
    
	private String format(String maxNo) {
		int noNum = Integer.parseInt(maxNo.substring(maxNo.length()-4, maxNo.length())) +1;
		String str = noNum+"";
		int strLen = str.length();
		if (strLen < 4) {
			while (strLen < 4) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);// 左补0
				str = sb.toString();
				strLen = str.length();
			}
		}
		DateFormat dFormat = new SimpleDateFormat("yyyyMM");
		String format = dFormat.format(new Date());
		String no = "YXD"+format+str;
		return no;
	}
}  
