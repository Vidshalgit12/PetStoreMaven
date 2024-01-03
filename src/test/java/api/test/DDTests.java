package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.*;
import io.restassured.response.Response;
public class DDTests {

	@Test(priority=1, dataProvider="Data",dataProviderClass=Dataproviders.class)
	public void testPostUser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph )
	{
		User userPayload= new User();
		
		userPayload.setId(Integer.parseInt(userID));//hash code will gen rand
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		Response response=UserEndPoints.CreateUser(userPayload);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=Dataproviders.class)
	public void testGetUser(String userName)
	{
		Response response=UserEndPoints.readUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3,dataProvider="UserNames",dataProviderClass=Dataproviders.class)
	public void testDeleteUser(String userName)
	{
		Response response=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
