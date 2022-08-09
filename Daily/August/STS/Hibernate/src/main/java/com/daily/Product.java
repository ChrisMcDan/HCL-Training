/*August 9, 2022*/

package com.daily;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
	private int prdId;
	private String prdName;
	private int prdPrice;
}
