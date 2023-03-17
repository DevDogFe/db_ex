package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;


public class MainTest2 {

	// main
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/20");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// http 요청: 1) GET  2) POST
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
			// 200: 통신 성공, 404: 요청URL 없음
			// System.out.println("statusCode: " + statusCode);
			if(statusCode == 200) {
				// (new (new ()))  데코레이션 페턴
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				StringBuffer sb = new StringBuffer();
				while((line = reader.readLine()) != null) {
					sb.append(line);
				}
				// System.out.println(sb.toString());
				
				// JSON parsing(문자열 -> Java Object)
				Gson gson = new Gson();
				Todo todo10 = gson.fromJson(sb.toString(), Todo.class); // 리플렉스 기법
				System.out.println("userId: " + todo10.getUserId());
				System.out.println("id: " + todo10.getId());
				System.out.println("title: " + todo10.getTitle());
				System.out.println("completed: " + todo10.isCompleted());
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
