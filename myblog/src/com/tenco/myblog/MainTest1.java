package com.tenco.myblog;

import com.tenco.myblog.controller.BlogController;
import com.tenco.myblog.dto.BlogDTO;
import com.tenco.myblog.utils.DBHelper;

public class MainTest1 {

	// main
	public static void main(String[] args) {
		
		// 코드 테스트
//		DBHelper dbHelper = DBHelper.getInstance();
//		dbHelper.getConnection();
//		System.out.println(dbHelper);
		
		//코드 테스트
		BlogController blogController = new BlogController();
//		BlogDTO blogDTO = blogController.requestBoardContentById(30);
//		System.out.println(blogDTO);
		
		int a = blogController.requestDeleteBoardByID(3, 3);
		System.out.println(a);
		
		
	} // end of main

} // end of class
