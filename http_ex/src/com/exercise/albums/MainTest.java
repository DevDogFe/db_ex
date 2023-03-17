package com.exercise.albums;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.exercise.albums.controller.AlbumController;
import com.exercise.albums.dto.AlbumDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest {

	// main
	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			StringBuffer sb = new StringBuffer();
			
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			Type type = new TypeToken<List<AlbumDTO>>(){}.getType();
			ArrayList<AlbumDTO> albums = new ArrayList<>();
			
			Gson gson = new Gson();
			albums = gson.fromJson(sb.toString(), type);
			
			AlbumController controller = new AlbumController();
			
			
			for (int i = 0; i < albums.size(); i++) {
				controller.requestInputDataByAlbumDTO(albums.get(i));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // end of main

} // end of class
