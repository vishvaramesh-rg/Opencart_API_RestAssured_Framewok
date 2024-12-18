package api.Endpoints;

public class Routes {
	
	
	
	
	//opencart
	
	public static String baseurl = "http://192.168.125.231/opencart/upload/index.php?route=";
	
	//cart
	public static String createToken_post_url= baseurl+"api/login";
	public static String addtocart_Token_post_url= baseurl+"api/cart/add";
	public static String getcartdetails_get_url= baseurl+"api/cart/products";
	public static String editcart_post_url= baseurl+"api/cart/edit";
	public static String removeCart_post_url= baseurl+"api/cart/remove";
	
	
	//gorest


	public static String base_goresturl ="https://gorest.co.in/public/v2/";
	
	public static String post_url=base_goresturl+"users";
	public static String get_url=base_goresturl+"users/{userid}";
	public static String put_url=base_goresturl+"users/{userid}";
	public static String delete_url=base_goresturl+"users/{userid}";
	

}
