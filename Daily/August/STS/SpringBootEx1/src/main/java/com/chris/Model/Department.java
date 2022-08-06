/*August 5, 2022*/

package com.chris.Model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component	//<bean id="obj" class="com.chirs.Model.Department/>
public class Department
{
	public String deptName;
}
