package com.test.blog.controller;

import java.util.ArrayList;

import com.test.blog.dto.BlogDTO;
import com.test.blog.service.BlogService;

public class BlogController {
	
	private BlogService blogService;
	
	public BlogController() {
		blogService = new BlogService();
	}
	
	public ArrayList<BlogDTO> requestBoardAll(){
		ArrayList<BlogDTO> list = blogService.selectAll();
		
		return list;
	}
	
	public BlogDTO requestBoardContentById(int id) {
		BlogDTO blogDTO = null;
		blogDTO = blogService.selectByBoardId(id);
		
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
		
		return resultRow;
	}
	
	public int requestUpdateById(BlogDTO blogDTO, int id, int userId) {
		int resultRow = 0;
		resultRow = blogService.updateBoardById(blogDTO ,id, userId);
		
		return resultRow;
	}

} // end of class
