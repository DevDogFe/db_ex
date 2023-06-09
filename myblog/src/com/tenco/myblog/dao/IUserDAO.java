package com.tenco.myblog.dao;

import com.tenco.myblog.dto.UserDTO;

public interface IUserDAO {
	
	int create(UserDTO userDTO);
	int update(int id, UserDTO userDTO);
	UserDTO checkByUsernameAndPassword(String username, String password);
	
}
