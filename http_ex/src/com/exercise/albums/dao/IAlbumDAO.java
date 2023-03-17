package com.exercise.albums.dao;

import com.exercise.albums.dto.AlbumDTO;

public interface IAlbumDAO {
	
	int inputData(AlbumDTO albumDTO);
	
	AlbumDTO select(int id);

}
