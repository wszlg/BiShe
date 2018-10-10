/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zhum.web;

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
import com.thinkgem.jeesite.modules.zhum.entity.ZHum;
import com.thinkgem.jeesite.modules.zhum.service.ZHumService;

/**
 * 人文表Controller
 * @author zlg
 * @version 2018-10-10
 */
@Controller
@RequestMapping(value = "${adminPath}/zhum/zHum")
public class ZHumController extends BaseController {

	@Autowired
	private ZHumService zHumService;
	
	@ModelAttribute
	public ZHum get(@RequestParam(required=false) String id) {
		ZHum entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zHumService.get(id);
		}
		if (entity == null){
			entity = new ZHum();
		}
		return entity;
	}
	
	@RequiresPermissions("zhum:zHum:view")
	@RequestMapping(value = {"list", ""})
	public String list(@ModelAttribute("zHum") ZHum zHum, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZHum> page = zHumService.findPage(new Page<ZHum>(request, response), zHum); 
		model.addAttribute("page", page);
		return "modules/zhum/zHumList";
	}

	@RequiresPermissions("zhum:zHum:view")
	@RequestMapping(value = "form")
	public String form(ZHum zHum, Model model) {
		model.addAttribute("zHum", zHum);
		return "modules/zhum/zHumForm";
	}

	@RequiresPermissions("zhum:zHum:edit")
	@RequestMapping(value = "save")
	public String save(ZHum zHum, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zHum)){
			return form(zHum, model);
		}
		zHumService.save(zHum);
		addMessage(redirectAttributes, "保存人文表成功");
		return "redirect:"+Global.getAdminPath()+"/zhum/zHum/?repage";
	}
	
	@RequiresPermissions("zhum:zHum:edit")
	@RequestMapping(value = "delete")
	public String delete(ZHum zHum, RedirectAttributes redirectAttributes) {
		zHumService.delete(zHum);
		addMessage(redirectAttributes, "删除人文表成功");
		return "redirect:"+Global.getAdminPath()+"/zhum/zHum/?repage";
	}

}