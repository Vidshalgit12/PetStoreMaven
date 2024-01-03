package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;

//User end point .jav
//created for Maven Crud ops APi's
public class UserEndPoints {
	public static Response CreateUser(User payload) 
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		return response;
	}

	public static Response readUser(String UserName) 
	{
		Response response=given()
			.pathParam("username", UserName)
		.when()
			.get(Routes.get_url);
		return response;
	}

	public static Response updateUser(String userName,User payload) 
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(Routes.put_url);
		return response;
	}
	
	public static Response deleteUser(String UserName) 
	{
		Response response=given()
			.pathParam("username", UserName)
		.when()
			.delete(Routes.delete_url);
		return response;
	}


}
