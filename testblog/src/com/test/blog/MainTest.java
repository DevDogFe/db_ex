package com.test.blog;

import com.test.blog.controller.UserController;
import com.test.blog.dto.UserDTO;

public class MainTest {

	public static void main(String[] args) {
		UserController controller = new UserController();
		
		// 회원가입
		int resultRow = controller.requestCreateUser(new UserDTO("가가가", "1111", "aaa@test.com", "세종시"));
		System.out.println(resultRow);
		System.out.println("=====================================");
		resultRow = controller.requestCreateUser(new UserDTO("나나나", "22", "bbb@test.com", "세종시"));
		System.out.println(resultRow);
		System.out.println("=====================================");
		
		// 로그인
		UserDTO userDTO = controller.requestSignIn("가가가", "1112");
		System.out.println(userDTO);
		System.out.println("=====================================");
		userDTO = controller.requestSignIn("가나다", "111");
		System.out.println(userDTO);
		System.out.println("=====================================");
		userDTO = controller.requestSignIn("가가가", "1111");
		System.out.println(userDTO);
		System.out.println("=====================================");
		
		// 회원정보 수정
		resultRow = controller.requestUpdateUser(userDTO.getId(), new UserDTO("2222", "abc@test2.com", "서울시"));
		System.out.println(resultRow);
	} // end of main

}
