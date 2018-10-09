/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znews.web;

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
import com.thinkgem.jeesite.modules.znews.entity.ZNews;
import com.thinkgem.jeesite.modules.znews.service.ZNewsService;

/**
 * 新闻表Controller
 * @author zlg
 * @version 2018-10-09
 */
@Controller
@RequestMapping(value = "${adminPath}/znews/zNews")
public class ZNewsController extends BaseController {

	@Autowired
	private ZNewsService zNewsService;
	
	@ModelAttribute
	public ZNews get(@RequestParam(required=false) String id) {
		ZNews entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zNewsService.get(id);
		}
		if (entity == null){
			entity = new ZNews();
		}
		return entity;
	}
	
	@RequiresPermissions("znews:zNews:view")
	@RequestMapping(value = {"list", ""})
	public String list(@ModelAttribute("zNews") ZNews zNews, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZNews> page = zNewsService.findPage(new Page<ZNews>(request, response), zNews); 
		model.addAttribute("page", page);
		return "modules/znews/zNewsList";
	}

	@RequiresPermissions("znews:zNews:view")
	@RequestMapping(value = "form")
	public String form(ZNews zNews, Model model) {
		model.addAttribute("zNews", zNews);
		return "modules/znews/zNewsForm";
	}

	@RequiresPermissions("znews:zNews:edit")
	@RequestMapping(value = "save")
	public String save(ZNews zNews, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zNews)){
			return form(zNews, model);
		}
		zNewsService.save(zNews);
		addMessage(redirectAttributes, "保存新闻表成功");
		return "redirect:"+Global.getAdminPath()+"/znews/zNews/?repage";
	}
	
	@RequiresPermissions("znews:zNews:edit")
	@RequestMapping(value = "delete")
	public String delete(ZNews zNews, RedirectAttributes redirectAttributes) {
		zNewsService.delete(zNews);
		addMessage(redirectAttributes, "删除新闻表成功");
		return "redirect:"+Global.getAdminPath()+"/znews/zNews/?repage";
	}

}