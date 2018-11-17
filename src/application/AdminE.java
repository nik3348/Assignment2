package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdminE {
	public static void main(String [] args) {
		 FileOutputStream f;
		 ObjectOutputStream o;
		 
		 Employee e1 = new Employee("123", "123", "e123", "e", 123, true, "123@123.com", "123", 123);
		 Employee e2 = new Employee("456", "456", "e456", "e", 456, true, "456@456.com", "456", 0456);
		try {
			f = new FileOutputStream(new File("res/files/employees.txt"));
			o = new ObjectOutputStream(f);

			o.writeObject(e1);
			o.writeObject(e2);
			
			f.close();
			o.close();
			
			FileInputStream fi = new FileInputStream(new File("res/files/employees.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Employee pr1 = (Employee) oi.readObject();
			Employee pr2 = (Employee) oi.readObject();

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
