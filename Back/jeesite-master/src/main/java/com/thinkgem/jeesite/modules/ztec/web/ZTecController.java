/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ztec.web;

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
import com.thinkgem.jeesite.modules.ztec.entity.ZTec;
import com.thinkgem.jeesite.modules.ztec.service.ZTecService;

/**
 * 科技表Controller
 * @author zlg
 * @version 2018-10-10
 */
@Controller
@RequestMapping(value = "${adminPath}/ztec/zTec")
public class ZTecController extends BaseController {

	@Autowired
	private ZTecService zTecService;
	
	@ModelAttribute
	public ZTec get(@RequestParam(required=false) String id) {
		ZTec entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zTecService.get(id);
		}
		if (entity == null){
			entity = new ZTec();
		}
		return entity;
	}
	
	@RequiresPermissions("ztec:zTec:view")
	@RequestMapping(value = {"list", ""})
	public String list(@ModelAttribute("zTec") ZTec zTec, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZTec> page = zTecService.findPage(new Page<ZTec>(request, response), zTec); 
		model.addAttribute("page", page);
		return "modules/ztec/zTecList";
	}

	@RequiresPermissions("ztec:zTec:view")
	@RequestMapping(value = "form")
	public String form(ZTec zTec, Model model) {
		model.addAttribute("zTec", zTec);
		return "modules/ztec/zTecForm";
	}

	@RequiresPermissions("ztec:zTec:edit")
	@RequestMapping(value = "save")
	public String save(ZTec zTec, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zTec)){
			return form(zTec, model);
		}
		zTecService.save(zTec);
		addMessage(redirectAttributes, "保存科技表成功");
		return "redirect:"+Global.getAdminPath()+"/ztec/zTec/?repage";
	}
	
	@RequiresPermissions("ztec:zTec:edit")
	@RequestMapping(value = "delete")
	public String delete(ZTec zTec, RedirectAttributes redirectAttributes) {
		zTecService.delete(zTec);
		addMessage(redirectAttributes, "删除科技表成功");
		return "redirect:"+Global.getAdminPath()+"/ztec/zTec/?repage";
	}

}