package com.board.free.service;

import java.util.ArrayList;

import com.board.free.dao.BlogDAO;
import com.board.free.dao.IBlogDAO;
import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;

public class BlogService {

	private IBlogDAO blogDAO;

	public BlogService() {
		blogDAO = new BlogDAO();
	}

	public ArrayList<BlogListDTO> selectAll(int offset) {

		ArrayList<BlogListDTO> list = blogDAO.selectAll(offset);

		return list;
	}
	
	public ArrayList<BlogListDTO> selectByUserId(int userId, int offset) {
		
		ArrayList<BlogListDTO> list = blogDAO.selectByUser(userId, offset);
		
		return list;
	}

	public BlogDTO selectByBoardId(int id, int userId) {
		BlogDTO blogDTO = null;
		blogDTO = blogDAO.select(id);
		if(blogDTO.getUserId() != userId) {
			blogDAO.readCountUp(blogDTO);
			
		}
		

		return blogDTO;
	}

	public int deleteBoardByID(int id, int userId) {
		int resultRow = 0;
		BlogDTO blogDTO = selectByBoardId(id, userId);
		if (blogDTO == null) {
			System.out.println("조회할 수 없는 게시글입니다.");
			return resultRow;
		}
		if (blogDTO.getUserId() == userId) {
			resultRow = blogDAO.delete(id);
		} else {
			System.out.println("삭제 권한이 없습니다.");
		}
		return resultRow;
	}

	public int writeBoardByUserId(BlogDTO blogDTO, int userId) {
		int resultRow = 0;
		if (blogDTO.getTitle() == null) {
			System.out.println("제목을 입력해주세요.");
			return resultRow;
		}
		resultRow = blogDAO.write(blogDTO, userId);
		return resultRow;

	}

	public int updateBoardById(BlogDTO blogDTO, int id, int userId) {
		int resultRow = 0;
		if (blogDTO.getTitle() == null) {
			System.out.println("수정할 글의 제목을 입력해주세요.");
			return resultRow;
		}
		if (userId == selectByBoardId(id, userId).getUserId()) {
			resultRow = blogDAO.update(blogDTO, id);
		} else {
			System.out.println("수정 권한이 없습니다.");
		}
		return resultRow;

	}

} // end of class
