package com.board.free.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.free.dto.UserDTO;
import com.board.free.utils.DBHelper;

public class UserDAO implements IUserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int create(UserDTO userDTO) {
		int resultRow = 0;
		String sql = " INSERT INTO user(username, password, email, address, userRole, createDate) VALUES "
				+ " (?, ?, ?, ?, ?, now()); ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDTO.getUsername());
			pstmt.setString(2, userDTO.getPassword());
			pstmt.setString(3, userDTO.getEmail());
			pstmt.setString(4, userDTO.getAddress());
			pstmt.setString(5, userDTO.getUserRole());
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원가입 실패");
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
		System.out.println("회원가입에 성공하였습니다.");
		return resultRow;
	}

	@Override
	public int update(int id, UserDTO userDTO) {
		int resultRow = 0;
		String sql = " UPDATE user SET password = ?, email = ?, address = ? " + " WHERE id = ? ";
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
				userDTO = new UserDTO(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("address"), rs.getString("userRole"),
						rs.getString("createDate"));
				System.out.println(rs.getInt("id"));
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

	
	@Override
	public UserDTO searchUserById(int id) {
		UserDTO userDTO = null;
		String sql = " SELECT * FROM user " + " WHERE id = ? ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userDTO = new UserDTO(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("address"), rs.getString("userRole"), rs.getString("createDate"));
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
