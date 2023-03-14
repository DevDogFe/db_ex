package com.tenco.myblog;

import java.util.ArrayList;

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
//		
//		int a = blogController.requestDeleteBoardByID(3, 3);
//		System.out.println(a);
		// int a = blogController.requestWriteBoardByUserId(new BlogDTO("한산도 지리의 전략적 고찰", "거북선과 학익진이 함께라면 난 어디든 갈 수 있어"), 2);
		// System.out.println(a);
		blogController.requestUpdateById(new BlogDTO("거북선", "나는거북선 다른배들 통통"), 6, 2);
		ArrayList<BlogDTO> list = blogController.requestBoardAll();
		for (BlogDTO blogDTO : list) {
			System.out.println(blogDTO);
		}
		
		
	} // end of main

} // end of class
