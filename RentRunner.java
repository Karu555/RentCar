package com.masai.java;

import java.util.ArrayList;

public class RentRunner {
	
	static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public static void main(String[] args) {
		Customer ramu = new Customer(2,"Shyam","hello","sasd",2);
		
		ramu.add();
		ramu.print();
	}

}
