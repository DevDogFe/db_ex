package com.tenco.myblog.service;

import java.util.ArrayList;

import com.tenco.myblog.dao.BlogDAO;
import com.tenco.myblog.dao.IBlogDAO;
import com.tenco.myblog.dto.BlogDTO;

public class BlogService {

	private IBlogDAO blogDAO;

	public BlogService() {
		blogDAO = new BlogDAO();
	}

	public ArrayList<BlogDTO> selectAll() {

		ArrayList<BlogDTO> list = blogDAO.select();

		return list;
	}

	public BlogDTO selectByBoardId(int id) {
		BlogDTO blogDTO = null;

		blogDTO = blogDAO.select(id);

		return blogDTO;
	}

	public int deleteBoardByID(int id, int userId) {
		int resultRow = 0;
		BlogDTO blogDTO = selectByBoardId(id);
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
		if (userId == selectByBoardId(id).getUserId()) {
			resultRow = blogDAO.update(blogDTO, id);
		} else {
			System.out.println("수정 권한이 없습니다.");
		}
		return resultRow;

	}

} // end of class
