package ch02;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonMainTest4 {

	// main
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		JsonArray ja1 = new JsonArray();
		JsonObject jo1 = new JsonObject();
		JsonObject jo2 = new JsonObject();
		JsonObject jo3 = new JsonObject();
		
		jo1.addProperty("name", "홍길동");
		jo1.addProperty("age", 20);
		jo1.addProperty("address", "부산");
		jo2.addProperty("name", "이순신");
		jo2.addProperty("age", 33);
		jo2.addProperty("address", "서울");
		jo3.addProperty("name", "세종대왕");
		jo3.addProperty("age", 59);
		jo3.addProperty("address", "세종시");
		ja1.add(jo1);
		ja1.add(jo2);
		ja1.add(jo3);
		
		JsonObject ts  = new JsonObject();
		JsonArray todo = new JsonArray();
		JsonObject todo1 = new JsonObject();
		JsonObject todo2 = new JsonObject();
		todo1.addProperty("id", 1);
		todo1.addProperty("title", "청소");
		todo1.addProperty("complete", false);
		todo2.addProperty("id", 2);
		todo2.addProperty("title", "영어공부");
		todo2.addProperty("complete", true);
		todo.add(todo1);
		todo.add(todo2);
		ts.addProperty("todoList", todo.toString());
		ts.addProperty("server_name", "server_1");
		
		System.out.println(ja1);
		System.out.println("========================");
		System.out.println(ts);
		
	} // end of main

} // end of class
