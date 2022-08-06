/*August 5, 2022*/

package com.chris.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chris.Model.Student;

@Configuration
public class StudentConfig
{
	@Bean("studentBean")
	public Student stuBean()
	{
		return new Student();
	}
}
