/*August 9, 2022*/

package com.chris;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address
{
	private String street;
	private String city;
	private String state;
	private String zipcode;
}
