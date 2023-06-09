package com.tenco.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tenco.myblog.dto.UserDTO;
import com.tenco.myblog.utils.DBHelper;

public class UserDAO implements IUserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int create(UserDTO userDTO) {
		int resultRow = 0;
		String sql = " INSERT INTO user(username, password, email, address, userRole, createDate) VALUES\r\n"
				+ " (?, ?, ?, ?, ?, now()); ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sql);
			pstmt.setString(2, sql);
			pstmt.setString(3, sql);
			pstmt.setString(4, sql);
			pstmt.setString(5, sql);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				DBHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultRow;
	}

	@Override
	public int update(int id, UserDTO userDTO) {
		int resultRow = 0;
		String sql = " UPDATE board SET password = ?, email = ?, address = ? " + " WHERE id = ? ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDTO.getPassword());
			pstmt.setString(2, userDTO.getEmail());
			pstmt.setString(3, userDTO.getAddress());
			pstmt.setInt(4, id);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				DBHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultRow;
	}

	@Override
	public UserDTO checkByUsernameAndPassword(String username, String password) {
		UserDTO userDTO = null;
		String sql = " SELECT * FROM user " + " WHERE username = ? AND password = ? ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userDTO = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				DBHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userDTO;
	}

} // end of class
