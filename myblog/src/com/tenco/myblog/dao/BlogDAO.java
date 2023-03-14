package com.tenco.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tenco.myblog.dto.BlogDTO;
import com.tenco.myblog.utils.DBHelper;

public class BlogDAO implements IBlogDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public ArrayList<BlogDTO> select() {
		ArrayList<BlogDTO> list = null;

		String query = " SELECT * FROM board ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BlogDTO blogDTO = new BlogDTO(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getInt("readCount"), rs.getInt("userId"));
				list.add(blogDTO);
			}
		} catch (SQLException e) {
			System.out.println(">> BlogDAO select() error <<");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					DBHelper.closeConnection();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public BlogDTO select(int id) {
		BlogDTO blogDTO = null;
		String query = " SELECT * FROM board " + " WHERE id = ?; ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				blogDTO = new BlogDTO(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getInt("readCount"), rs.getInt("userId"));
			}
		} catch (SQLException e) {
			System.out.println(">> BlogDAO select(int id) error <<");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					DBHelper.closeConnection();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return blogDTO;
	}

	@Override
	public int delete(int id) {
		int resultRow = 0;

		String query = " DELETE FROM board " + " WHERE id = ? ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(">> BlogDAO delete() error <<");
			e.printStackTrace();
		}  finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					DBHelper.closeConnection();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultRow;
	}

	@Override
	public int write(BlogDTO blogDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

} // end of class
