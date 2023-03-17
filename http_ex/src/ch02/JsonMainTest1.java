package ch02;

import com.google.gson.JsonObject;

public class JsonMainTest1 {

	// main
	public static void main(String[] args) {

		// JSON 형식의 문자열을 만드는 방법
		// 1. 직접 형식을 지켜서 만든다.
		String myJson = "{\r\n"
				+ "	\"name\" : \"티모\",\r\n"
				+ "}";
		// 2. JSON Object: {} <--
		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("name", "티모");
		System.out.println(myJson);
		System.out.println(jsonObject1);
		
	} // end of main

} // end of class
