package com.hxsb.dao.BUY_ERP_USER_SYNC;

import java.util.List;
import java.util.Map;

import com.hxsb.model.BUY_ERP_USER_SYNC.MemberInfo;
import com.hxsb.model.BUY_ERP_USER_SYNC.Notice;
import com.hxsb.model.BUY_ERP_USER_SYNC.Relation;
import com.hxsb.model.BUY_ERP_USER_SYNC.SCM_HX00_MemberInfoHead;

public interface SCM_HX00_MemberInfoHead_Dao {
	SCM_HX00_MemberInfoHead selectByUserId(String buy_user_id);
	void updateBySelective(SCM_HX00_MemberInfoHead bean);
    int insert(SCM_HX00_MemberInfoHead record);
    //获取最大的单据号
    Long selectMaxBillId();
    //获取最大的单据号
    String selectMaxNo();
    List<MemberInfo> selectByUserMobile(String userMobile);
    List<Relation> selectRelations(String searchStr);
    List<Notice> selectNotice(Long billid);
    void updateByMobile(String userMobile);
}