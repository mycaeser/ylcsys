package com.organization.ylcsys.entity;

import java.sql.Timestamp;

public class PartyBranch {
	//党支部主键
	private Integer id;
	//党支部名称
	private String name;
	//党支部简介
	private String content;
	//创建时间
	private Timestamp createTime;
	//最后编辑时间
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
