/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znews.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znews.entity.ZNews;
import com.thinkgem.jeesite.modules.znews.dao.ZNewsDao;

/**
 * 新闻表Service
 * @author zlg
 * @version 2018-10-09
 */
@Service
@Transactional(readOnly = true)
public class ZNewsService extends CrudService<ZNewsDao, ZNews> {

	public ZNews get(String id) {
		return super.get(id);
	}
	
	public List<ZNews> findList(ZNews zNews) {
		return super.findList(zNews);
	}
	
	public Page<ZNews> findPage(Page<ZNews> page, ZNews zNews) {
		return super.findPage(page, zNews);
	}
	
	@Transactional(readOnly = false)
	public void save(ZNews zNews) {
		super.save(zNews);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZNews zNews) {
		super.delete(zNews);
	}
	
}