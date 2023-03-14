package com.test.blog.controller;

import com.test.blog.dto.UserDTO;
import com.test.blog.service.UserService;

public class UserController {
	
	private UserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	public int requestCreateUser(UserDTO userDTO) {
		int resultRow = userService.createUser(userDTO);
		
		return resultRow;
	}
	
	public int requestUpdateUser(int id, UserDTO userDTO) {
		int resultRow = userService.updateUser(id, userDTO);
		
		return resultRow;
	}
	
	public UserDTO requestSignIn(String username, String password) {
		UserDTO userDTO = null;
		userDTO = userService.signIn(username, password);
		if(userDTO == null) {
			System.out.println("로그인에 실패하였습니다. 아이디와 비밀번호를 확인해주세요.");
		}
		
		return userDTO;
	}

} // end of class
