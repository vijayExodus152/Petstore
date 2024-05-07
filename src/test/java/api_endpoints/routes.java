package api_endpoints;

/*
 swagger URI---->https://petstore.swagger.io
 
 create user(post): https://petstore.swagger.io/v2/user
 Get user (Get):https://petstore.swagger.io/v2/user/{username}
 Update user (Put):https://petstore.swagger.io/v2/user/{username}
 Delete user (Delete) https://petstore.swagger.io/v2/user/{username}
 */
public class routes {
	public static String base_url="https://petstore.swagger.io/v2";
	//user module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//store module
	
	//pet module

}
