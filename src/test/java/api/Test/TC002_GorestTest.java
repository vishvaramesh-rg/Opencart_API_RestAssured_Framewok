package api.Test;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoints.GorestEndpoint;
import api.Payload.Gorest;
import io.restassured.response.Response;
import utilities.DataProviders;

public class TC002_GorestTest {
	

	@Test(dataProvider = "valueandget",dataProviderClass = DataProviders.class)
	public void GorestTest(String Token, String Name, String Email, String Gender, String Status) {
		//log
		Logger log = LogManager.getLogger(this.getClass());
		log.info("****TC002_GorestTest - Started*****");
		log.debug("Application log - started");
		
		
		log.info("Create user");
		Gorest data = new Gorest();
		data.setToken(Token);
		data.setName(Name);
		data.setEmail(Email);
		data.setGender(Gender);
		data.setStatus(Status);
		
		Response response = GorestEndpoint.createUser(data);
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
		int userId = response.jsonPath().get("id");
		System.out.println(userId);
		data.setId(userId);
		log.info("user created ==>"+userId);
		
		log.info("get user");
		
		Response resget=GorestEndpoint.getUser(data);
		Assert.assertEquals(resget.statusCode(), 200);
		resget.then().log().all();
		
		log.info("get user==>"+userId);
		
		log.info("Delete user");
		Response deleteUser = GorestEndpoint.deleteUser(data);
		Assert.assertEquals(deleteUser.statusCode(), 204);
		
		log.info("User Deleted===>"+userId);
		
		log.debug("Application log - ended");
		log.info("****TC002_GorestTest - ended*****");
		
	}
}
