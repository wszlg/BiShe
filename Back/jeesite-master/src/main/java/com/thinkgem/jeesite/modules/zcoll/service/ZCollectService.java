/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zcoll.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zcoll.entity.ZCollect;
import com.thinkgem.jeesite.modules.zcoll.dao.ZCollectDao;

/**
 * 收藏表Service
 * @author zlg
 * @version 2018-10-16
 */
@Service
@Transactional(readOnly = true)
public class ZCollectService extends CrudService<ZCollectDao, ZCollect> {

	public ZCollect get(String id) {
		return super.get(id);
	}
	
	public List<ZCollect> findList(ZCollect zCollect) {
		return super.findList(zCollect);
	}
	
	public Page<ZCollect> findPage(Page<ZCollect> page, ZCollect zCollect) {
		return super.findPage(page, zCollect);
	}
	
	@Transactional(readOnly = false)
	public void save(ZCollect zCollect) {
		super.save(zCollect);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZCollect zCollect) {
		super.delete(zCollect);
	}
	
}