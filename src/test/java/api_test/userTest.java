package api_test;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.internal.LogManagerStatus;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api_endpoints.api_endpoints;
import api_payload.User;
import io.restassured.response.Response;

public class userTest {
	
	Faker faker;
	User userpayload;
	
	public org.apache.logging.log4j.Logger logger;
	
	@BeforeClass
	public void setup() {
		faker=new Faker();
		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());	
		
		//logs
//		logger=(Logger) LogManager.getLogger(this.getClass());
		logger= LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=1)
	public void testPostUser(){
		logger.info("*********Creating User********");
		Response response = api_endpoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*********User created********");
	}
	@Test(priority=2)
	public void testGetUserByName() {
		logger.info("*********Read ser********");
		Response response=api_endpoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*********User information is displayed********");
	}
	@Test(priority=3)
	public void testUpdateUserByName()
	
	{	//update data using payload
		logger.info("*********Updating user information********");
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response=api_endpoints.updateUser(this.userpayload.getUsername(),userpayload);
		response.then().log().all();
		//or response.then.log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(),200);
		
		//checking data after update reequest 
		//by passing the getuser request
		Response responseAfterUpdateRequestByGetUser = api_endpoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdateRequestByGetUser.getStatusCode(),200);
		logger.info("*********User information is updated********");
	}
	@Test(priority=4)
	public void testDeleteUserByName() {
		logger.info("*********Deleting User********");
		Response response=api_endpoints.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);	
		logger.info("*********Deleted User********");
	}
	
}
