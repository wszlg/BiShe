/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zuser.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户表Entity
 * @author zlg
 * @version 2018-10-09
 */
public class ZUser extends DataEntity<ZUser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String age;		// age
	private String sex;		// sex
	private String password;		// password
	
	public ZUser() {
		super();
	}

	public ZUser(String id){
		super(id);
	}

	@Length(min=0, max=255, message="name长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="age长度必须介于 0 和 11 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=1, message="sex长度必须介于 0 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=255, message="password长度必须介于 1 和 255 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}