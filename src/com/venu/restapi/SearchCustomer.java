package com.venu.restapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;
/*
 * 2 search options provided in 2 different methods.
 * Please choose one that matches to the needs
 * 1. search customers set if *ALL* of the fields are matching to the existing data
 * 2. search customers set if *ANY* of the fields are matching to the existing data
 */

public class SearchCustomer {

	//data from the data base is pulled into the below set.
	private static Set<Customer> dataSet = new TreeSet<Customer>();
	
	public static final int SORT_GENDER=0;
	public static final int SORT_FNAME=1;
	public static final int SORT_AGE=2;
	public static final int SORT_CITY=3;
	/* sorting preferences */
	public static final int[] SORTORDER= {0,1,2};
	
	//0 --> sorting based on gender
	//1 --> sorting based on lastName
	//2 --> sorting based on city
	
	
	
	/*
	 * search customers set if *ALL* of the fields are matching to the existing data
	 */
	public List<Customer> searchCustomersStrict (String lastname, String firstname, String gender, Integer age, String state, int sortorder){
		List<Customer> list = new ArrayList<Customer>();
		
		Iterator<Customer> custIter = dataSet.iterator();
		
		
		while (custIter.hasNext()){
			Customer c= custIter.next();
			List<Address> addresses = new ArrayList<Address>();
			addresses = c.getAddresses();
			/*
			if ((c.getLastName().equalsIgnoreCase(lastname)) && (c.getGender().equalsIgnoreCase(gender))
					&& (c.getLastName().equalsIgnoreCase(lastname))
					&& (c.getAge() >= age)
					){
*/

			if ((c.getLastName().startsWith((lastname)) && (c.getGender().equalsIgnoreCase(gender))
					&& (c.getLastName().startsWith(lastname))
					&& (c.getAge() >= age)
					)){
			for (Address adr : addresses){
					if (adr.getState().startsWith(state)){
						
					list.add(c);
					}
				
				}
				
			}
			

		}
		
	    switch (sortorder) {
		
	        case 0: //SORT_GENDER=0
	        	GenderSort gs = new GenderSort();	    		
	    		Collections.sort(list, gs); //sort based on gender
	            System.out.println("list is prepared based on the gender sort");
	            break;
	        case 1: //SORT_FNAME=1;

	        	FirstNameSort fn = new FirstNameSort();
	    		Collections.sort(list, fn);  //sort based on FirstName
	            System.out.println("list is prepared based on the FirstName sort");
	            break;
	        case 2: //SORT_AGE=2;
	    		
	    		AgeSort ag = new AgeSort();
	    		
	    		Collections.sort(list, ag); //sort based on Age
	            System.out.println("list is prepared based on the Age sort");
	            break;
	        case 3: //SORT_CITY=3;
	    		//sort based on City
	            System.out.println("Final result: Success");
	            break;
	        default:
	            System.out.println("Unknown result");
	            break;
	        }
 
	
		return list;
		
	}
	
	/*
	 * search customers set if *ANY* of the fields are matching to the existing data
	 */
	public List<Customer> searchCustomers (String lastname, String firstname, String gender, Integer age, String state, int sortorder){
		List<Customer> list = new ArrayList<Customer>();
		
		Iterator<Customer> custIter = dataSet.iterator();
		
		
		while (custIter.hasNext()){
			Customer c= custIter.next();
			List<Address> addresses = new ArrayList<Address>();
			
			if (c.getLastName().equalsIgnoreCase(lastname)){
				list.add(c);
			} else if  (c.getGender().equalsIgnoreCase(gender)){
				list.add(c);
			} else if  (c.getLastName().equalsIgnoreCase(lastname)){
				list.add(c);
			} else if  (c.getAge() >= age){
				list.add(c);
			}
			
			for (Address adr : addresses){
				if (adr.getState().equalsIgnoreCase(state)){
					
				list.add(c);
				}
			
			}
		}
		
	    switch (sortorder) {
		
	        case 0: //SORT_GENDER=0
	        	GenderSort gs = new GenderSort();	    		
	    		Collections.sort(list, gs); //sort based on gender
	            System.out.println("list is prepared based on the gender sort");
	            break;
	        case 1: //SORT_FNAME=1;

	        	FirstNameSort fn = new FirstNameSort();
	    		Collections.sort(list, fn);  //sort based on FirstName
	            System.out.println("list is prepared based on the FirstName sort");
	            break;
	        case 2: //SORT_AGE=2;
	    		
	    		AgeSort ag = new AgeSort();
	    		
	    		Collections.sort(list, ag); //sort based on Age
	            System.out.println("list is prepared based on the Age sort");
	            break;
	        case 3: //SORT_CITY=3;
	    		//sort based on City
	            System.out.println("Final result: Success");
	            break;
	        default:
	            System.out.println("Unknown result");
	            break;
	        }
 
	
		return list;
		
	}
	
	public static void main(String[] args) {

		for (int i=0; i<1000; ++i) {
		Customer c = new Customer();
		c.setId(i);
		c.setAge(new Random().nextInt(50-10) +10);
		//c.setAge(22+ i/5 ==5?-7: 2);
		//System.out.println(Math.round (Math.random() * 50));
		//System.out.println(new Random().nextInt(50-10) +10);
		c.setLastName("Edward " +i);
		c.setFirstName("Pat " +i);
		c.setGender(Math.random() * 5>3? "Female":"Male");
		Address ad = new Address();
		ad.setCity("city " +i);
		ad.setState("" + (char) (new Random().nextInt(5) + 'a') + (char) (new Random().nextInt(5) + 'a'));
		//System.out.println(ad.getState());
		ad.setStreet1("street1+ " + i);
		ad.setStreet2("street2 " +i);
		ad.setZip("zip "+ i*1123);
		List adlist = new ArrayList<Address>();
		adlist.add(ad);
		c.setAddresses(adlist);
		
		//dataSet = new TreeSet<Customer>();
		dataSet.add(c);
		
		}
		List<Customer> resultList = new ArrayList<Customer>();
		SearchCustomer search = new SearchCustomer();
		resultList = search.searchCustomersStrict("Edward", "Pat", "Male", 22, "a", SORT_AGE); //sort based on AGE
		//resultList = search.searchCustomers ("Edward", "Pat", "Male", 22, "VA", SORT_GENDER); //sort based on AGE
		
		//print the customers
		for (Customer cust: resultList){
			System.out.println(cust.getId() + "  , " + cust.getFirstName()+ "  , gender=" + cust.getGender()+ "  , " + cust.getAge());
		}

	}

}
