package org.restcomm.connect.java.sdk;

public class Credentials {

	private static String username=null;
	private static String password=null;
	private static String authID=null;
	private static String authToken=null;
	
	public static String getAuthID() {
		if(authID!=null)return authID;
		else return username;
	}
	public static void setAuthID(String authID) {
		Credentials.authID = authID;
	}
	public static String getAuthToken() {
		if(authToken!=null)return authToken;
		else return password;
	}
	public static void setAuthToken(String authToken) {
		Credentials.authToken = authToken;
	}
	public static String getUsername() {
		if(username!=null)return username;
		else return authID;
	}
	public static void setUsername(String username) {
		Credentials.username = username;
	}
	public static String getPassword() {
		if(password!=null)return password;
		else return authToken;
	}
	public static void setPassword(String password) {
		Credentials.password = password;
	}
}
