package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserInfoDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<UserInfoDTO> getUserInfo() throws SQLException {
		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
		String sql = "SELECT" + " id, login_id, login_pass, user_name, insert_date" + " FROM"
				+ " login_user_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				UserInfoDTO dto = new UserInfoDTO();
				dto.setUserNum(resultSet.getString("id"));
				dto.setUserId(resultSet.getString("login_id"));
				dto.setUserPass(resultSet.getString("login_pass"));
				dto.setUserName(resultSet.getString("user_name"));
				dto.setUserDate(resultSet.getString("insert_date"));
				userInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return userInfoDTO;
	}

	public boolean getUserInfoResult() throws SQLException{
		String sql = "SELECT" + " id, login_id, login_pass, user_name, insert_date" + " FROM"
				+ " login_user_transaction";

		PreparedStatement preparedStatement;
		boolean result = false;
		try{
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.execute();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}

	public ArrayList<UserInfoDTO> getUserInfoById(ArrayList<String> userNumList) throws SQLException {
		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
		String sql = "SELECT" + " id, login_id, login_pass, user_name, insert_date" + " FROM"
				+ " login_user_transaction" + " WHERE" + " id = ?";

		try {
			for (String userNum : userNumList) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, userNum);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					UserInfoDTO dto = new UserInfoDTO();
					dto.setUserNum(resultSet.getString("id"));
					dto.setUserId(resultSet.getString("login_id"));
					dto.setUserPass(resultSet.getString("login_pass"));
					dto.setUserName(resultSet.getString("user_name"));
					dto.setUserDate(resultSet.getString("insert_date"));
					userInfoDTO.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return userInfoDTO;
	}


	public String deleteUserAccount(ArrayList<String> userNumList) throws SQLException {
		String sql = "DELETE FROM login_user_transaction WHERE id = ?";

		int result = 0;
		String message = null;
		int res = 0;
		try {
			for (String deleteUserNum : userNumList) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, deleteUserNum);
				result = preparedStatement.executeUpdate();
				res++;
			}

			if (result == 1) {
				message = res + "件のアカウントを削除しました。";
			} else if (result == 0) {
				message = "アカウントの削除に失敗しました。";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return message;
	}
}