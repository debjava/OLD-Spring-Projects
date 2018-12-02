package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientTest1 {
	
	public static void main(String[] args) throws Exception {
		
		String postUrl = "http://localhost:8080/cookiebasedspringrestauth2/j_spring_security_check?j_username=d&j_password=d";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost(postUrl);
		
		HttpResponse response = httpClient.execute(postRequest);
		System.out.println("Response Code :::"+response.getStatusLine().getStatusCode());
		Header headers[] = response.getAllHeaders();
		for(Header h:headers){
			System.out.println(h.getName() + ": " + h.getValue());
		}
		
		CookieStore cookieStore = httpClient.getCookieStore();
		System.out.println("--->"+cookieStore);
		
		httpClient.getConnectionManager().shutdown();
		
		//Use the above cookie to invoke another one
		
		httpClient = new DefaultHttpClient();
		String getUrl = "http://localhost:8080/cookiebasedspringrestauth2/api/bankapi/withdraw/12345/500";
		HttpGet getRequest = new HttpGet(getUrl);
		getRequest.addHeader("accept", "application/json");
		
		httpClient.setCookieStore(cookieStore);
		
		response = httpClient.execute(getRequest);
		System.out.println("Now Response Code :::"+response.getStatusLine().getStatusCode());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));

		String output;
		System.out.println("Response from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		
		httpClient.getConnectionManager().shutdown();
		
	}

}
