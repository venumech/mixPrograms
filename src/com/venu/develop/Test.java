package com.venu.develop;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

 public abstract class  Test {

	 Test(String str){}
	 
	static public  void main(String[] args) {

		Map<String, Integer> hs = new HashMap<String,Integer>();
		hs.put("11", 11);
		hs.put("5", 111);
		hs.put("4", 31);
		hs.put(null, 4);

		hs.put(null, 44);
		
		Set<String> set  = new TreeSet<String>();
		set  = hs.keySet();
		
		
		Iterator<String> sets= set.iterator();
			while (sets.hasNext()){
				String key = sets.next();
				System.out.println(key + "    " +hs.get(key));
			}
		
		for (Entry<String, Integer> entry : hs.entrySet()){
			String key = entry.getKey();
			Integer value = entry.getValue(); 
			System.out.println(key + "   ------ " +value);
		}
		
		List list = new ArrayList<Integer>();
		
		
	}
	
	//public abstract String  com.venu.develop();

}
