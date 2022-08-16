/*August 16, 2022*/

package com.daily;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerClient
{
	public void getAllEmps() throws RestClientException, IOException
	{
		String baseUrl = "http://localhost:8181";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try
		{
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception e)
		{
			System.out.println(e);
		}
		System.out.println(response.getBody());
	}

	private HttpEntity<?> getHeaders() throws IOException
	{
		HttpHeaders head = new HttpHeaders();
		head.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		return new HttpEntity<>(head);
	}
}