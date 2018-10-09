/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mtea.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 班主任测试Entity
 * @author zlg
 * @version 2018-02-09
 */
public class Hteacher extends DataEntity<Hteacher> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String age;		// 年龄
	
	public Hteacher() {
		super();
	}

	public Hteacher(String id){
		super(id);
	}

	@Length(min=0, max=10, message="姓名长度必须介于 0 和 10 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=5, message="年龄长度必须介于 0 和 5 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}