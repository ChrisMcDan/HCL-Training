/*August 16, 2022*/

package com.daily.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ConsumerController
{
	@Autowired
	private DiscoveryClient client;

	@GetMapping("/")
	public ResponseEntity getEmp() throws RestClientException, IOException
	{
		List<ServiceInstance> instances = client.getInstances("emp-producer");
		ServiceInstance serinstance = instances.get(0);
		String baseUrl = serinstance.getUri().toString();
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = null;

		try
		{
			response = rest.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception e)
		{
			System.out.println(e);
		}

		System.out.println(response.getBody());
		return ResponseEntity.ok().build();// 200 status
	}

	private HttpEntity<?> getHeaders() throws IOException
	{

		HttpHeaders head = new HttpHeaders();
		head.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		return new HttpEntity<>(head);
	}
}