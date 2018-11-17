package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Admin {
	public static void main(String [] args) {		 
		 Customer c1 = new Customer("789", "789", "c789", "c", 789, true, "789@789.com", "789", 678);
		 Customer c2 = new Customer("321", "321", "c321", "c", 321, true, "321@321.com", "321", 0321);
		 
		try {
			FileOutputStream f = new FileOutputStream(new File("src/res/customers.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(c1);
			o.writeObject(c2);
			
			System.out.println(c1.getUserName());
			
			o.close();
			f.close();
			
			FileInputStream fi = new FileInputStream(new File("src/res/customers.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Customer pr1 = (Customer) oi.readObject();
			Customer pr2 = (Customer) oi.readObject();

			System.out.println(pr1.getUserName());
			System.out.println(pr2.getUserName());

			oi.close();
			fi.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
