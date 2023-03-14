package com.test.blog.dao;

import java.util.ArrayList;

import com.test.blog.dto.BlogDTO;

public interface IBlogDAO {

	ArrayList<BlogDTO> select();

	BlogDTO select(int id);

	int delete(int id);

	int write(BlogDTO blogDTO, int userId);

	int update(BlogDTO blogDTO, int id);

}
