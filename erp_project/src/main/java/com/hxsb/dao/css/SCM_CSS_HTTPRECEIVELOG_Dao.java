package com.hxsb.dao.css;

import com.hxsb.model.css.SCM_CSS_HTTPRECEIVELOG;

public interface SCM_CSS_HTTPRECEIVELOG_Dao {
	Long selectMaxId();
    int insert(SCM_CSS_HTTPRECEIVELOG record);
}