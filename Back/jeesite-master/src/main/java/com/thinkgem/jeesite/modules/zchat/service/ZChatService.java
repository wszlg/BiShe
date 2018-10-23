/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zchat.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zchat.entity.ZChat;
import com.thinkgem.jeesite.modules.zchat.dao.ZChatDao;

/**
 * 话题表Service
 * @author zlg
 * @version 2018-10-23
 */
@Service
@Transactional(readOnly = true)
public class ZChatService extends CrudService<ZChatDao, ZChat> {

	public ZChat get(String id) {
		return super.get(id);
	}
	
	public List<ZChat> findList(ZChat zChat) {
		return super.findList(zChat);
	}
	
	public Page<ZChat> findPage(Page<ZChat> page, ZChat zChat) {
		return super.findPage(page, zChat);
	}
	
	@Transactional(readOnly = false)
	public void save(ZChat zChat) {
		super.save(zChat);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZChat zChat) {
		super.delete(zChat);
	}
	
}