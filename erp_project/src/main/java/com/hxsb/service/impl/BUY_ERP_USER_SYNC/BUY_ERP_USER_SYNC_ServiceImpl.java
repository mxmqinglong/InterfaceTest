package com.hxsb.service.impl.BUY_ERP_USER_SYNC;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxsb.dao.BUY_ERP_ORDER_CREATE.SCM_S00_NOTICE_Dao;
import com.hxsb.dao.BUY_ERP_USER_SYNC.SCM_HX00_AuthoryChangeHead_Dao;
import com.hxsb.dao.BUY_ERP_USER_SYNC.SCM_HX00_MemberInfoHead_Dao;
import com.hxsb.model.BUY_ERP_ORDER_CREATE.SCM_S00_NOTICE;
import com.hxsb.model.BUY_ERP_USER_SYNC.Notice;
import com.hxsb.model.BUY_ERP_USER_SYNC.Relation;
import com.hxsb.model.BUY_ERP_USER_SYNC.SCM_HX00_AuthoryChangeHead;
import com.hxsb.model.BUY_ERP_USER_SYNC.SCM_HX00_MemberInfoHead;
import com.hxsb.service.BUY_ERP_USER_SYNC.BUY_ERP_USER_SYNC_Service;
import com.hxsb.service.css.Css_Service;
  
@Service("buy_ERP_USER_SYNC_Service")  
@Transactional
public class BUY_ERP_USER_SYNC_ServiceImpl implements BUY_ERP_USER_SYNC_Service { 
	@Autowired
	private SCM_HX00_MemberInfoHead_Dao scm_HX00_MemberInfoHead_Dao;
	@Autowired 
	private Css_Service css_Service;
	@Autowired 
	private SCM_HX00_AuthoryChangeHead_Dao scm_HX00_AuthoryChangeHead_Dao;
	@Autowired 
	private SCM_S00_NOTICE_Dao scm_S00_NOTICE_Dao;
	
	public void insertOrUpateMemberInfo(Map<String, Object> map) {
		Object user_nameObj = map.get("user_name");
		Object user_mobileObj = map.get("user_mobile");
		String user_name = null;
		String user_mobile = null;
		if(user_nameObj == null ){
			user_name = "";
		}else{
			user_name = user_nameObj.toString();
		}
		if(user_mobileObj == null ){
			user_mobile = "";
		}else{
			user_mobile = user_mobileObj.toString();
		}
		
		SCM_HX00_MemberInfoHead member = scm_HX00_MemberInfoHead_Dao.selectByUserId(map.get("buy_user_id").toString());
		if(member != null){//erp存在则更新
			//变更前后的姓名和手机号一致时不做变更
			String user_nameReturn = member.getUserName();
			String user_mobileReturn = member.getUserMobile();
			if(user_nameReturn == null ){
				user_nameReturn = "";
			}
			if(user_mobileReturn == null ){
				user_mobileReturn = "";
			}
			if(user_name.equals(user_nameReturn) && user_mobile.equals(user_mobileReturn)){	
				System.out.println("变更前后的姓名和手机号一致");
			}else{
				SCM_HX00_MemberInfoHead scm_HX00_MemberInfoHeadUpdate = new SCM_HX00_MemberInfoHead();
				scm_HX00_MemberInfoHeadUpdate.setBillid(member.getBillid());
				scm_HX00_MemberInfoHeadUpdate.setBuyUserId(map.get("buy_user_id").toString());
				scm_HX00_MemberInfoHeadUpdate.setUserName(user_name);
				scm_HX00_MemberInfoHeadUpdate.setUserMobile(map.get("user_mobile").toString());
				scm_HX00_MemberInfoHeadUpdate.setMaker(1);	
				scm_HX00_MemberInfoHeadUpdate.setEditdate(new java.sql.Date((new java.util.Date()).getTime()));
				
				scm_HX00_MemberInfoHead_Dao.updateBySelective(scm_HX00_MemberInfoHeadUpdate);
				
				
				//生成授权人信息变更单
				String userName = member.getUserName();
				String userMobile = member.getUserMobile();
				String searchStr = userName + userMobile;
				List<Relation> relations = scm_HX00_MemberInfoHead_Dao.selectRelations(searchStr);
				
				SCM_HX00_AuthoryChangeHead scm_HX00_AuthoryChangeHead = null;
				for(Relation relation:relations){
					scm_HX00_AuthoryChangeHead = new SCM_HX00_AuthoryChangeHead();
					//Long billID = css_Service.dbGetNumber("BILL", 1);
					String billNo = css_Service.getNO("HX00_AuthoryChange");
					
					scm_HX00_AuthoryChangeHead.setRelatenos(relation.getRelateNos());
					scm_HX00_AuthoryChangeHead.setRelateids(relation.getRelateIDs());
					scm_HX00_AuthoryChangeHead.setBuyUserId(map.get("buy_user_id").toString());
					scm_HX00_AuthoryChangeHead.setNowname(userName);
					scm_HX00_AuthoryChangeHead.setNowmobile(userMobile);
					
					scm_HX00_AuthoryChangeHead.setChangename(map.get("user_name").toString());
					scm_HX00_AuthoryChangeHead.setChangemobile(map.get("user_mobile").toString());
					scm_HX00_AuthoryChangeHead.setBizArea(relation.getBiz_Area());
					scm_HX00_AuthoryChangeHead.setBizShop(-1);
					scm_HX00_AuthoryChangeHead.setMaker(-1);	//操作者id为未指定 ???
					
					scm_HX00_AuthoryChangeHead.setStatus(10);
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String nowdayTime = dateFormat.format(new Date());
					Date nowDate = null;
					try {
						nowDate = dateFormat.parse(nowdayTime);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					scm_HX00_AuthoryChangeHead.setBilldate(nowDate);
					scm_HX00_AuthoryChangeHead.setBizUnit(relation.getBiz_Unit());
					//scm_HX00_AuthoryChangeHead.setBillid(billID);
					scm_HX00_AuthoryChangeHead.setNo(billNo);
					
					scm_HX00_AuthoryChangeHead_Dao.insert(scm_HX00_AuthoryChangeHead);
					Long billID = scm_HX00_AuthoryChangeHead.getBillid();
					
					List<Notice> notices = scm_HX00_MemberInfoHead_Dao.selectNotice(billID);
					if(notices != null && notices.size() > 0){
				    	ArrayList<SCM_S00_NOTICE> scm_S00_NOTICEList = new ArrayList<SCM_S00_NOTICE>();
				    	SCM_S00_NOTICE scm_S00_NOTICE = null;
				    	for(Notice notice:notices){
				    		scm_S00_NOTICE = new SCM_S00_NOTICE();
				    		
				    		
				    		scm_S00_NOTICE.setReckey(billID);	//???
				    		
				    		scm_S00_NOTICE.setTaskname("授权人变更提醒");
				    		scm_S00_NOTICE.setDataname("授权人信息变更单");
				    		scm_S00_NOTICE.setDatacode(billNo);//???
				    		
				    		scm_S00_NOTICE.setBizunitid(notice.getBiz_Unit());
				    		scm_S00_NOTICE.setBizareaid(notice.getBiz_Area());
				    		scm_S00_NOTICE.setBizshopid(-1L);
				    		scm_S00_NOTICE.setDeptid(-1);
				    		
				    		scm_S00_NOTICE.setTitle(notice.getTitle());
				    		scm_S00_NOTICE.setOperator(notice.getOperatorID());
				    		scm_S00_NOTICE.setOptexp("HX_Notice_OpenBillInPage(HX00_AuthoryChange, "+billID+")");//???
				    		scm_S00_NOTICE.setOptdata(-1);
				    		scm_S00_NOTICE.setNoticename("HX50-03");
				    		
				    		scm_S00_NOTICE.setCreatetime(new Timestamp((new java.util.Date()).getTime()));
				    		
				    		scm_S00_NOTICE.setCreator(notice.getCreator());
				    		scm_S00_NOTICE.setBillid(billID);//???
				    		scm_S00_NOTICE.setBillkey("HX00_AuthoryChange");
				    		
				    		scm_S00_NOTICEList.add(scm_S00_NOTICE);
				    		scm_S00_NOTICE_Dao.insert(scm_S00_NOTICE);
					    }
					
					}
					
				
				}
			}
			
		}else{//erp不存在则插入
			String no = css_Service.getNO("HX00_MemberInfo");
			member = new SCM_HX00_MemberInfoHead();
			member.setBuyUserId(map.get("buy_user_id").toString());
			member.setUserName(user_name);
			member.setUserMobile(map.get("user_mobile").toString());
			member.setMaker(1);	//???
			member.setBilldate(new java.sql.Date((new java.util.Date()).getTime()));
			member.setMakedate(new java.sql.Date((new java.util.Date()).getTime()));
			member.setBizArea(-1);
			member.setStatus(30);
			//member.setBillid(BillId);
			member.setNo(no);
			
			scm_HX00_MemberInfoHead_Dao.insert(member);
		}
		
		
	}
    
    
  
}  
