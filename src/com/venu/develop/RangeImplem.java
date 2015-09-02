/**
 * 
 */
package com.venu.develop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Venu
 *
 */
public class RangeImplem implements Range {

	private Set<Integer> rangeset = new TreeSet<Integer>();
	
	/*
	public RangeImplem(int from, int to){
		for (int i=from; i<=to; ++i) 
		this.rangeset.add(i);
		System.out.print(rangeset);
	}
	*/
	
	public RangeImplem() {	}
	
	
	/* (non-Javadoc)
	 * @see com.venu.develop.Range#newRange(int, int)
	 */
	@Override
	public Range newRange(int from, int to) {
		RangeImplem range = new RangeImplem();
		for (int i=from; i<=to; ++i) 
			range.rangeset.add(i);
		//System.out.print(this.rangeset);
			// System.out.printf("%s \n","the instance is created.");
				
		return range;
	}

	/* (non-Javadoc)
	 * @see com.venu.develop.Range#isIn(int)
	 */
	@Override
	public boolean isIn(int value) {
		
		//Integer intvalue = value;
		if (this.rangeset.contains(value))		//autoboxing in effect. auto box of int to Integer
		return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.venu.develop.Range#min()
	 */
	@Override
	public int min() {
		//since it is a treeset Implementation, which is always 'naturally' sorted in ascending order.
		//retrieving the first element is always the minimum!
		//so, get the first element - there is no point scanning all the entire elements in that set which is a performance overhead.

		return this.rangeset.iterator().next();  
	}

	/* (non-Javadoc)
	 * @see com.venu.develop.Range#max()
	 */
	@Override
	public int max() {
		List<Integer> list = new ArrayList<Integer>(rangeset);
		 Collections.reverse(list);
		 return list.get(0);//this.rangeset.iterator().next(); 
		
	}

	/* (non-Javadoc)
	 * @see com.venu.develop.Range#add(com.venu.develop.Range)
	 */
	@Override
	public Range add(Range r) {
	
		TreeSet ts = (TreeSet) ((RangeImplem) r).getRangeset();
		
		
		
		this.rangeset.addAll(ts);
		System.out.println(this.rangeset);
		
		return this;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean flag = false;
		RangeImplem r=new RangeImplem();
		flag = r.newRange(1,5).isIn(3);
		System.out.println(" r.newRange(1,5).isIn(3) ==> " +flag);
		

		flag = r.newRange(1,5).isIn(6);
		System.out.println("r.newRange(1,5).isIn(6) ==> " +flag);
		
		flag = r.newRange(1,5).add(r.newRange(8,10)).isIn(6);
		System.out.println("r.newRange(1,5).add(r.newRange(8,10)).isIn(6) ==> " + flag);
		

		Integer i = r.newRange(1,5).add(r.newRange(8,10)).max();
		Integer min = r.newRange(1,5).add(r.newRange(8,10)).min();
		System.out.printf("max -->%d, Min-->%d\n", +i, min);
		
/*
		Range r1 = new RangeImplem().newRange(10, 15);
		Range r2 = new RangeImplem().newRange(20, 45);
		

		System.out.println( "print r1 => " +((RangeImplem) r1).getRangeset());
		Range r3 = r1.add(r2);
		
		System.out.println( "print r3 => " +((RangeImplem) r3).getRangeset());
*/
	}


	public Set<Integer> getRangeset() {
		return rangeset;
	}


}
