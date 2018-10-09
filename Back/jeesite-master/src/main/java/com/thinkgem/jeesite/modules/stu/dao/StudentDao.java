/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.stu.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.stu.entity.Student;

/**
 * 学生测试DAO接口
 * @author zlg
 * @version 2018-01-29
 */
@MyBatisDao
public interface StudentDao extends CrudDao<Student> {
	
}