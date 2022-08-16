/*August 16, 2022*/

package com.daily;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class EmpConsumerApplication
{
	public static void main(String[] args) throws RestClientException, IOException
	{
		ApplicationContext ctx = SpringApplication.run(EmpConsumerApplication.class, args);
		ConsumerClient consumer = ctx.getBean(ConsumerClient.class);
		System.out.println(consumer);
		consumer.getAllEmps();
	}
}