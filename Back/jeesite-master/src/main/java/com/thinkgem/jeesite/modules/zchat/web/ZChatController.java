/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zchat.web;

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
import com.thinkgem.jeesite.modules.zchat.entity.ZChat;
import com.thinkgem.jeesite.modules.zchat.service.ZChatService;

/**
 * 话题表Controller
 * @author zlg
 * @version 2018-10-23
 */
@Controller
@RequestMapping(value = "${adminPath}/zchat/zChat")
public class ZChatController extends BaseController {

	@Autowired
	private ZChatService zChatService;
	
	@ModelAttribute
	public ZChat get(@RequestParam(required=false) String id) {
		ZChat entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zChatService.get(id);
		}
		if (entity == null){
			entity = new ZChat();
		}
		return entity;
	}
	
	@RequiresPermissions("zchat:zChat:view")
	@RequestMapping(value = {"list", ""})
	public String list(@ModelAttribute("zChat") ZChat zChat, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZChat> page = zChatService.findPage(new Page<ZChat>(request, response), zChat); 
		model.addAttribute("page", page);
		return "modules/zchat/zChatList";
	}

	@RequiresPermissions("zchat:zChat:view")
	@RequestMapping(value = "form")
	public String form(ZChat zChat, Model model) {
		model.addAttribute("zChat", zChat);
		return "modules/zchat/zChatForm";
	}

	@RequiresPermissions("zchat:zChat:edit")
	@RequestMapping(value = "save")
	public String save(ZChat zChat, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zChat)){
			return form(zChat, model);
		}
		zChatService.save(zChat);
		addMessage(redirectAttributes, "保存话题表成功");
		return "redirect:"+Global.getAdminPath()+"/zchat/zChat/?repage";
	}
	
	@RequiresPermissions("zchat:zChat:edit")
	@RequestMapping(value = "delete")
	public String delete(ZChat zChat, RedirectAttributes redirectAttributes) {
		zChatService.delete(zChat);
		addMessage(redirectAttributes, "删除话题表成功");
		return "redirect:"+Global.getAdminPath()+"/zchat/zChat/?repage";
	}

}