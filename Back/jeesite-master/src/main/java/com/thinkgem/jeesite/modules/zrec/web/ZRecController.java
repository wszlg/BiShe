/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zrec.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.zrec.entity.ZRec;
import com.thinkgem.jeesite.modules.zrec.service.ZRecService;

/**
 * 推荐表Controller
 * @author zlg
 * @version 2018-10-16
 */
@Controller
@RequestMapping(value = "${adminPath}/zrec/zRec")
public class ZRecController extends BaseController {

	@Autowired
	private ZRecService zRecService;
	
	@ModelAttribute
	public ZRec get(@RequestParam(required=false) String id) {
		ZRec entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zRecService.get(id);
		}
		if (entity == null){
			entity = new ZRec();
		}
		return entity;
	}
	
	@RequiresPermissions("zrec:zRec:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZRec zRec, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZRec> page = zRecService.findPage(new Page<ZRec>(request, response), zRec); 
		model.addAttribute("page", page);
		return "modules/zrec/zRecList";
	}

	@RequiresPermissions("zrec:zRec:view")
	@RequestMapping(value = "form")
	public String form(ZRec zRec, Model model) {
		model.addAttribute("zRec", zRec);
		return "modules/zrec/zRecForm";
	}

	@RequiresPermissions("zrec:zRec:edit")
	@RequestMapping(value = "save")
	public String save(ZRec zRec, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zRec)){
			return form(zRec, model);
		}
		zRecService.save(zRec);
		addMessage(redirectAttributes, "保存推荐表成功");
		return "redirect:"+Global.getAdminPath()+"/zrec/zRec/?repage";
	}
	
	@RequiresPermissions("zrec:zRec:edit")
	@RequestMapping(value = "delete")
	public String delete(ZRec zRec, RedirectAttributes redirectAttributes) {
		zRecService.delete(zRec);
		addMessage(redirectAttributes, "删除推荐表成功");
		return "redirect:"+Global.getAdminPath()+"/zrec/zRec/?repage";
	}

}