package api.Payload;

public class Cart {
	
	String username;
	String key;
	String product_id;
	String quantity;
	String cart_id;
	public String api_token_val;
	
	
	
	public String getApi_token_val() {
		return api_token_val;
	}
	public void setApi_token_val(String api_token_val) {
		this.api_token_val = api_token_val;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCart_id() {
		return cart_id;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}
	
	

}
