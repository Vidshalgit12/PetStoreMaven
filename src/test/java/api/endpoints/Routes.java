package api.endpoints;

/*
Step1 in creation
Swagger Url --> https://petstore.swagger.io

Create User	Post	https://petstore.swagger.io/v2/user
Get User	Get	https://petstore.swagger.io/v2/user/{username}
Update User	Put	https://petstore.swagger.io/v2/user/{username}
Delete User	Delete	https://petstore.swagger.io/v2/user/{username}
*/
public class Routes {

	public static String base_url ="https://petstore.swagger.io/v2";
	//routes of User module 
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";

	//Store module
		//
	//Pet module 
		//

}
