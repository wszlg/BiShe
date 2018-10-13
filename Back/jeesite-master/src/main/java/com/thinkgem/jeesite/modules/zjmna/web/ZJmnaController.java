/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zjmna.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.common.utils.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.zjmna.entity.ZJmna;
import com.thinkgem.jeesite.modules.zjmna.service.ZJmnaService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 经管表Controller
 * @author zlg
 * @version 2018-10-11
 */
@Controller
@RequestMapping(value = "${adminPath}/zjmna/zJmna")
public class ZJmnaController extends BaseController {

	@Autowired
	private ZJmnaService zJmnaService;
	
	@ModelAttribute
	public ZJmna get(@RequestParam(required=false) String id) {
		ZJmna entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zJmnaService.get(id);
		}
		if (entity == null){
			entity = new ZJmna();
		}
		return entity;
	}
	
	@RequiresPermissions("zjmna:zJmna:view")
	@RequestMapping(value = {"list", ""})
	public String list(@ModelAttribute("zJmna") ZJmna zJmna, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZJmna> page = zJmnaService.findPage(new Page<ZJmna>(request, response), zJmna); 
		model.addAttribute("page", page);
		return "modules/zjmna/zJmnaList";
	}

	@RequiresPermissions("zjmna:zJmna:view")
	@RequestMapping(value = "form")
	public String form(ZJmna zJmna, Model model) {
		model.addAttribute("zJmna", zJmna);
		return "modules/zjmna/zJmnaForm";
	}

	@RequiresPermissions("zjmna:zJmna:edit")
	@RequestMapping(value = "save")
	public String save(ZJmna zJmna, Model model, RedirectAttributes redirectAttributes, MultipartFile picfile, MultipartFile videofile, HttpServletRequest request) {
		if (!beanValidator(model, zJmna)){
			return form(zJmna, model);
		}
		zJmnaService.save(zJmna);


		String files = request.getSession().getServletContext().getRealPath("files");
		File file = new File(files);
		if (!file.exists()) {
//			file.getParentFile().mkdirs();
			file.mkdir();
		}

		String picextentsion = FileUtils.getFileExtension(picfile.getOriginalFilename());
		String videoextentsion = FileUtils.getFileExtension(videofile.getOriginalFilename());

		String picName = zJmna.getId() + "." + picextentsion;
		String videoName = zJmna.getId() + "." + videoextentsion;

		try {
			picfile.transferTo(new File(files, picName));
			videofile.transferTo(new File(files, videoName));
		} catch (IOException e) {
			e.printStackTrace();
		}



		zJmna.setPicurl("files/" + picName);
		zJmna.setVideourl("files/" + videoName);


		zJmnaService.save(zJmna);


		addMessage(redirectAttributes, "保存经管表成功");
		return "redirect:"+Global.getAdminPath()+"/zjmna/zJmna/?repage";
	}
	
	@RequiresPermissions("zjmna:zJmna:edit")
	@RequestMapping(value = "delete")
	public String delete(ZJmna zJmna, RedirectAttributes redirectAttributes) {
		zJmnaService.delete(zJmna);
		addMessage(redirectAttributes, "删除经管表成功");
		return "redirect:"+Global.getAdminPath()+"/zjmna/zJmna/?repage";
	}

}