package api_test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api_endpoints.api_endpoints;
import api_payload.User;
import api_utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String userName, String fName, String lname, String useremail, String password, String ph){
		
		User userpayload =new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fName);
		userpayload.setLastName(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(password);
		userpayload.setPhone(ph);	
		
	    Response response = api_endpoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String UserName) {
		Response response = api_endpoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
