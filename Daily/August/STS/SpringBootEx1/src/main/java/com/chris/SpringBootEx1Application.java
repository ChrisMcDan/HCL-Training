/*August 4 and 5, 2022*/

package com.chris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chris.Config.StudentConfig;
import com.chris.Model.Employee;
import com.chris.Model.Student;

@SpringBootApplication
public class SpringBootEx1Application
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringBootEx1Application.class, args);
		Employee emp = context.getBean(Employee.class);
			emp.setEid(100);
			emp.setEname("Chris");
			emp.showEmployeeDetails();	//This will not work if it's not Autowired.
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
			Student st = ctx.getBean("studentBean", Student.class);
			st.call();
	}
}