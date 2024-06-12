package com.ycyl.edu.bean;

import java.util.List;

import lombok.Data;

@SuppressWarnings("all")
@Data
public class SessionInfo implements java.io.Serializable {

	private Long id;// 用户ID
	private String loginName;// 登录名
	private String name;// 姓名
	private String ip;// 用户IP
	
	private String dwmc;
	private String ksmc;
	
	private String simManager;// A-系统管理员 B-安全保密管理员 C-安全审计人员
	private String role;// role1-新建 role2-修改 role3-删除

	private List<String> resourceList;// 用户可以访问的资源地址列表
	
	private List<String> resourceAllList;
	
	public List<String> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getResourceAllList() {
		return resourceAllList;
	}

	public void setResourceAllList(List<String> resourceAllList) {
		this.resourceAllList = resourceAllList;
	}
	
	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
