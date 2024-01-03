package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	Faker faker;
	User userPayload;
	public Logger logger;
	@BeforeClass
	public void setupData()
	{
		faker =new Faker();
		userPayload =new User();

		userPayload.setId(faker.idNumber().hashCode());//hash code will gen rand
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		//logs
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
		public void testPostUser()
	{
		
		logger.info("***************Creating user***********");
		Response response=UserEndPoints2.CreateUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***************User Created***********");
	}
	
	@Test(priority=2)
	public void testGetUserbyName() 
	{
		logger.info("***************Reading user by Name***********");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
response.then().log().all();
	//response.statusCode();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***************Reading user Completed***********");
	}
	
	@Test(priority=3)
	public void testUpdateUserbyName()
	{
		logger.info("***************Updating user***********");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response= UserEndPoints2.updateUser (this.userPayload.getUsername(),userPayload);
		//response.then().log().all();
		//response.then().log().body().statusCode(200);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after updating 
		Response responseafter=UserEndPoints2.readUser(this.userPayload.getUsername());
		responseafter.then().log().all();
			//response.statusCode();
				Assert.assertEquals(responseafter.getStatusCode(), 200);
				logger.info("***************Updated user***********");
	}
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("***************Deleting user***********");
		Response response=UserEndPoints2.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***************Deleting user completed***********");
		
	}
}//User Class
