package com.test.blog.dto;

public class UserDTO {

	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String userRole;
	private String createDate;
	
	// 회원정보 수정 용도
	public UserDTO(String password, String email, String address) {
		this.password = password;
		this.email = email;
		this.address = address;
	}
	// 회원가입 용도
	public UserDTO(String username, String password, String email, String address) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	// 로그인하면서 정보 담는 용도
	public UserDTO(int id, String username, String password, String email, String address, String userRole,
			String createDate) {
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

	@Override
	public String toString() {
		return "UserDTO [아이디: " + username + ", email: " + email + ", 주소: " + address + ", 가입일: "
				+ createDate + "]";
	}
	
	

} // end of class
