package it.itjustworks.emergency;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Emergency {

	private OkHttpClient client;
	private String endpoint;
	
	public Emergency() {
		this("https://emergency-server.herokuapp.com");
	}
	
	private Emergency(String backendUrl){
		this.client = new OkHttpClient();
		this.endpoint = backendUrl;
	}
	
	public Emergency withBackEndUrl(String url){
		return new Emergency(url);
	}
	
	public String sendRequest(Requestable req) throws IOException {
		Request request = new Request.Builder().url(this.endpoint + req.url()).build();
		Response response = this.client.newCall(request).execute();
		return response.body().string();
	}

	
	
}
