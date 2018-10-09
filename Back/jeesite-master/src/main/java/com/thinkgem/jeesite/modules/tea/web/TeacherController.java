/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tea.web;

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
import com.thinkgem.jeesite.modules.tea.entity.Teacher;
import com.thinkgem.jeesite.modules.tea.service.TeacherService;

/**
 * 老师测试Controller
 * @author zlg
 * @version 2018-02-07
 */
@Controller
@RequestMapping(value = "${adminPath}/tea/teacher")
public class TeacherController extends BaseController {

	@Autowired
	private TeacherService teacherService;
	
	@ModelAttribute
	public Teacher get(@RequestParam(required=false) String id) {
		Teacher entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = teacherService.get(id);
		}
		if (entity == null){
			entity = new Teacher();
		}
		return entity;
	}
	
	@RequiresPermissions("tea:teacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(Teacher teacher, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Teacher> page = teacherService.findPage(new Page<Teacher>(request, response), teacher); 
		model.addAttribute("page", page);
		return "modules/tea/teacherList";
	}

	@RequiresPermissions("tea:teacher:view")
	@RequestMapping(value = "form")
	public String form(Teacher teacher, Model model) {
		model.addAttribute("teacher", teacher);
		return "modules/tea/teacherForm";
	}

	@RequiresPermissions("tea:teacher:edit")
	@RequestMapping(value = "save")
	public String save(Teacher teacher, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, teacher)){
			return form(teacher, model);
		}
		teacherService.save(teacher);
		addMessage(redirectAttributes, "保存老师测试成功");
		return "redirect:"+Global.getAdminPath()+"/tea/teacher/?repage";
	}
	
	@RequiresPermissions("tea:teacher:edit")
	@RequestMapping(value = "delete")
	public String delete(Teacher teacher, RedirectAttributes redirectAttributes) {
		teacherService.delete(teacher);
		addMessage(redirectAttributes, "删除老师测试成功");
		return "redirect:"+Global.getAdminPath()+"/tea/teacher/?repage";
	}

}