/*August 11, 2022*/

package com.daily;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daily.Service.HelloWorldService;

@SpringBootApplication
public class SpringBootSlf4jApplication implements CommandLineRunner
{
	// SLF4J's logging instance for this class
	// We could have use LoggerFactory.getLogger(Slf4jSpringBootApplication.class)
	// as well.
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	// This is what SLF4J uses to bind to a specific logging implementation.
	final StaticLoggerBinder binder = StaticLoggerBinder.getSingleton();

	@Autowired
	private HelloWorldService helloWorldService;

	public void run(String... args)
	{
		System.out.println(binder.getLoggerFactory());
		System.out.println(binder.getLoggerFactoryClassStr());

		LOGGER.info(this.helloWorldService.getHelloMessage());

		if (args.length > 0 && args[0].equals("exitcode"))
		{
			LOGGER.error("Exit Code encountered", new Exception());
		}
	}

	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(SpringBootSlf4jApplication.class, args);
	}
}