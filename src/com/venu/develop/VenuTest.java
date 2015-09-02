package com.venu.develop;

import java.util.HashSet;
import java.util.Set;

/*
 * from Dusan Jovic to Everyone:
Programming Exercise: Write a method 
that takes in 2 String array arguments and returns the Set of common elements
 between them.
 */
public class VenuTest {

	public static void main(String[] args) {
		VenuTest vt = new VenuTest();
		String[] array1 = {"a", "b", "c"};
		String[] array2 = {"x", "y", "a", "c"};		
		
		Set<String> set = vt.testArrays(array1, array2);
		
		//Iterator iter = 
		System.out.println(set);

	}

	public Set<String> testArrays(String[] str1, String[] str2) {
		
		Set<String> set = new HashSet<String> ();
		for (String st : str1)
			for (String st2: str2)
				if (st.equals(st2))
					set.add(st);		
		
		return set;		
	}
			
		
			
}
