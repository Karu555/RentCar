package com.masai.java;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int bill;
	
	public Customer()
	{
		super();
	}
	
	public Customer(int id, String aadhar, String name, String contact_no, int bill) {
		super(id, aadhar, name, contact_no);
		this.bill =bill;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Customer [bill=" + bill + ", id=" + id + ", aadhar=" + aadhar + ", name=" + name + ", contact_no="
				+ contact_no + "]";
	}

	public static ArrayList<Customer> searchByName(String name)
	{
		ArrayList<Customer> customerList = Customer.View();
		
		ArrayList<Customer> s = new ArrayList<>();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).name.equalsIgnoreCase(name)) {
                s.add(customerList.get(i));
            }
        }
        return s;
	}
	
	
	public static Customer searchByAadhar(String aadhar)
	{

		ArrayList<Customer> customerList = Customer.View();
		
		for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).aadhar.equalsIgnoreCase(aadhar)) {
                return customerList.get(i);
            }
        }
        return null;
	}
	
	
	
	public static Customer searchByID(int id)
	{
		
		
		ArrayList<Customer> customerList = Customer.View();
		
		
		for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).id == id) {
                return customerList.get(i);
            }
        }
        return null;
	}
	
	

	@Override
	public void add() {
		ArrayList<Customer> customerList = Customer.View();
		
		if (customerList.isEmpty()) {
            this.id = 1;
        } else {
            this.id = customerList.get((customerList.size() - 1)).id + 1; // Auto ID...
        }
		
//		System.out.println("yhi hai");
		
		System.out.println(this.toString());
		
		customerList.add(this);
		
		File file = new File("Customer.txt");
		System.out.println("created");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
            for (int i = 0; i < customerList.size(); i++) {
                outputStream.writeObject(customerList.get(i));
            }
        } 
        catch (FileNotFoundException ex) {
            System.out.println(ex);
        } 
        catch (IOException ex) {
            System.out.println(ex);
        } 
        finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
	}

	
	@Override
	public void update() {
		ArrayList<Customer> customers = Customer.View();

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).id == this.id) {
                customers.set(i, this);
            }
        }

        // code for writing new Customer record 
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Customer.txt"));
            for (int i = 0; i < customers.size(); i++) {
                outputStream.writeObject(customers.get(i));
            }
        } 
        
        catch (FileNotFoundException ex) {
            System.out.println(ex);
        } 
        
        catch (IOException ex) {
            System.out.println(ex);
        } 
        
        finally {
            
        	if (outputStream != null) {
                
            	try {
                    outputStream.close();
                } 
                catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        	
        }
        
        
	}
	
	
	

	@Override
	public void remove() {
		ArrayList<Customer> customers = Customer.View();

        // for loop for deleting the required Customer
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).id == this.id) {
                customers.remove(i);
            }
        }

        // code for writing new Customer record 
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Customer.txt"));
            for (int i = 0; i < customers.size(); i++) {
                outputStream.writeObject(customers.get(i));
            }
        } 
        
        catch (FileNotFoundException ex) {
            System.out.println(ex);
        } 
        
        catch (IOException ex) {
            System.out.println(ex);
        } 
        
        finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
        
	}

	
	
	
	
	@Override
	public void print() {
//		ArrayList<Customer> customerList = RentRunner.customerList ;
		ArrayList<Customer> customerList = Customer.View();
		
		for(Customer c : customerList)
		{
			System.out.println(c);
		}
	}
	
	
	public static ArrayList<Customer> View() {
		
        ArrayList<Customer> CustomerList = new ArrayList<>(0);
        
        ObjectInputStream inputStream = null;
        try {
        	// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Customer.txt"));
            boolean EOF = false;
            
            // Keep reading file until file ends
            while (!EOF) {
                try {
                    Customer myObj = (Customer) inputStream.readObject();
                    CustomerList.add(myObj);
                } 
                catch (ClassNotFoundException e) {
                    System.out.println(e);
                } 
                catch (EOFException end) {
                    EOF = true;
                }
            }
        } 
        
        catch (FileNotFoundException e) {
            System.out.println(e);
        } 
        
        catch (IOException e) {
            System.out.println(e);
        } 
        
        finally {
            
        	try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } 
            
            catch (IOException e) {
                System.out.println(e);
            }
        }
        
        return CustomerList;
    }
	

}
