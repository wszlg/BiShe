/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zcoll.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zcoll.entity.ZCollect;

/**
 * 收藏表DAO接口
 * @author zlg
 * @version 2018-10-16
 */
@MyBatisDao
public interface ZCollectDao extends CrudDao<ZCollect> {
	
}