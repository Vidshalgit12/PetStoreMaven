package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;

//User end point .jav
//created for Maven Crud ops APi's
public class UserEndPoints2 {
	//created for getting URL's
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response CreateUser(User payload) 
	{
		String post_url=getURL().getString("post_url");
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		return response;
	}

	public static Response readUser(String UserName) 
	{
		String get_url=getURL().getString("get_url");
		
		Response response=given()
			.pathParam("username", UserName)
		.when()
			.get(get_url);
		return response;
	}

	public static Response updateUser(String userName,User payload) 
	{
		String put_url=getURL().getString("put_url");
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(put_url);
		return response;
	}
	
	public static Response deleteUser(String UserName) 
	{
		String delete_url=getURL().getString("delete_url");
		
		Response response=given()
			.pathParam("username", UserName)
		.when()
			.delete(delete_url);
		return response;
	}


}
