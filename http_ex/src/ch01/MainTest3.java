package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;


public class MainTest3 {

	// main
	public static void main(String[] args) {
		// 

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/19");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = null;
			StringBuffer sb = new StringBuffer();
			
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			Gson gson = new Gson();
			Post post19 = gson.fromJson(sb.toString(), Post.class);
			System.out.println(post19);
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
