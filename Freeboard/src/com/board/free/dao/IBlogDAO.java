package com.board.free.dao;

import java.util.ArrayList;

import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;

public interface IBlogDAO {

	ArrayList<BlogListDTO> selectAll(int offset);
	BlogDTO select(int id);
	int delete(int id);
	int write(BlogDTO blogDTO, int userId);
	int update(BlogDTO blogDTO, int id);
	int readCountUp(BlogDTO blogDTO);
	int rowCount();
}
