package com.venu.develop;

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

public class Question2 {

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		
		boolean forceUpperCase = true;
		String items[]= new String[5000];
		String str = "";
		
		//prepare a large array object
		for (int i=0; i<5000; ++i)
			items[i]= " a" + i + " ";
		
		long l1 = 0l; 
		
		// Examining the Method provided by the screening com.venu.develop (time elapsed=95 millisec)
		l1 = System.currentTimeMillis();
		str = q2.addStringItems_ScreeningTest(items, forceUpperCase);
		System.out.println("1). time elapsed="+( System.currentTimeMillis() - l1));


		// Examining the optimized Method  (time elapsed=3 millisec)
		l1 = System.currentTimeMillis();
		str = q2.addStringItems(items, forceUpperCase);
		System.out.println("2). time elapsed ="+( System.currentTimeMillis() - l1));
	}
	
	/*
	 * Modified and optimized
	 */

	public String addStringItems(String[] items, boolean forceUpperCase) {
	    String returnValue="";
	    StringBuilder sb = new StringBuilder();
	    if (items != null)
	    	for (String str: items) {
	    		sb.append(str);
	    }
	    returnValue = sb.toString();
	    return forceUpperCase?returnValue.toUpperCase():returnValue;
	 
	}

	/*
	 * original as provided by the screening com.venu.develop
	 */
	public String addStringItems_ScreeningTest(String[] items, boolean forceUpperCase) {
	    String returnValue="";
	     for(int i = 0; i < items.length; i++) {
	      returnValue+=items[i];
	    }
	    return forceUpperCase?returnValue.toUpperCase():returnValue;
	 
	}

}
