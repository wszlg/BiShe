/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mtea.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.mtea.entity.Hteacher;
import com.thinkgem.jeesite.modules.mtea.dao.HteacherDao;

/**
 * 班主任测试Service
 * @author zlg
 * @version 2018-02-09
 */
@Service
@Transactional(readOnly = true)
public class HteacherService extends CrudService<HteacherDao, Hteacher> {

	public Hteacher get(String id) {
		return super.get(id);
	}
	
	public List<Hteacher> findList(Hteacher hteacher) {
		return super.findList(hteacher);
	}
	
	public Page<Hteacher> findPage(Page<Hteacher> page, Hteacher hteacher) {
		return super.findPage(page, hteacher);
	}
	
	@Transactional(readOnly = false)
	public void save(Hteacher hteacher) {
		super.save(hteacher);
	}
	
	@Transactional(readOnly = false)
	public void delete(Hteacher hteacher) {
		super.delete(hteacher);
	}
	
}