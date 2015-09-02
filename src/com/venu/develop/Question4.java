package com.venu.develop;

import java.util.*;

public class Question4 {

	/*
	•	itr1 and itr2 iterate over their contents in sorted order
	•	The result is the combination of itr1 and itr2, in the same order itr1 and itr2 is sorted
	•	The function should operate in O(n) time
	 */
	public List<String> combine(Iterator<String> itr1, Iterator<String> itr2){
		
		List<String> list = new ArrayList<String>();
		
		Set<String> set = new TreeSet<String>();
		

		while (itr1.hasNext())		
				list.add(itr1.next());
		

		while (itr2.hasNext())		
				list.add(itr2.next());
		
		//list.addAll(set);
		System.out.println(list);
		return list;
		
	}
	

	/*
	•	itr1 and itr2 iterate over their contents in sorted order
	•	The result is the combination of itr1 and itr2, in the same order itr1 and itr2 is sorted
	•	The function should operate in O(1) time
	 */
	public List<String> combine_O1(Iterator<String> itr1, Iterator<String> itr2){
		
		List<String> list = new ArrayList<String>();

//TODO

		while (itr1.hasNext())		
				list.add(itr1.next());

		while (itr2.hasNext())		
				list.add(itr2.next());
		
		//list.addAll(set);
		System.out.println(list);
		return list;
		
	}
	
	public static void main(String... str){
		
		Question4 q4 = new Question4();
		Set<String> ts2 = new TreeSet<String>();
		ts2.add("abc");
		ts2.add("xyz");
		ts2.add("mno");
		
		Set<String> ts1 = new TreeSet<String>();
		ts1.add("b1");
		ts1.add("b2");
		ts1.add("c4");

		Iterator<String> itr1 = ts1.iterator();

		Iterator<String> itr2 = ts2.iterator();
		
		q4.combine(itr1, itr2);
	}
}
