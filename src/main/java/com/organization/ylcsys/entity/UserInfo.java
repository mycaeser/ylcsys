package com.organization.ylcsys.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class UserInfo {
	//用户信息主键
	private Integer id;
	//姓名
	private String name;
	//性别
	private Integer gender;
	//身份证
	private String idCard;
	//手机号
	private String phone;
	//学院名称
	private String unionName;
	//班级名称
	private String className;
	//权限
	private Integer priority;
	//入团时间
	private Date youthOrgTime;
	//申请入党时间
	private Date applyPartyTime;
	//确认入党时间
	private Date admitPartyTime;
	//党支部编号
	private Integer partyBranchId;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUnionName() {
		return unionName;
	}
	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getYouthOrgTime() {
		return youthOrgTime;
	}
	public void setYouthOrgTime(Date youthOrgTime) {
		this.youthOrgTime = youthOrgTime;
	}
	public Date getApplyPartyTime() {
		return applyPartyTime;
	}
	public void setApplyPartyTime(Date applyPartyTime) {
		this.applyPartyTime = applyPartyTime;
	}
	public Date getAdmitPartyTime() {
		return admitPartyTime;
	}
	public void setAdmitPartyTime(Date admitPartyTime) {
		this.admitPartyTime = admitPartyTime;
	}
	public Integer getPartyBranchId() {
		return partyBranchId;
	}
	public void setPartyBranchId(Integer partyBranchId) {
		this.partyBranchId = partyBranchId;
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
