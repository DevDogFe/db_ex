package ch02;

import com.google.gson.JsonObject;

public class JsonMainTest2 {

	// main
	public static void main(String[] args) {

		JsonObject jo1 = new JsonObject();
		jo1.addProperty("이름", "홍길동");
		jo1.addProperty("나이", 25);
		jo1.addProperty("직업", "CEO");
		jo1.addProperty("취미", "노래");
		jo1.addProperty("결혼여부", false);
		
		// json 문자열 확인
		System.out.println(jo1);
		
		// jasonobject에서 값 꺼내는 방법
		System.out.println(jo1.get("취미"));
		System.out.println(jo1.get("이름"));
		System.out.println(jo1.get("나이"));
		System.out.println(jo1.get("직업"));
		System.out.println(jo1.get("결혼여부"));
		
		JsonObject jo2 = new JsonObject();
		jo2.addProperty("userId", 1);
		jo2.addProperty("id", 2);
		jo2.addProperty("title", "quis ut nam facilis et officia qui");
		jo2.addProperty("completed", false);
		
		System.out.println(jo2);
		
		
	} // end of main

} // end of class
