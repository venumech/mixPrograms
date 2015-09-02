package com.venu.restapi;

import java.util.Comparator;
//sorts based on city

public class CitySort implements Comparator<Address> {



	@Override
	public int compare(Address o1, Address o2) {
		return o1.getCity().compareTo(o2.getCity());
	}

}
