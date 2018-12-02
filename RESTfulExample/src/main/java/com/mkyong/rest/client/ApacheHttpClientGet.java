package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			String url = "http://localhost:8080/cookiebasedspringrestauth2/api/bankapi/withdraw/12345/500";
//			HttpGet getRequest = new HttpGet(
//					"http://localhost:8080/RESTfulExample/json/product/get");
			
			HttpGet getRequest = new HttpGet(url);
			
			getRequest.addHeader("accept", "application/json");
			
			
			CookieStore cookieStore = httpClient.getCookieStore();
			
			
			

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}