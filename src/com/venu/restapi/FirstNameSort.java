package com.venu.restapi;

import java.util.Comparator;
/* sorts based on firstname
 * 
 */

public class FirstNameSort implements Comparator<Customer> {



	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}
