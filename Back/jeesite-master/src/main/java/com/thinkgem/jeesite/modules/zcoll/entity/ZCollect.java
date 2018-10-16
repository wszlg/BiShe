/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zcoll.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 收藏表Entity
 * @author zlg
 * @version 2018-10-16
 */
public class ZCollect extends DataEntity<ZCollect> {
	
	private static final long serialVersionUID = 1L;
	private String userid;		// 用户id
	private String type;		// 类型
	private String newsId;		// 新闻id
	
	public ZCollect() {
		super();
	}

	public ZCollect(String id){
		super(id);
	}

	@Length(min=0, max=64, message="用户id长度必须介于 0 和 64 之间")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=1, message="类型长度必须介于 0 和 1 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=64, message="新闻id长度必须介于 0 和 64 之间")
	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	
}