/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ztec.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.ztec.entity.ZTec;

/**
 * 科技表DAO接口
 * @author zlg
 * @version 2018-10-10
 */
@MyBatisDao
public interface ZTecDao extends CrudDao<ZTec> {
	
}