package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest1 {

	// main
	public static void main(String[] args) {

		// Client -> Web Server -> DB
		// Client <- Web Server <- DB
		// 기본 자바 표준기술인 http 클래스를 이용하여 http 통신을 통해서
		// 데이터를 요청하고 응답받아보는 기술 확인

//		https://jsonplaceholder.typicode.com/todos

		// http 통신 준비물: URL 클래스, httpURLConnection 클래스
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");

			// 다운캐스팅
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int statusCode = conn.getResponseCode();
			System.out.println(statusCode);

			// conn.getInputStream(); // byte 단위로 데이터를 읽음
			// new InputStreamReader(conn.getInputStream()); input stream을 읽는 inputreader
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			StringBuffer sb = new StringBuffer();
			String line = null;

			Todo todo = new Todo();

//			todo.setId(statusCode);
//			todo.setUserId(statusCode);
//			todo.setTitle();
//			todo.setCompleted();
			int count = 0;

			while ((line = reader.readLine()) != null) {
				if (line.contains(":")) {
					if (line.contains(",")) {
						line = line.substring(line.indexOf(":") + 2, line.indexOf(","));
					} else {
						line = line.substring(line.indexOf(":") + 2);
					}
				}
				if (count % 6 == 1) {
					todo.setId(Integer.parseInt(line));
				}
				if (count % 6 == 2) {
					todo.setUserId(Integer.parseInt(line));
				}
				if (count % 6 == 3) {
					todo.setTitle(line);
				}
				if (count % 6 == 4) {
					todo.setCompleted(Boolean.valueOf(line));
				}

				count++;
			}

			// Stringbuffer -> String .toString()

			System.out.println(todo.getId());
			System.out.println(todo.getUserId());
			System.out.println(todo.getTitle());
			System.out.println(todo.isCompleted());

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
