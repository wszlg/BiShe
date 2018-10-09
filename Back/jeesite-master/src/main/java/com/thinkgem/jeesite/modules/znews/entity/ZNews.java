/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znews.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 新闻表Entity
 * @author zlg
 * @version 2018-10-09
 */
public class ZNews extends DataEntity<ZNews> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 新闻标题
	private String picurl;		// 图片地址
	private String content;		// 新闻详情
	
	public ZNews() {
		super();
	}

	public ZNews(String id){
		super(id);
	}

	@Length(min=0, max=255, message="新闻标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="图片地址长度必须介于 0 和 255 之间")
	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	
	@Length(min=0, max=255, message="新闻详情长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}