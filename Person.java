package com.masai.java;

public abstract class Person {
	
	protected int id;
	protected String aadhar;
	protected String name;
	protected String contact_no;
	
	public Person(int id, String aadhar, String name, String contact_no) {
		this.id = id;
		this.aadhar = aadhar;
		this.name = name;
		this.contact_no = contact_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", aadhar=" + aadhar + ", name=" + name + ", contact_no=" + contact_no + "]";
	}
	
	public abstract void add();
	public abstract void update();
	public abstract void remove();
	public abstract void print();
	
	
	
	/**
	 * Valid Aadhar Card : 16 characters, only digits + unique
	 * @param : aadhar
	 * @return true if the aadhar is valid
	 */
	
	public static boolean isAadharValid(String aadhar)
	{
		//code
	}
	
	/**
	 * Valid name : contain only letters and white spaces
	 * @param : name
	 * @return true if the name is valid
	 */
	
	public static boolean isNameValid(String name)
	{
		// code
	}
	
	
	/**
	 * Valid contact : contact number has 12 digits and starts with "91"
	 * @param : name
	 * @return true if the contact is valid
	 */
	
	public static boolean isContactValid(String name)
	{
		// code
	}
	
	
	/**
	 * Valid ID : can only be digit greater than 0, unique
	 * @param : id
	 * @return true if the id is valid
	 */
	
	public static boolean isIDValid(int id)
	{
		// code
	}
	
	

}