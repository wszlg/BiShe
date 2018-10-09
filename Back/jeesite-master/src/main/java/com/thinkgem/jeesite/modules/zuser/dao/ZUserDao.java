/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zuser.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zuser.entity.ZUser;

/**
 * 用户表DAO接口
 * @author zlg
 * @version 2018-10-09
 */
@MyBatisDao
public interface ZUserDao extends CrudDao<ZUser> {
	
}