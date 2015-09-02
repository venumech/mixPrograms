package com.venu.sort;

/*
 * This is a simple search package for of customers  ( stored in collections implementation)
 * and then sort the customers
 * based on either first name , last name, state of residence, or gender, etc.
 * To make it simple, run from main. 
 * 2 search options provided in 2 different methods.
 * Please choose one that matches to the needs
 * 1. searchCustomersStrict():
 *    search customers dataset if *ALL* of the fields are matching to the existing data
 * 2. searchCustomers():
 *    search customers dataset if *ANY* of the fields are matching to the existing data
 */
import java.util.*;

public class SearchCustomer {

	//data from the data base is pulled into the below set.
	private static Set<Customer> dataSet = new HashSet<Customer>();
	
	public static final int SORT_GENDER=0;
	public static final int SORT_FNAME=1;
	public static final int SORT_AGE=2;
	public static final int SORT_STATE=3;
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
		
		
		while (custIter.hasNext()) {
			Customer c = custIter.next();
			List<Address> addresses = new ArrayList<Address>();
			addresses = c.addresses;
			if ((c.lastName.startsWith((lastname)) && (c.gender.equalsIgnoreCase(gender))
					&& (c.firstName.startsWith(lastname)) && (c.age >= age))) {
				for (Address adr : addresses) {
					if (adr.state.startsWith(state)) {

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
			
			if (c.lastName.equalsIgnoreCase(lastname)){
				list.add(c);
			} else if  (c.gender.equalsIgnoreCase(gender)){
				list.add(c);
			} else if  (c.firstName.equalsIgnoreCase(firstname)){
				list.add(c);
			} else if  (c.age >= age){
				list.add(c);
			}
			
			for (Address adr : addresses){
				if (adr.state.equalsIgnoreCase(state)){
					
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
	        case 3: //SORT_STATE=3;
	    		//sort based on state

	    		StateSort st = new StateSort();
	    		
	    		Collections.sort(list, st); //sort based on Age
	            System.out.println("list is prepared based on the State sort");
	            break;
	        default:
	            System.out.println("Unknown result");
	            break;
	        }
 
	
		return list;
		
	}
	
	public static void main(String[] args) {

		String gender ="";
		String state ="";

		SearchCustomer search = new SearchCustomer();
		for (int i = 0; i < 2000; ++i) {
			int age = new Random().nextInt(70 - 30) + 30;
			gender = Math.random() * 10 > 2 ? "Female" : "Male";
			state = ("" + (char) (new Random().nextInt(5) + 'a') + (char) (new Random().nextInt(5) + 'a'));
			Address ad = search.new Address(("street1+ " + i), ("street2 " + i), ("city " + i), state,
					("zip " + i * 1123));

			List<Address> adlist = new ArrayList<Address>();
			adlist.add(ad);

			Customer cust = new SearchCustomer().new Customer(i, adlist, ("Edward " + i), ((char) (new Random().nextInt(20) + 'a')+ "at"), gender, age);

			dataSet.add(cust);


		}
		
		
		List<Customer> resultList = new ArrayList<Customer>();
		resultList = search.searchCustomers("Edward", "Pat", "Male", 62, "ac", SORT_AGE); //sort based on AGE
		//resultList = search.searchCustomers("Edward", "Pat", "Male", 42, "ac", SORT_STATE); //sort based on AGE
		//resultList = search.searchCustomers ("Edward", "Pat", "Male", 22, "VA", SORT_GENDER); //sort based on AGE
		
		//print the customers
		
		for (Customer cust: resultList){
			System.out.println("cust.id=" + cust.id + "  , " + cust.firstName+ "  , gender=" + cust.gender+ "  , " + cust.age+ "  , state=" + cust.addresses.get(0).state);
		}
		System.out.println("dataSet.size() = " + dataSet.size() + "; resultList.size()=" + resultList.size());
	}
	
	// -------------------------- INNER CLASSES --------------------------

    class Customer implements Comparable<Customer>{   
    	private Integer id;
    	private List<Address> addresses;
    	private String lastName;
    	private String firstName;
    	private String gender; //Male or Female or Unknown
    	private Integer age;


        public Customer (Integer id, List<Address> addresses, String lastName, String firstName, 
        		String gender, Integer age)
        {
            this.id = id;
            this.addresses = addresses;
            this.lastName = lastName;
            this.firstName = firstName;
            this.gender = gender;
            this.age = age;
        }


		@Override
		public int compareTo(Customer o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
    }
    
    class Address
    {
    	private String street1;
    	private String street2;
    	private String city;
    	private String state;
    	private String zip;

        public Address(String street1, String street2, String city, String state, String zip)
        {
        	this.street1 = street1;
        	this.street2= street2;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }
    }

    /* -----The below classes are for sort purpose based on the category */
    
    class AgeSort implements Comparator<Customer> {
    	@Override
    	public int compare(Customer o1, Customer o2) {
    		return o1.age.compareTo(o2.age);
    	}

    }

    class FirstNameSort implements Comparator<Customer> {
    	@Override
    	public int compare(Customer o1, Customer o2) {
    		return o1.firstName.compareTo(o2.firstName);
    	}

    }
    
    class GenderSort implements Comparator<Customer> {
    	@Override
    	public int compare(Customer o1, Customer o2) {
    		return o1.gender.compareTo(o2.gender);
    	}

    }

    class StateSort implements Comparator<Customer> {
    	@Override
    	public int compare(Customer o1, Customer o2) {
    		String o1state =o1.addresses.get(0).state;
    		String o2state =o2.addresses.get(0).state;
    		return o1state.compareTo(o2state);
    	}

    }
    
}