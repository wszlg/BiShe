/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znews.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.znews.entity.ZNews;

/**
 * 新闻表DAO接口
 * @author zlg
 * @version 2018-10-09
 */
@MyBatisDao
public interface ZNewsDao extends CrudDao<ZNews> {
	
}