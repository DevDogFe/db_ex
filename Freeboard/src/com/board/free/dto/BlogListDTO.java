package com.board.free.dto;

public class BlogListDTO {

	private int id;
	private String title;
	private int readCount;
	private int userId;
	private String username;
	

	public BlogListDTO(int id, String title, int readCount, int userId, String username) {
		super();
		this.id = id;
		this.title = title;
		this.readCount = readCount;
		this.userId = userId;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String[] createArray() {
		String[] members = new String[4];
		
		members[0] = id + "";
		members[1] = title;
		members[2] = readCount + "";
		members[3] = username;
		
		
		return members;
	}

	@Override
	public String toString() {
		return "BlogListDTO [id=" + id + ", title=" + title + ", readCount=" + readCount + ", userId=" + userId
				+ ", username=" + username + "]";
	}

	
}
