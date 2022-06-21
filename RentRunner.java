package com.masai.java;

import java.util.ArrayList;

public class RentRunner {
	
	static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public static void main(String[] args) {
		Customer ramu = new Customer(1,"Ramu","Y","Z",1);
		ramu.add();
		ramu.print();
	}

}
