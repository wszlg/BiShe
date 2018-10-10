/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zhum.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zhum.entity.ZHum;

/**
 * 人文表DAO接口
 * @author zlg
 * @version 2018-10-10
 */
@MyBatisDao
public interface ZHumDao extends CrudDao<ZHum> {
	
}