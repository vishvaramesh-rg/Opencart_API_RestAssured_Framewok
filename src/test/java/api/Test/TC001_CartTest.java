package api.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.Endpoints.CartEndpoints;
import api.Payload.Cart;
import io.restassured.response.Response;

public class TC001_CartTest {
	Logger log;
	Cart data;
	public String api_token_val;
	String cart_id;
	
	
	@BeforeClass
	public void setUp() {
		
		log=LogManager.getLogger(this.getClass());
		
		data = new Cart();
		String key ="DRjnKnQOy41yye5mQP6Cnl2PcXF5RYqV2rEv60nWKeDvCVQptGtTRDFdWFNTbpsNSBWS5HFiFYhNcRRQ18UfWPCyPJqYY2kNOuI1DryZWr2S0VGzPIg1RLkz4KCvxBFX4C6D3yAHWrdZYgCftUXqwdK3XRCJl0Gd7xO4sd3CAs6xbnb5hsw5XZRSMFwy8GLG6kGKDFEhpLHlBpO4cdAZ4U2Y2nG7QZCUSbgms7AxSPa2cyXrzjzhqiEC2eiBPhv8";
		data.setUsername("demo");
		data.setKey(key);
		data.setProduct_id("40");
		data.setQuantity("3");

	}
	
	@Test(priority = 1)
	public void testCreateToken() {
		log.info("****TC001_CartTest - Started*****");
		log.debug("Application log - started");
		
		log.info("****CreateToken*****");
		Response response = CartEndpoints.createToken(data);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		api_token_val = response.jsonPath().get("api_token").toString();
		System.out.println(api_token_val);
		data.setApi_token_val(api_token_val);
		
		log.info("****Created Token*****");
		
	}
	
	@Test(priority = 2)
	public void testAddToCart() {
		log.info("****testAddToCart*****");
		
		Response response = CartEndpoints.AddtoCart(data);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		
		log.info("****Item added to cart*****");
	}
	
	@Test(priority = 3)
	public void testGetCart() {
		
		log.info("****get added cart*****");
		
		Response response = CartEndpoints.getCart(data);
		Assert.assertEquals(response.getStatusCode(), 200);
		cart_id = response.jsonPath().get("products[0].cart_id").toString();
		response.then().log().all();
		System.out.println(cart_id);
		data.setCart_id(cart_id);
		
		log.info("****received added cart*****");
		
	}
	
	@Test(priority = 4)
	public void testEditCart() {
		
		log.info("****Edit added cart*****");
		
		data.setQuantity("4");
		
		// Ensure no value is null before making the API request
		Assert.assertNotNull(data.getApi_token_val(), "API Token is null");
		Assert.assertNotNull(data.getCart_id(), "Cart ID is null");
		Assert.assertNotNull(data.getQuantity(), "Quantity is null");

		Response response = CartEndpoints.editCart(data);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		
		log.info("****Added cart Edited*****");
	}
	
	
	@Test(priority = 5)
	public void testRemoveCart() {
		
		log.info("****Remove added cart*****");
		
		Response response = CartEndpoints.removeCart(data );
		Assert.assertEquals(response.statusCode(), 200);
		
		log.info("****Removed added cart*****");
		
		log.debug("Application log - ended");
		log.info("****TC001_CartTest - ended*****");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
