/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tea.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.tea.entity.Teacher;

/**
 * 老师测试DAO接口
 * @author zlg
 * @version 2018-02-07
 */
@MyBatisDao
public interface TeacherDao extends CrudDao<Teacher> {
	
}