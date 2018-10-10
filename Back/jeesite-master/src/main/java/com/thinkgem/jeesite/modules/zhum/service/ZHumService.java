/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zhum.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zhum.entity.ZHum;
import com.thinkgem.jeesite.modules.zhum.dao.ZHumDao;

/**
 * 人文表Service
 * @author zlg
 * @version 2018-10-10
 */
@Service
@Transactional(readOnly = true)
public class ZHumService extends CrudService<ZHumDao, ZHum> {

	public ZHum get(String id) {
		return super.get(id);
	}
	
	public List<ZHum> findList(ZHum zHum) {
		return super.findList(zHum);
	}
	
	public Page<ZHum> findPage(Page<ZHum> page, ZHum zHum) {
		return super.findPage(page, zHum);
	}
	
	@Transactional(readOnly = false)
	public void save(ZHum zHum) {
		super.save(zHum);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZHum zHum) {
		super.delete(zHum);
	}
	
}