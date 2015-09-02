package com.venu.restapi;

import java.util.List;

/* implemented for sorting based on lastname
 * 
 */
public class Customer implements Comparable<Customer>{   
	private Integer id;
	private List<Address> addresses;
	private String lastName;
	private String firstName;
	private String gender; //Male or Female or Unknown
	private Integer age;
	
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the lineItem
	 */
	public List<Address> getAddresses() {
		return addresses;
	}
	/**
	 * @param lineItem the lineItem to set
	 */
	public void setAddresses(List<Address> address) {
		addresses = address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String toString(){
		
		 return "["+this.id + "," + this.firstName + "," + 
				 this.lastName  + "," + "[{" + this.getAddresses() + "}]"  +"]"; 
	}
	@Override
	//sorting on last name
	public int compareTo(Customer cust) {
		return lastName.compareTo(cust.getLastName());
		
	}
}
