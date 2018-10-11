/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zjmna.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zjmna.entity.ZJmna;
import com.thinkgem.jeesite.modules.zjmna.dao.ZJmnaDao;

/**
 * 经管表Service
 * @author zlg
 * @version 2018-10-11
 */
@Service
@Transactional(readOnly = true)
public class ZJmnaService extends CrudService<ZJmnaDao, ZJmna> {

	public ZJmna get(String id) {
		return super.get(id);
	}
	
	public List<ZJmna> findList(ZJmna zJmna) {
		return super.findList(zJmna);
	}
	
	public Page<ZJmna> findPage(Page<ZJmna> page, ZJmna zJmna) {
		return super.findPage(page, zJmna);
	}
	
	@Transactional(readOnly = false)
	public void save(ZJmna zJmna) {
		super.save(zJmna);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZJmna zJmna) {
		super.delete(zJmna);
	}
	
}