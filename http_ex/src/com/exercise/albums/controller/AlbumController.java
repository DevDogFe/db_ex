package com.exercise.albums.controller;

import com.exercise.albums.dto.AlbumDTO;
import com.exercise.albums.service.AlbumService;

public class AlbumController {
	
	private AlbumService albumService;
	
	public AlbumController() {
		albumService = new AlbumService();
	}
	
	public int requestInputDataByAlbumDTO(AlbumDTO albumDTO) {
		int resultRow = -1;
		
		resultRow = albumService.inputDataByAlbumDTO(albumDTO);
		
		return resultRow;
	}
	
	public AlbumDTO requestAlbumById(int id) {
		AlbumDTO albumDTO = null;
		
		albumDTO = albumService.selectAlbumById(id);
		
		return albumDTO;
	}
}
