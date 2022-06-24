package com.masai.java;

import java.util.ArrayList;

public class Customer extends Person{
	
	
	private int bill;
	
	public Customer(int id, String aadhar, String name, String contact_no, int bill) {
		super(id, aadhar, name, contact_no);
		this.bill = bill;
	}
	
	
	
	public static ArrayList<Customer> searchByName(String name)
	{
		// code
	}
	
	public static Customer searchByAadhar(String aadhar)
	{
		// code
	}
	
	public static Customer searchByID(int id)
	{
		// code
	}
	
	

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
		ArrayList<Customer> customerList = RentRunner.customerList ;
		
		customerList.add(this);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
		ArrayList<Customer> customerList = RentRunner.customerList ;
		
		for(Customer c : customerList)
		{
			System.out.println(c);
		}
		
	}
	

}