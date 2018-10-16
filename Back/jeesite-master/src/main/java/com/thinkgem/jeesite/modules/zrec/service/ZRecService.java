/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zrec.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zrec.entity.ZRec;
import com.thinkgem.jeesite.modules.zrec.dao.ZRecDao;

/**
 * 推荐表Service
 * @author zlg
 * @version 2018-10-16
 */
@Service
@Transactional(readOnly = true)
public class ZRecService extends CrudService<ZRecDao, ZRec> {

	public ZRec get(String id) {
		return super.get(id);
	}
	
	public List<ZRec> findList(ZRec zRec) {
		return super.findList(zRec);
	}
	
	public Page<ZRec> findPage(Page<ZRec> page, ZRec zRec) {
		return super.findPage(page, zRec);
	}
	
	@Transactional(readOnly = false)
	public void save(ZRec zRec) {
		super.save(zRec);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZRec zRec) {
		super.delete(zRec);
	}
	
}