/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zcoll.web;

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
import com.thinkgem.jeesite.modules.zcoll.entity.ZCollect;
import com.thinkgem.jeesite.modules.zcoll.service.ZCollectService;

/**
 * 收藏表Controller
 * @author zlg
 * @version 2018-10-16
 */
@Controller
@RequestMapping(value = "${adminPath}/zcoll/zCollect")
public class ZCollectController extends BaseController {

	@Autowired
	private ZCollectService zCollectService;
	
	@ModelAttribute
	public ZCollect get(@RequestParam(required=false) String id) {
		ZCollect entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zCollectService.get(id);
		}
		if (entity == null){
			entity = new ZCollect();
		}
		return entity;
	}
	
	@RequiresPermissions("zcoll:zCollect:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZCollect zCollect, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZCollect> page = zCollectService.findPage(new Page<ZCollect>(request, response), zCollect); 
		model.addAttribute("page", page);
		return "modules/zcoll/zCollectList";
	}

	@RequiresPermissions("zcoll:zCollect:view")
	@RequestMapping(value = "form")
	public String form(ZCollect zCollect, Model model) {
		model.addAttribute("zCollect", zCollect);
		return "modules/zcoll/zCollectForm";
	}

	@RequiresPermissions("zcoll:zCollect:edit")
	@RequestMapping(value = "save")
	public String save(ZCollect zCollect, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zCollect)){
			return form(zCollect, model);
		}
		zCollectService.save(zCollect);
		addMessage(redirectAttributes, "保存收藏表成功");
		return "redirect:"+Global.getAdminPath()+"/zcoll/zCollect/?repage";
	}
	
	@RequiresPermissions("zcoll:zCollect:edit")
	@RequestMapping(value = "delete")
	public String delete(ZCollect zCollect, RedirectAttributes redirectAttributes) {
		zCollectService.delete(zCollect);
		addMessage(redirectAttributes, "删除收藏表成功");
		return "redirect:"+Global.getAdminPath()+"/zcoll/zCollect/?repage";
	}

}