/*August 15, 2022*/

package com.daily.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person_July")
public class Person
{
	@Id
	private int prID;
	private String prName;
	private String prAddress;
}
