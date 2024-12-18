package api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.Gorest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GorestEndpoint {
	
	public static Response createUser(Gorest payload) {
		
		Response response= given()
			.headers("Authorization","Bearer "+payload.getToken())
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
			
		
		return response;
	}
	
	public static Response getUser(Gorest payload) {
		
		Response response = given()
			.header("Authorization","Bearer "+payload.getToken())
			.pathParam("userid", payload.getId())
		.when()
			.get(Routes.get_url);
		
		return response;
	}
	
public static Response deleteUser(Gorest payload) {
		
		Response response = given()
			.header("Authorization","Bearer "+payload.getToken())
			.pathParam("userid", payload.getId())
		.when()
			.delete(Routes.delete_url);
		
		return response;
	}
	
	

}
