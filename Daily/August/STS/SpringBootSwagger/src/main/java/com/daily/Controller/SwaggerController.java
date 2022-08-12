/*August 12, 2022*/

package com.daily.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daily.Model.Student;

@RestController
@RequestMapping("/api")
public class SwaggerController
{
	List<Student> list = new ArrayList<>();
	{
		list.add(new Student("Chris", "Computer Science", "Hutto"));
		list.add(new Student("Dylan", "Mechanical", "NY"));
		list.add(new Student("Saran", "Biomedicine", "Frisco"));
		list.add(new Student("Athul", "Civil", "NJ"));
	}

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		return list;
	}

	@GetMapping("/getStudentByName/{name}")
	public Student getStudentByName(@PathVariable("name") String name)
	{
		return list.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}

	@GetMapping("/getStudentByAddress/{address}")
	public Student getStudentByAddress(@PathVariable("address") String address)
	{
		return list.stream().filter(x -> x.getAddress().equalsIgnoreCase(address)).collect(Collectors.toList()).get(0);
	}
	
	
}
