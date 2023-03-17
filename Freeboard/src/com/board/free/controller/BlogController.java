package com.board.free.controller;

import java.util.ArrayList;

import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;
import com.board.free.service.BlogService;

public class BlogController {
	
	private BlogService blogService;
	
	public BlogController() {
		blogService = new BlogService();
	}
	
	public ArrayList<BlogListDTO> requestBoardAll(){
		ArrayList<BlogListDTO> list = blogService.selectAll();
		
		return list;
	}
	
	public BlogDTO requestBoardContentById(int id, int userId) {
		BlogDTO blogDTO = null;
		blogDTO = blogService.selectByBoardId(id, userId);
		
		return blogDTO;
	}
	
	public int requestDeleteBoardById(int id, int userId) {
		int resultRow = 0;
		resultRow = blogService.deleteBoardByID(id, userId);
		
		return resultRow;
	}
	
	public int requestWriteBoardByUserId(BlogDTO blogDTO, int userId) {
		int resultRow = 0;
		resultRow = blogService.writeBoardByUserId(blogDTO, userId);
		System.out.println("리퀘스트 성공");
		
		return resultRow;
	}
	
	public int requestUpdateById(BlogDTO blogDTO, int id, int userId) {
		int resultRow = 0;
		resultRow = blogService.updateBoardById(blogDTO ,id, userId);
		
		return resultRow;
	}

} // end of class
