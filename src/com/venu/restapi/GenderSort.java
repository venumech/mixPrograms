package com.venu.restapi;

import java.util.Comparator;
/* sorts based on gender
 * 
 */

public class GenderSort implements Comparator<Customer> {



	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getGender().compareTo(o2.getGender());
	}

}
