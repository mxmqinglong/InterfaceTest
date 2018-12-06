package com.hxsb.controller.css;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hxsb.model.BUY_ERP_GET_DELIVERY_CREATE.ReceiptRecord;
import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.PaymentRecord;
import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.PaymentRecord2;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord;
import com.hxsb.model.BUY_ERP_GET_REFUND_RECORD.RefundRecord2;
import com.hxsb.model.BUY_ERP_PRODUCT_VERIFY.CP_HX01_EquModel;
import com.hxsb.model.css.SCM_CSS_HTTPRECEIVELOG;
import com.hxsb.service.BUY_ERP_GET_DELIVERY_CREATE.BUY_ERP_GET_DELIVERY_CREATE_Service;
import com.hxsb.service.BUY_ERP_GET_ORDERS.BUY_ERP_GET_ORDERS_Service;
import com.hxsb.service.BUY_ERP_GET_PAYMENT_ACCOUNT.BUY_ERP_GET_PAYMENT_ACCOUNT_Service;
import com.hxsb.service.BUY_ERP_GET_PAYMENT_RECORD.BUY_ERP_GET_PAYMENT_RECORD_Service;
import com.hxsb.service.BUY_ERP_GET_REFUND_ACCOUNT.BUY_ERP_GET_REFUND_ACCOUNT_Service;
import com.hxsb.service.BUY_ERP_GET_REFUND_RECORD.BUY_ERP_GET_REFUND_RECORD_Service;
import com.hxsb.service.BUY_ERP_ORDER_CREATE.BUY_ERP_ORDER_CREATE_Service;
import com.hxsb.service.BUY_ERP_PRODUCT_VERIFY.BUY_ERP_PRODUCT_VERIFY_Service;
import com.hxsb.service.BUY_ERP_REFUND_CONFIRM.BUY_ERP_REFUND_CONFIRM_Service;
import com.hxsb.service.BUY_ERP_TOPUP_PAY.BUY_ERP_TOPUP_PAY_Service;
import com.hxsb.service.BUY_ERP_USER_SYNC.BUY_ERP_USER_SYNC_Service;
import com.hxsb.service.css.Css_Service;
import com.hxsb.util.HttpSendUtils;


@Controller  
@RequestMapping("/a/")  
public class CSS_Controller {  
	private static Logger log=LoggerFactory.getLogger(CSS_Controller.class);
	 @Autowired 
	 private BUY_ERP_GET_ORDERS_Service buy_ERP_GET_ORDERS_Service; 
	 @Autowired 
	 private BUY_ERP_GET_REFUND_RECORD_Service buy_ERP_GET_REFUND_RECORD_Service;
	 @Autowired 
	 private BUY_ERP_GET_PAYMENT_RECORD_Service buy_ERP_GET_PAYMENT_RECORD_Service;
	 @Autowired 
	 private BUY_ERP_PRODUCT_VERIFY_Service buy_ERP_PRODUCT_VERIFY_Service;
	 @Autowired 
	 private BUY_ERP_USER_SYNC_Service buy_ERP_USER_SYNC_Service;
	 @Autowired 
	 private BUY_ERP_REFUND_CONFIRM_Service buy_ERP_REFUND_CONFIRM_Service;
	 @Autowired 
	 private BUY_ERP_ORDER_CREATE_Service buy_ERP_ORDER_CREATE_Service;
	 @Autowired 
	 private BUY_ERP_TOPUP_PAY_Service buy_ERP_TOPUP_PAY_Service;
	 @Autowired 
	 private BUY_ERP_GET_PAYMENT_ACCOUNT_Service buy_ERP_GET_PAYMENT_ACCOUNT_Service;
	 @Autowired 
	 private BUY_ERP_GET_REFUND_ACCOUNT_Service buy_ERP_GET_REFUND_ACCOUNT_Service;
	 @Autowired 
	 private BUY_ERP_GET_DELIVERY_CREATE_Service buy_ERP_GET_DELIVERY_CREATE_Service;
	 @Autowired 
	 private Css_Service css_Service;
	 
    
    @RequestMapping(value="/erpcss",method=RequestMethod.POST) 
    public String erpcss(HttpServletRequest request,Model model,HttpServletResponse response){  
    	String account = request.getParameter("account");
    	String version = request.getParameter("version");
    	String data = request.getParameter("data");
    	String sign = request.getParameter("sign");
		// 检查有效性
    	String checkResult = HttpSendUtils.checkFormat(request, null, data);
    	if (null != checkResult){
    		model.addAttribute("status", 1);
        	model.addAttribute("error_code", 1005);
        	model.addAttribute("error_msg", checkResult);
        	model.addAttribute("data", "");
        	return "";
    	}
    	//log request, 用于问题跟踪
    	String rAddr = request.getRemoteAddr();
    	String reqMethod = request.getParameter("method");
    	if(reqMethod == null){
    	    throw new RuntimeException("请求地址 '${url}' 缺少参数 method");
    	}
    	int dotIdx = reqMethod.indexOf(".");
    	if(dotIdx == -1){
    	    throw new RuntimeException("请求地址 '${url}' 不符合 '/a/erpcss/<模块>.<功能>' 格式");
    	}
    	
    	
    	Map<String, Object> map = (Map)JSON.parse(data);
    	try {
			if("hx50_order.BUY_ERP_GET_ORDERS".equals(reqMethod)){
				//3.1. 电商获取ERP订单列表接口 BUY_ERP_GET_ORDERS
				//http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_order.BUY_ERP_GET_ORDERS&data={"name":"梅好","mobile":"15921477532","pagesize":"3","pageindex":"1"}&sign=b2d0aebeb9ad421914b79ca8ad565057  
				Object name = map.get("name");
				Object mobile = map.get("mobile");
				Object pageindex = map.get("pageindex");
				Object pagesize = map.get("pagesize");
				if(name == null || mobile == null || pageindex == null || pagesize == null){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				Map<String, Object> returnData = null;
				try{
					returnData = buy_ERP_GET_ORDERS_Service.selectByNameAndMobile(map);
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.1. 电商获取ERP订单列表接口 BUY_ERP_GET_ORDERS 请求参数："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.1. 电商获取ERP订单列表接口 BUY_ERP_GET_ORDERS"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }
				int totalCount = Integer.parseInt(returnData.get("recordcount").toString());
				if(totalCount > 0){
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", 0);
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", returnData);
				}else{
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", "1008");
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", "");
				}
			}else if("hx50_order.BUY_ERP_ORDER_CREATE".equals(reqMethod)){
				//3.2. 订单创建接口 BUY_ERP_ORDER_CREATE	
				//http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_order.BUY_ERP_ORDER_CREATE&sign=0ec3fcb24b119cf8d5bbf8b6cc945759
				/*{
				    "buy_intention_receipts_number": "YXD201806146896",
				    "erp_bu_number": "03",
				    "erp_shop_number": "03-01-02",
				    "erp_salesman_number": "wanyuezhong",
				    "purchasing_agent_name": "索瑜",
				    "purchasing_agent_mobile": "18037460379",
				    "intention_receipts_total_amount": 240,
				    "affirm_time": "2018-06-14 13:59:20",
				    "delivery_province": "上海市",
				    "delivery_city": "市辖区",
				    "delivery_county": "浦东新区",
				    "delivery_address": "远东宏信广场",
				    "delivery_name": "索瑜",
				    "delivery_mobile": "18037460379",
				    "invoice_type": "000",
				    "invoice_title": "001",
				    "note": " 【系统备注：用户提交意向单时使用了代金券， 代金券标题：高空满30减30 代金券额：30.0 请您知悉。】",
				    "delivery_way": "送货上门",
				    "product_details": [
				            {
				                "product_erp_number": "201-JG-05-01",
				                "predict_enter_arena_time": "2018-06-18 00:00:00",
				                "tenancy": 1,
				                "tenancy_unit": "天",
				                "lease_price": 270,
				                "quantity": 1
				            }
				    ],
				    "coupons": [
				        {
				            "coupon_number": "c84e1ebd-e24c-4e73-a62f-2358b338bf06",
				            "coupon_name": "高空满30减30",
				            "coupon_amount": 30
				        }
				    ]
				}*/
				try{
					buy_ERP_ORDER_CREATE_Service.insertOrUpateIntentionList(data);
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.2. 订单创建接口 BUY_ERP_ORDER_CREATE 请求参数："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.2. 订单创建接口 BUY_ERP_ORDER_CREATE"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	if("意向单号重复".equals(e.getMessage())){
			        		model.addAttribute("error_msg", "意向单号重复");
			        	}else{
			        		model.addAttribute("error_msg", "程序异常");
			        	}
			        	model.addAttribute("data", "");
			        	return "";
				   }
				model.addAttribute("status", 0);
		    	model.addAttribute("error_code", 0);
		    	model.addAttribute("error_msg", "");
		    	model.addAttribute("data", "");
			}else if("hx50_commonDemo.BUY_ERP_USER_SYNC".equals(reqMethod)){
				//3.3. 会员信息同步接口 BUY_ERP_USER_SYNC
				/*http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_commonDemo.BUY_ERP_USER_SYNC&data={
				    "buy_user_id": "f4572692-485c-494e-84e5-b601287f63b51",
				    "user_name": "yehaomiao",
				    "user_mobile": "18321000850"
				}&sign=c1cc410f06fffe5f2097cfa344445d5f*/
				Object buy_user_id = map.get("buy_user_id");
				Object user_mobile = map.get("user_mobile");
				if(buy_user_id == null || user_mobile == null){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				 try{
					 buy_ERP_USER_SYNC_Service.insertOrUpateMemberInfo(map);
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.3. 会员信息同步接口 BUY_ERP_USER_SYNC 请求参数："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.3. 会员信息同步接口 BUY_ERP_USER_SYNC"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }

				model.addAttribute("status", 0);
		    	model.addAttribute("error_code", 0);
		    	model.addAttribute("error_msg", "");
		    	model.addAttribute("data", "");
			}else if("hx50_receive_CAV.BUY_ERP_TOPUP_PAY".equals(reqMethod)){
				//3.4. 在线充值记录推送接口 BUY_ERP_TOPUP_PAY
				/*http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_receive_CAV.BUY_ERP_TOPUP_PAY&data={
    "payment_serial_number": "04930943184N",
    "topup_amount": 7400,
    "buy_user_id": "09c96d52-d1a5-4318-8d99-4f9186a30e4e",
    "user_name": "张永亮",
    "user_mobile": "13759938572",
    "pay_time": "2018-11-02 11:00:43",
    "pay_way": "022",
    "remark": "13759938572张永亮:森富",
    "source": "1",
    "order_sn": "Y001"
}&sign=5a6ac84acf13e3052ac3c3218475e1fe*/
				Object payment_serial_number = map.get("payment_serial_number");
				if(payment_serial_number == null){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				try{
					buy_ERP_TOPUP_PAY_Service.topupPay(map);
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.4. 在线充值记录推送接口 BUY_ERP_TOPUP_PAY 请求参数："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.4. 在线充值记录推送接口 BUY_ERP_TOPUP_PAY"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	if("付款流水号已存在！".equals(e.getMessage())){
			        		model.addAttribute("error_msg", "付款流水号已存在！");
			        	}else{
			        		model.addAttribute("error_msg", "程序异常");
			        	}
			        	model.addAttribute("data", "");
			        	return "";
				   }
				model.addAttribute("status", 0);
		    	model.addAttribute("error_code", 0);
		    	model.addAttribute("error_msg", "");
		    	model.addAttribute("data", "");
			}else if("hx50_refundment.BUY_ERP_REFUND_CONFIRM".equals(reqMethod)){
				//3.5.在线充值退款确认接口 BUY_ERP_REFUND_CONFIRM	//接口验证通过 但短信发送未验证 ??
				//http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_refundment.BUY_ERP_REFUND_CONFIRM&sign=e73ac38bc828584a99d70201ffd457f6
				/*{
				    "erp_refund_record_details_id": "97446733",
				    "erp_refund_record_id": "97446733",
				    "erp_refund_record_number": "RD2018020011",
				    "payment_serial_number": "12345678987654321",
				    "refund_serial_number": "98765432123456789",
				    "refund_time": "2018-05-03 10:00:00",
				    "refund_status": 4
				}*/
				Object BillID = map.get("erp_refund_record_id");
				Object billDtlID = map.get("erp_refund_record_details_id");
				Object no = map.get("erp_refund_record_number");
				Object pSerialNum = map.get("payment_serial_number");
				Object refund_status = map.get("refund_status");
				if(BillID == null || billDtlID == null || no == null || pSerialNum == null || refund_status == null ){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				try{
					buy_ERP_REFUND_CONFIRM_Service.refundConfirm(map);
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.5.在线充值退款确认接口 BUY_ERP_REFUND_CONFIRM 请求参数："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.5.在线充值退款确认接口 BUY_ERP_REFUND_CONFIRM"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }
				model.addAttribute("status", 0);
		    	model.addAttribute("error_code", 0);
		    	model.addAttribute("error_msg", "");
		    	model.addAttribute("data", "");
			}else if("hx50_receive_CAV.BUY_ERP_GET_PAYMENT_RECORD".equals(reqMethod)){
				//3.6. ERP历史付款记录查询接口 BUY_ERP_GET_PAYMENT_RECORD
				//http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_receive_CAV.BUY_ERP_GET_PAYMENT_RECORD&sign=70faaed96d728c50f15525211d06d21e
				/*{
					"erp_order_ids": [
					        89544500,
					        89543659
					    ]
					}*/
				Object erp_order_ids = map.get("erp_order_ids");
				if(erp_order_ids == null){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				List<PaymentRecord> returnData = null;
				try{
					returnData = buy_ERP_GET_PAYMENT_RECORD_Service.selectData(erp_order_ids.toString());
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.6. ERP历史付款记录查询接口 BUY_ERP_GET_PAYMENT_RECORD 请求参数："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.6. ERP历史付款记录查询接口 BUY_ERP_GET_PAYMENT_RECORD"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }
				if(returnData != null && returnData.size() >0){
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", 0);
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", returnData);
				}else{
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", "1008");
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", "");
				}
			}else if("hx50_refundment.BUY_ERP_GET_REFUND_RECORD".equals(reqMethod)){
				//3.7. ERP历史退款记录信息接口 BUY_ERP_GET_REFUND_RECORD	//erp接口明细显示不出来
				//http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_refundment.BUY_ERP_GET_REFUND_RECORD&sign=d59d9b087efb3d8fcdc65ffac7474a7a
				/*{
					"erp_order_ids": [
					        89422548,
					        6035276
					    ]
					}*/
				Object erp_order_ids = map.get("erp_order_ids");
				if(erp_order_ids == null){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				List<RefundRecord> returnData = null;
				try{
					returnData = buy_ERP_GET_REFUND_RECORD_Service.selectData(erp_order_ids.toString());
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.7. ERP历史退款记录信息接口 BUY_ERP_GET_REFUND_RECORD 请求参数："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.7. ERP历史退款记录信息接口 BUY_ERP_GET_REFUND_RECORD"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }
				if(returnData != null && returnData.size() >0){
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", 0);
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", returnData);
				}else{
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", "1008");
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", "");
				}
			}else if("hx50_commonDemo.BUY_ERP_PRODUCT_VERIFY".equals(reqMethod)){
				//3.8.商品编码验证接口 BUY_ERP_PRODUCT_VERIFY
				/*http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_commonDemo.BUY_ERP_PRODUCT_VERIFY&data={
				    "product_erp_number": '403-BY-01-01'
				}&sign=1b42e9b15dad387532b1bc9625b35377*/
				Object product_erp_number = map.get("product_erp_number");
				if(product_erp_number == null){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				List<CP_HX01_EquModel> returnData = null;
				try{
					returnData = buy_ERP_PRODUCT_VERIFY_Service.selectData(product_erp_number.toString());
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.8.商品编码验证接口 BUY_ERP_PRODUCT_VERIFY 请求参数："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.8.商品编码验证接口 BUY_ERP_PRODUCT_VERIFY"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }
				if(returnData != null && returnData.size() >0){
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", 0);
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", "");
				}else{
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", "1008");
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", "");
				}
			}else if("hx50_receive_CAV.BUY_ERP_GET_PAYMENT_ACCOUNT".equals(reqMethod)){
				//3.9. 电商在线支付记录对账BUY_ERP_GET_PAYMENT_ACCOUNT
				/*http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_receive_CAV.BUY_ERP_GET_PAYMENT_ACCOUNT&data={
				    "time": "2018-07-01"
				}&sign=e64e48e102487644035bad868bada792*/
				Object time = map.get("time");
				if(time == null){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				List<PaymentRecord2> returnData = null;
				try{
					returnData = buy_ERP_GET_PAYMENT_ACCOUNT_Service.selectData(time.toString());
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.9. 电商在线支付记录对账BUY_ERP_GET_PAYMENT_ACCOUNT："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.9. 电商在线支付记录对账BUY_ERP_GET_PAYMENT_ACCOUNT"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }
				if(returnData != null && returnData.size() >0){
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", 0);
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", returnData);
				}else{
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", "1008");
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", "");
				}
			}else if("hx50_refundment.BUY_ERP_GET_REFUND_ACCOUNT".equals(reqMethod)){
				//3.10. 电商退款记录对账BUY_ERP_GET_REFUND_ACCOUNT
				/*http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_refundment.BUY_ERP_GET_REFUND_ACCOUNT&data={
				    "time": "2018-07-01"
				}&sign=e64e48e102487644035bad868bada792*/
				Object time = map.get("time");
				if(time == null){
					model.addAttribute("status", 1);
		        	model.addAttribute("error_code", "1007");
		        	model.addAttribute("error_msg", "参数缺失");
		        	model.addAttribute("data", "");
		        	return "";
				}
				List<RefundRecord2> returnData = null;
				try{
					returnData = buy_ERP_GET_REFUND_ACCOUNT_Service.selectData(time.toString());
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.10. 电商退款记录对账BUY_ERP_GET_REFUND_ACCOUNT："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.10. 电商退款记录对账BUY_ERP_GET_REFUND_ACCOUNT"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }
				if(returnData != null && returnData.size() >0){
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", 0);
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", returnData);
				}else{
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", "1008");
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", "");
				}
			}else if("hx50_order.BUY_ERP_GET_DELIVERY_CREATE".equals(reqMethod)){
				//3.11.进退场交接单查询接口 BUY_ERP_GET_DELIVERY_CREATE
				//http://10.32.32.195:8089/hxbiz/a/erpcss/?account=HXB2B&version=1&method=hx50_order.BUY_ERP_GET_DELIVERY_CREATE&sign=860bab15d4e3f856f4b2a4af9088a88d
				//{"erp_order_ids":[89461564,89461972],"delivery_type":"002"}
				List<ReceiptRecord> returnData = null;
				try{
					returnData = buy_ERP_GET_DELIVERY_CREATE_Service.selectData(data);
				    }catch(Exception e){
				    	System.out.println("请求参数："+data);
				    	log.error("3.11.进退场交接单查询接口 BUY_ERP_GET_DELIVERY_CREATE："+data);
				    	System.out.println(e.getMessage());
				    	log.error("3.11.进退场交接单查询接口 BUY_ERP_GET_DELIVERY_CREATE"+e.getMessage());
				    	model.addAttribute("status", 1);
			        	model.addAttribute("error_code", "1001");
			        	model.addAttribute("error_msg", "程序异常");
			        	model.addAttribute("data", "");
			        	return "";
				   }
				if(returnData != null && returnData.size() >0){
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", 0);
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", returnData);
				}else{
					model.addAttribute("status", 0);
			    	model.addAttribute("error_code", "1008");
			    	model.addAttribute("error_msg", "");
			    	model.addAttribute("data", "");
				}
			}
    	}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			model.addAttribute("status", 1);
        	model.addAttribute("error_code", 1001);
        	model.addAttribute("error_msg", e.getMessage());
        	model.addAttribute("data", "");
		}
    	String module = reqMethod.substring(0, dotIdx);
    	String action = reqMethod.substring(dotIdx + 1);
    	//防止代码注入
    	module = module.replace(',', '_');
    	action = action.replace(',', '_');
    	// 分析请求参数
    	String jsonData = request.getParameter("data");
    	jsonData = request.getParameter("data");
    	if (jsonData != null){
    		String method = action;
    	    try {
				jsonData = decodeURIComponent(jsonData);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    JSONObject  dataObject = JSON.parseObject(jsonData);
    	    String dataStr = data.toString().substring(0, Math.min(data.toString().length(), 3000)); // oralce字段最多4000字符
            String msg = model.toString().substring(0, Math.min(model.toString().length(), 3000)); // oralce字段最多4000字符
            //记录调用的报文
        	SCM_CSS_HTTPRECEIVELOG scm_CSS_HTTPRECEIVELOG = new SCM_CSS_HTTPRECEIVELOG();
        	scm_CSS_HTTPRECEIVELOG.setModule(module);
        	scm_CSS_HTTPRECEIVELOG.setMethod(method);
        	scm_CSS_HTTPRECEIVELOG.setDatajsonstr(dataStr);
        	scm_CSS_HTTPRECEIVELOG.setResponsecode(1L);
        	scm_CSS_HTTPRECEIVELOG.setResponsemsg(msg);
        	scm_CSS_HTTPRECEIVELOG.setResponsedate(new Timestamp((new java.util.Date()).getTime()));
        	css_Service.insertHttpReceiveLog(scm_CSS_HTTPRECEIVELOG);
    	}
    	return "success";
    }
    
    
    private String decodeURIComponent(String str) throws UnsupportedEncodingException{
        String result = URLDecoder.decode(str,"UTF-8");
        return result;
    }
}  