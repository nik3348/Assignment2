package application;


import java.io.Serializable;

public class Employee extends Users implements Serializable{

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String userName, String passWord, String name, String surname, int age, Boolean gender,
			String email, String userID, int phoneNumber) {
		super(userName, passWord, name, surname, age, gender, email, userID, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return "employee";
	}
}
