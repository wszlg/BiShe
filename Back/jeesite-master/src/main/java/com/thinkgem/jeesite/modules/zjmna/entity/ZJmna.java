/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zjmna.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 经管表Entity
 * @author zlg
 * @version 2018-10-11
 */
public class ZJmna extends DataEntity<ZJmna> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 视频描述
	private String picurl;		// 图片地址
	private String videourl;		// 视频地址
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ZJmna() {
		super();
	}

	public ZJmna(String id){
		super(id);
	}

	@Length(min=0, max=255, message="视频描述长度必须介于 0 和 255 之间")
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
	
	@Length(min=0, max=255, message="视频地址长度必须介于 0 和 255 之间")
	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	
}