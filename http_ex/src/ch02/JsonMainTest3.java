package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonMainTest3 {

	// main
	public static void main(String[] args) {
		
		JsonArray array = new JsonArray();
		
		
		JsonObject jo1 = new JsonObject();
		jo1.addProperty("userId", 1);
		jo1.addProperty("id", 1);
		jo1.addProperty("title", "delectus aut autem");
		jo1.addProperty("completed", false);
		JsonObject jo2 = new JsonObject();
		jo2.addProperty("userId", 1);
		jo2.addProperty("id", 2);
		jo2.addProperty("title", "quis ut nam facilis et officia qui");
		jo2.addProperty("completed", false);
		JsonObject jo3 = new JsonObject();
		jo3.addProperty("userId", 1);
		jo3.addProperty("id", 3);
		jo3.addProperty("title", "fugiat veniam minus");
		jo3.addProperty("completed", false);
		System.out.println(array);
		System.out.println("-----------------");
		System.out.println(jo1);
		array.add(jo1);
		array.add(jo2);
		array.add(jo3);
		System.out.println("-----------------");
		System.out.println(array);
		
		JsonObject to = array.get(1).getAsJsonObject();
		System.out.println(to);
		String strName = to.get("title").getAsString();
		System.out.println(strName);
		
		
		
	} // end of main

} // end of class
