/* August 3, 2022 */

package com.daily;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.daily.Model.Student;
import com.daily.Model.User;

public class App
{
	public static void main(String[] args)
	{
		Resource r = new ClassPathResource("spring.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		//By setter method.
		Student s = (Student) factory.getBean("obj");
		s.call();
		
		//By constructor.
//		Student s1 = (Student) factory.getBean("stu");
//		s1.call();
		
		Student s3 = (Student) factory.getBean("dep");
		s3.call();
		s3.display();
		
		User u = (User) factory.getBean("list");
		u.print();
	}
}
