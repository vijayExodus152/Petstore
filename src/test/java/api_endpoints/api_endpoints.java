package api_endpoints;
import org.testng.annotations.Test;

import api_payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//userEndpoints.java
//Created to perform Create, read, update, delete requests for user_API

public class api_endpoints {
	
	public static Response createUser(User payload){
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(routes.post_url);
		return response;
	}
	public static Response readUser(String userName){
		Response response=
		given().pathParam("username", userName)
		.when()
		.get(routes.get_url);
		return response;
	}
	public static Response updateUser(String userName, User payload){
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username",userName)
		.body(payload)
		.when()
		.put(routes.put_url);
		return response;
	}
	public static Response deleteUser(String userName){
		Response response =given()
		.pathParam("username",userName)
		.when()
		.delete(routes.delete_url);
		return response;
	}
}
