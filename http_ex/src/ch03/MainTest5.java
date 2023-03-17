package ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest5 {

	// main
	public static void main(String[] args) {

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/users");
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
			String result = sb.toString();
			// System.out.println(result);
			Gson gson = new Gson();
			
			Type listType = new TypeToken<List<User>>(){}.getType();
			ArrayList<User> userList = gson.fromJson(result, listType);
			
			for (User user : userList) {
				System.out.println(user);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} // end of main

} // end of class
