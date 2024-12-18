package api.Endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.Cart;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CartEndpoints {


	public static Response createToken(Cart payload) {

		Response response= given()
				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
						.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
				.contentType("multipart/form-data")
				.multiPart("username", payload.getUsername())
				.multiPart("key", payload.getKey())
				//.body(payload)
				.when()
				.post(Routes.createToken_post_url);

		return response;

	}

	public static Response AddtoCart(Cart payload  ) {


		Response response=given()
				.queryParam("api_token", payload.getApi_token_val())
				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
						.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
				.contentType("multipart/form-data")
				.multiPart("product_id",payload.getProduct_id())
				.multiPart("quantity",payload.getQuantity())
				.when()
				.post(Routes.addtocart_Token_post_url);

		return response;
	}

	public static Response getCart(Cart payload) {


		Response response=given()
				.queryParam("api_token", payload.getApi_token_val())
				.when()
				.get(Routes.getcartdetails_get_url);

		return response;
	}


	public static Response editCart(Cart payload) {


		Response response=given()
				.queryParam("api_token", payload.getApi_token_val())
				.config(RestAssured.config().encoderConfig(EncoderConfig
						.encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
				.contentType("multipart/form-data")
				.multiPart("cart_id",payload.getCart_id())
				.multiPart("quantity",payload.getQuantity())
				.when()
				.post(Routes.editcart_post_url);

		return response;
	}

	public static Response removeCart(Cart payload) {


		Response response=given()
				.queryParam("api_token", payload.getApi_token_val())
				.config(RestAssured.config().encoderConfig(EncoderConfig
						.encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
				.contentType("multipart/form-data")
				.multiPart("cart_id",payload.getCart_id())
				.when()
				.post(Routes.removeCart_post_url);

		return response;
	}



















}
