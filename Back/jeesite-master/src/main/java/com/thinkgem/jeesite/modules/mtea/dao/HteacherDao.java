/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mtea.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.mtea.entity.Hteacher;

/**
 * 班主任测试DAO接口
 * @author zlg
 * @version 2018-02-09
 */
@MyBatisDao
public interface HteacherDao extends CrudDao<Hteacher> {
	
}