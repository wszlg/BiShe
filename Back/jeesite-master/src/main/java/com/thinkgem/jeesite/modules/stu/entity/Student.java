/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.stu.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生测试Entity
 * @author zlg
 * @version 2018-01-29
 */
public class Student extends DataEntity<Student> {
	
	private static final long serialVersionUID = 1L;
	private String sex;		// 性别
	private String name;		// 名字
	private String age;		// 年龄
	
	public Student() {
		super();
	}

	public Student(String id){
		super(id);
	}

	@Length(min=0, max=11, message="性别长度必须介于 0 和 11 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=255, message="名字长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="年龄长度必须介于 0 和 11 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}