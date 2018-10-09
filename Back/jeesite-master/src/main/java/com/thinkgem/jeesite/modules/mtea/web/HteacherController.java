/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mtea.web;

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
import com.thinkgem.jeesite.modules.mtea.entity.Hteacher;
import com.thinkgem.jeesite.modules.mtea.service.HteacherService;

/**
 * 班主任测试Controller
 * @author zlg
 * @version 2018-02-09
 */
@Controller
@RequestMapping(value = "${adminPath}/mtea/hteacher")
public class HteacherController extends BaseController {

	@Autowired
	private HteacherService hteacherService;
	
	@ModelAttribute
	public Hteacher get(@RequestParam(required=false) String id) {
		Hteacher entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = hteacherService.get(id);
		}
		if (entity == null){
			entity = new Hteacher();
		}
		return entity;
	}
	
	@RequiresPermissions("mtea:hteacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(Hteacher hteacher, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Hteacher> page = hteacherService.findPage(new Page<Hteacher>(request, response), hteacher); 
		model.addAttribute("page", page);
		return "modules/mtea/hteacherList";
	}

	@RequiresPermissions("mtea:hteacher:view")
	@RequestMapping(value = "form")
	public String form(Hteacher hteacher, Model model) {
		model.addAttribute("hteacher", hteacher);
		return "modules/mtea/hteacherForm";
	}

	@RequiresPermissions("mtea:hteacher:edit")
	@RequestMapping(value = "save")
	public String save(Hteacher hteacher, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, hteacher)){
			return form(hteacher, model);
		}
		hteacherService.save(hteacher);
		addMessage(redirectAttributes, "保存班主任测试成功");
		return "redirect:"+Global.getAdminPath()+"/mtea/hteacher/?repage";
	}
	
	@RequiresPermissions("mtea:hteacher:edit")
	@RequestMapping(value = "delete")
	public String delete(Hteacher hteacher, RedirectAttributes redirectAttributes) {
		hteacherService.delete(hteacher);
		addMessage(redirectAttributes, "删除班主任测试成功");
		return "redirect:"+Global.getAdminPath()+"/mtea/hteacher/?repage";
	}

}