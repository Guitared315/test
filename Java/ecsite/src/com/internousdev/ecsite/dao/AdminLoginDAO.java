package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.AdminLoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class AdminLoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private AdminLoginDTO adminLoginDTO= new AdminLoginDTO();

	public AdminLoginDTO getAdminLoginInfo(String adminId, String adminPassword){
		String sql = "SELECT * FROM admin_info where admin_id = ? AND admin_pass = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, adminId);
			preparedStatement.setString(2, adminPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				adminLoginDTO.setAdminId(resultSet.getString("admin_id"));
				adminLoginDTO.setAdminPassword(resultSet.getString("admin_pass"));
				adminLoginDTO.setAdminName(resultSet.getString("admin_name"));

				if (!resultSet.getString("admin_id").equals(null)){
					adminLoginDTO.setAdminLoginFlg(true);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return adminLoginDTO;
	}

	public AdminLoginDTO getAdminLoginDTO(){
		return adminLoginDTO;
	}
}
