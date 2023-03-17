package com.board.free.dao;

import com.board.free.dto.UserDTO;

public interface IUserDAO {
	
	int create(UserDTO userDTO);
	int update(int id, UserDTO userDTO);
	UserDTO checkByUsernameAndPassword(String username, String password);
	UserDTO searchUserById(int id);
	
}
