package com.test.blog.service;

import com.test.blog.dao.IUserDAO;
import com.test.blog.dao.UserDAO;
import com.test.blog.dto.UserDTO;

public class UserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	public int createUser(UserDTO userDTO) {
		int resultRow = 0;
		if (userDTO.getUsername() == null) {
			System.out.println("아이디를 입력해주세요");
			return resultRow;
		}
		if (userDTO.getPassword().length() < 4) {
			System.out.println("비밀번호는 네글자 이상이어야합니다.");
			return resultRow;
		}
		userDTO.setUserRole("USER");
		resultRow = userDAO.create(userDTO);

		return resultRow;
	}

	public int updateUser(int id, UserDTO userDTO) {
		int resultRow = 0;
		if (userDTO.getPassword().length() < 4) {
			System.out.println("비밀번호는 네글자 이상이어야합니다.");
			return resultRow;
		}
		resultRow = userDAO.update(id, userDTO);

		return resultRow;
	}

	public UserDTO signIn(String username, String password) {
		UserDTO userDTO = null;
		if (username != null && password.length() >= 4) {
			userDTO = userDAO.checkByUsernameAndPassword(username, password);
		} else {
			System.out.println("올바른 양식이 아닙니다.");
		}

		return userDTO;
	}

} // end of class
