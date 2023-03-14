package com.tenco.myblog.service;

import com.tenco.myblog.dao.UserDAO;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	

} // end of class
