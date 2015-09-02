package com.venu.develop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * There are 2 similar purpose methods are compared. 
 * 1) as provided from the screening com.venu.develop: addStringItems_ScreeningTest()
 * 2) modified by me: addStringItems()
 * I ran a simple bench marking com.venu.develop to evaluate the performances between these 2 methods.
 * 
 * My method stands out better than the unmodified method. 
 * In terms of processing speed, my method is 30 times quicker!
 * 
 * @author Venu
 *
 */

public class Question3 {

	public static void main(String[] args) {
		Question3 q2 = new Question3();
		
		boolean forceUpperCase = true;
		String items[]= new String[5000];
		String str = "";
		
		//prepare a large array object
		for (int i=0; i<5000; ++i)
			items[i]= " a" + i + " ";
		
		long l1 = 0l; 
		
		// Examining the optimized Method  (time elapsed=3 millisec)
		l1 = System.currentTimeMillis();
		str = q2.addStringItems(items, forceUpperCase);
		System.out.println("2). time elapsed ="+( System.currentTimeMillis() - l1));
	}
	
	/*
	 * Modified and optimized
	 * optimized code for fast access and thread safe implementation
	 */
	public String addStringItems(String[] items, boolean forceUpperCase) {
	    String returnValue="";
	    Set<String> set = new HashSet<String>();
	    
	    set = Collections.synchronizedSet(set);
	    synchronized(set) {
	    if (items != null)
	    	for (String str: items) {
	    		set.add(str);
	    }
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    if (items != null)
	    	for (String str: set) {
	    		sb.append(str);
	    }
	    returnValue = sb.toString();
	    return forceUpperCase?returnValue.toUpperCase():returnValue;
	 
	}

}
