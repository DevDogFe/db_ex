package com.tenco.myblog.controller;

import java.util.ArrayList;

import com.tenco.myblog.dto.BlogDTO;
import com.tenco.myblog.service.BlogService;

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
	
	public int requestDeleteBoardByID(int id, int userId) {
		int resultRow = 0;
		resultRow = blogService.DeleteBoardByID(id, userId);
		
		return resultRow;
	}

} // end of class
