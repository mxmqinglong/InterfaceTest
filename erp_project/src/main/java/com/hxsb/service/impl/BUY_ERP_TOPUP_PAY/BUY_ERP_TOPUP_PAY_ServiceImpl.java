package com.hxsb.service.impl.BUY_ERP_TOPUP_PAY;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hxsb.dao.BUY_ERP_GET_PAYMENT_RECORD.SCM_HX07_Receive_CAVHead_Dao;
import com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD.SCM_HX07_Receive_CAVHead;
import com.hxsb.service.BUY_ERP_TOPUP_PAY.BUY_ERP_TOPUP_PAY_Service;
import com.hxsb.service.css.Css_Service;
  
  
@Service("buy_ERP_TOPUP_PAY_Service") 
@Transactional
public class BUY_ERP_TOPUP_PAY_ServiceImpl implements BUY_ERP_TOPUP_PAY_Service { 
	@Autowired
	private SCM_HX07_Receive_CAVHead_Dao scm_HX07_Receive_CAVHead_Dao;
	@Autowired 
	private Css_Service css_Service;

	public void topupPay(Map<String, Object> map) {
		String SerialNo = map.get("payment_serial_number").toString();//付款流水号
		List<SCM_HX07_Receive_CAVHead> scm_HX07_Receive_CAVHeadList = scm_HX07_Receive_CAVHead_Dao.selectBillidBySerialNo(SerialNo);
		if(scm_HX07_Receive_CAVHeadList.size() > 0 ){
	        throw new RuntimeException("付款流水号已存在！");
	    }
		
		/*Long maxBillId = scm_HX07_Receive_CAVHead_Dao.selectMaxBillId();
		String selectMaxNo = scm_HX07_Receive_CAVHead_Dao.selectMaxNo();
		
		Long billid = maxBillId+1;
		String no = format(selectMaxNo);*/
		//Long billid = css_Service.dbGetNumber("BILL", 1);
		String no = css_Service.getNO("HX07_Receive_CAV");
		//System.out.println(billid+"<<<<<"+no);
		
		
		SCM_HX07_Receive_CAVHead scm_HX07_Receive_CAVHead = new SCM_HX07_Receive_CAVHead();
		//scm_HX07_Receive_CAVHead.setBillid(billid);	
		scm_HX07_Receive_CAVHead.setNo(no);	
		scm_HX07_Receive_CAVHead.setStatus(10);
		scm_HX07_Receive_CAVHead.setMaker(-1);
		scm_HX07_Receive_CAVHead.setMender(-1);
		scm_HX07_Receive_CAVHead.setChecker(-1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nowdayTime = dateFormat.format(new Date());
		Date nowDate = null;
		try {
			nowDate = dateFormat.parse(nowdayTime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scm_HX07_Receive_CAVHead.setMakedate(nowDate);
		scm_HX07_Receive_CAVHead.setBilldate(nowDate);
		scm_HX07_Receive_CAVHead.setEditdate(nowDate);
		scm_HX07_Receive_CAVHead.setCheckdatetime(new Date());
		scm_HX07_Receive_CAVHead.setBilldescr("收款核销记录");
		scm_HX07_Receive_CAVHead.setCorpid(999);

		//	    获取接口传递的数据
	    Double ReceiveAmount = Double.parseDouble(map.get("topup_amount").toString());//充值金额
	    String PayWay = map.get("pay_way").toString();
	    String MemberID = map.get("buy_user_id").toString();//会员ID
	    String MemberName = map.get("user_name").toString();//会员姓名
	    String MemberTel = map.get("user_mobile").toString();//会员手机号
	    String PayTimeStr = map.get("pay_time").toString();//支付时间
	    String note = map.get("remark").toString();//支付时间
	    String OnlineOrderType = map.get("source").toString();//来源 :1 租赁 2销售
	    String OnlineOrderNo = map.get("order_sn").toString();//订单编号，销售订单维一标识
	    
	    SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	    Date PayTime=null;
		try {
			PayTime = sdf.parse(PayTimeStr);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException("日期格式转换错误");
		}
	    
	    //	    更新到相应字段并保存
	    scm_HX07_Receive_CAVHead.setReceivebank("交通银行新区支行");//收款银行
	    scm_HX07_Receive_CAVHead.setReceiveacount("310066111018170261313");//收款账户
	    scm_HX07_Receive_CAVHead.setSerialno(SerialNo);//付款流水号
	    scm_HX07_Receive_CAVHead.setReceiveamount(ReceiveAmount);//收款金额
	    
	    scm_HX07_Receive_CAVHead.setPayway(PayWay);//支付方式  001:支付宝 002:微信  003:银联 004:线下
	    scm_HX07_Receive_CAVHead.setMemberid(MemberID);//会员ID
	    scm_HX07_Receive_CAVHead.setMembername(MemberName);//会员姓名
	    scm_HX07_Receive_CAVHead.setMembertel(MemberTel);//会员手机号
	    scm_HX07_Receive_CAVHead.setReceivedate(PayTime);//收款日期
	    
	    scm_HX07_Receive_CAVHead.setPaytime(PayTime);//支付时间
	    scm_HX07_Receive_CAVHead.setBizUnit(-1);//事业部
	    scm_HX07_Receive_CAVHead.setBizArea(-1);//区域
	    scm_HX07_Receive_CAVHead.setBizShop(-1);//营业店
	    scm_HX07_Receive_CAVHead.setBizCompany(-1);//所属公司
	    
	    scm_HX07_Receive_CAVHead.setNote(note);;//备注
	    
	    scm_HX07_Receive_CAVHead.setOnlineOrderType(OnlineOrderType);//来源 :1 租赁 2销售
	    scm_HX07_Receive_CAVHead.setOnlineOrderNo(OnlineOrderNo);//订单编号，销售订单维一标识
	    
	    
	    
	    scm_HX07_Receive_CAVHead_Dao.insert(scm_HX07_Receive_CAVHead);
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
		String no = "RC"+format+str;
		return no;
	}
}  
