package application;

import java.io.Serializable;

public class Customer extends Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String userName, String passWord, String name, String surname, int age, Boolean gender,
			String email, String userID, int phoneNumber) {
		super(userName, passWord, name, surname, age, gender, email, userID, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return "customer";
	}
}
