package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StudySyncHttpClient {
	private static final String REST_API_URL = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";
	public static void main(String[] args) throws IOException, InterruptedException {
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
								 .uri(URI.create(REST_API_URL))
								 .header("Accept", "application/json")
								 .build();
		var start = System.currentTimeMillis();
		for (var i=0;i<10;++i) {
			var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			System.err.println(response);
		}
		var stop = System.currentTimeMillis();
		System.err.println("Duration: "+(stop-start)+" ms.");
	}

}
