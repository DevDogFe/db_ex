package com.exercise.albums.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exercise.albums.dto.AlbumDTO;
import com.exercise.albums.utils.DBHelper;

public class AlbumDAO implements IAlbumDAO {
	
	private DBHelper helper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AlbumDAO() {
		helper = DBHelper.getInstance();
	}
	
	@Override
	public int inputData(AlbumDTO albumDTO) {
		int resultRow = -1;
		String sql = " INSERT INTO albums VALUES "
				+ " (?, ?, ?) ";
		conn = helper.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumDTO.getUserId());
			pstmt.setInt(2, albumDTO.getId());
			pstmt.setString(3, albumDTO.getTitle());
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(">> inputData() error <<");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				helper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultRow;
	}
	
	@Override
	public AlbumDTO select(int id) {
		AlbumDTO albumDTO = null;
		String sql = " SELECT * FROM albums "
				+ " WHERE id = ? ";
		conn = helper.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				albumDTO = new AlbumDTO(rs.getInt("userId"), rs.getInt("id"), rs.getString("title"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return albumDTO;
	}

}
