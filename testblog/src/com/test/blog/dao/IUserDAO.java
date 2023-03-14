package com.test.blog.dao;

import com.test.blog.dto.UserDTO;

public interface IUserDAO {

	int create(UserDTO userDTO);

	int update(int id, UserDTO userDTO);

	UserDTO checkByUsernameAndPassword(String username, String password);

}
