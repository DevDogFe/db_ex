package com.board.free.dto;

public class UserDTO {

	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String userRole;
	private String createDate;
	
	

	
	public UserDTO(int id, String username, String email, String address, String userRole,
			String createDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.address = address;
		this.userRole = userRole;
		this.createDate = createDate;
	}
	
	public UserDTO(String username, String password, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public UserDTO(int id, String username, String password, String email, String address, String userRole,
			String createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.userRole = userRole;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

} // end of class
