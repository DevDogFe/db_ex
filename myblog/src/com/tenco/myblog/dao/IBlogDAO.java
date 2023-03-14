package com.tenco.myblog.dao;

import java.util.ArrayList;

import com.tenco.myblog.dto.BlogDTO;

public interface IBlogDAO {

	ArrayList<BlogDTO> select();
	BlogDTO select(int id);
	int delete(int id);
	int write(BlogDTO blogDTO);
	
	
}
