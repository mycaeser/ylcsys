package com.organization.ylcsys.entity;

import java.sql.Timestamp;

public class YouthOrg {
	//团组织表主键
	private Integer id;
	//团组织名称
	private String name;
	//用户编号
	private Integer userId;
	//用户名
	private String userNameString;
	//团组织简介
	private String content;
	//创建时间
	private Timestamp createTime;
	//最后修改时间
	private Timestamp lastEditTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserNameString() {
		return userNameString;
	}
	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Timestamp lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
