package com.exercise.albums.service;

import com.exercise.albums.dao.AlbumDAO;
import com.exercise.albums.dto.AlbumDTO;

public class AlbumService {
	private AlbumDAO albumDAO;
	
	public AlbumService() {
		albumDAO = new AlbumDAO();
	}
	
	public int inputDataByAlbumDTO(AlbumDTO albumDTO) {
		int resultRow = -1;
		if(selectAlbumById(albumDTO.getId()) == null) {
			resultRow = albumDAO.inputData(albumDTO);
		}
		return resultRow;
	}
	
	public AlbumDTO selectAlbumById(int id) {
		AlbumDTO albumDTO = null;
		
		albumDTO = albumDAO.select(id);
		
		return albumDTO;
	}
}
