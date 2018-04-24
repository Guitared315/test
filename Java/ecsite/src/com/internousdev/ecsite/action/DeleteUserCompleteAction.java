package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUserCompleteAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private String userNum;
	private ArrayList<String> userNumList = new ArrayList<String>();
	private String message;

	public int res;

	public String execute() throws SQLException {
		String result = ERROR;
		if (userNumList != null) {
			message = userInfoDAO.deleteUserAccount(userNumList);
			result = SUCCESS;
		} else if (userNumList == null) {
			result = ERROR;
		}

		return result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public ArrayList<String> getUserNumList() {
		return userNumList;
	}

	public void setUserNumList(ArrayList<String> userNumList) {
		this.userNumList = userNumList;
	}
}