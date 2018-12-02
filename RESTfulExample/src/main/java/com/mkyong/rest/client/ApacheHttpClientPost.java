package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpClientPost {

	// http://localhost:8080/RESTfulExample/json/product/post
	public static void main(String[] args) {

		try {

			String url = "http://localhost:8080/cookiebasedspringrestauth2/j_spring_security_check?j_username=d&j_password=d";
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
//			HttpPost postRequest = new HttpPost(
//					"http://localhost:8080/RESTfulExample/json/product/post");
			
			HttpPost postRequest = new HttpPost(url);

//			StringEntity input = new StringEntity(
//					"{\"qty\":100,\"name\":\"iPad 4\"}");
//			input.setContentType("application/json");
//			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);
			System.out.println("Response :::"+response.getStatusLine().getStatusCode());

//			if (response.getStatusLine().getStatusCode() != 201) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ response.getStatusLine().getStatusCode());
//			}
			
//			ResponseHandler<String> responseHandler = new BasicResponseHandler();
//			String responseBody = responseHandler.handleResponse(response);
//			System.out.println(responseBody);
			
			Header headers[] = response.getAllHeaders();
			for(Header h:headers){
				System.out.println(h.getName() + ": " + h.getValue());
			}
			
			System.out.println("--->"+httpClient.getCookieStore());
			
			

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

//			String output;
//			System.out.println("Output from Server .... \n");
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}