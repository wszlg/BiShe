/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zuser.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zuser.entity.ZUser;
import com.thinkgem.jeesite.modules.zuser.dao.ZUserDao;

/**
 * 用户表Service
 * @author zlg
 * @version 2018-10-09
 */
@Service
@Transactional(readOnly = true)
public class ZUserService extends CrudService<ZUserDao, ZUser> {

	public ZUser get(String id) {
		return super.get(id);
	}
	
	public List<ZUser> findList(ZUser zUser) {
		return super.findList(zUser);
	}
	
	public Page<ZUser> findPage(Page<ZUser> page, ZUser zUser) {
		return super.findPage(page, zUser);
	}
	
	@Transactional(readOnly = false)
	public void save(ZUser zUser) {
		super.save(zUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZUser zUser) {
		super.delete(zUser);
	}
	
}