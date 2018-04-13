package com.internousdev.ecsite.dto;

public class AdminLoginDTO {

	private String adminId;
	private String adminPassword;
	private String adminName;
	private boolean adminLoginFlg = false;

	public String getAdminId(){
		return adminId;
	}

	public void setAdminId(String adminId){
		this.adminId = adminId;
	}

	public String getAdminPassword(){
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword){
		this.adminPassword= adminPassword;
	}

	public String getAdminName(){
		return adminName;
	}

	public void setAdminName(String adminName){
		this.adminName = adminName;
	}

	public boolean getAdminLoginFlg(){
		return adminLoginFlg;
	}

	public void setAdminLoginFlg(boolean adminLoginFlg){
		this.adminLoginFlg = adminLoginFlg;
	}
}
