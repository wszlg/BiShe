/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ztec.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.ztec.entity.ZTec;
import com.thinkgem.jeesite.modules.ztec.dao.ZTecDao;

/**
 * 科技表Service
 * @author zlg
 * @version 2018-10-10
 */
@Service
@Transactional(readOnly = true)
public class ZTecService extends CrudService<ZTecDao, ZTec> {

	public ZTec get(String id) {
		return super.get(id);
	}
	
	public List<ZTec> findList(ZTec zTec) {
		return super.findList(zTec);
	}
	
	public Page<ZTec> findPage(Page<ZTec> page, ZTec zTec) {
		return super.findPage(page, zTec);
	}
	
	@Transactional(readOnly = false)
	public void save(ZTec zTec) {
		super.save(zTec);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZTec zTec) {
		super.delete(zTec);
	}
	
}