package com.board.free.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;
import com.board.free.utils.DBHelper;

public class BlogDAO implements IBlogDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public ArrayList<BlogListDTO> selectAll(int offset) {
		ArrayList<BlogListDTO> list = new ArrayList<>();

		String query = " SELECT b.id, b.title, b.readCount, b.userId, u.username " + " FROM board AS b "
				+ " LEFT JOIN user AS u " + " ON b.userId = u.id " + " ORDER BY b.id desc" + " LIMIT 20 OFFSET ? ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, offset);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BlogListDTO blogListDTO = new BlogListDTO(rs.getInt("id"), rs.getString("title"),
						rs.getInt("readCount"), rs.getInt("userId"), rs.getString("username"));
				list.add(blogListDTO);
			}
		} catch (SQLException e) {
			System.out.println(">> BlogDAO select() error <<");
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
			System.out.println("dd");
			while (rs.next()) {
				blogDTO = new BlogDTO(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getInt("readCount"), rs.getInt("userId"));
			}
		} catch (SQLException e) {
			System.out.println(">> BlogDAO select(int id) error <<");
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
	public int write(BlogDTO blogDTO, int userId) {
		int resultRow = 0;

		String query = " INSERT INTO board(title, content, userId) VALUES " + "	(?, ?, ?) ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, blogDTO.getTitle());
			pstmt.setString(2, blogDTO.getContent());
			pstmt.setInt(3, userId);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(">> BlogDAO write() error <<");
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
	public int update(BlogDTO blogDTO, int id) {
		int resultRow = 0;

		String query = " UPDATE board SET title = ?, content = ? " + "WHERE id = ? ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, blogDTO.getTitle());
			pstmt.setString(2, blogDTO.getContent());
			pstmt.setInt(3, id);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(">> BlogDAO write() error <<");
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
	public int readCountUp(BlogDTO blogDTO) {
		int resultRow = 0;

		String query = " UPDATE board SET readCount = ? " + "WHERE id = ? ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, blogDTO.getReadCount() + 1);
			pstmt.setInt(2, blogDTO.getId());
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(">> BlogDAO write() error <<");
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
	public int rowCount() {
		int rowCount = 0;
		String query = " SELECT count(id) FROM board; ";
		conn = DBHelper.getInstance().getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rowCount = rs.getInt("count(id)");
			}
		} catch (SQLException e) {
			System.out.println(">> BlogDAO select() error <<");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				DBHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rowCount;
	}

} // end of class
