/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zrec.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zrec.entity.ZRec;

/**
 * 推荐表DAO接口
 * @author zlg
 * @version 2018-10-16
 */
@MyBatisDao
public interface ZRecDao extends CrudDao<ZRec> {
	
}