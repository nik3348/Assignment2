package application;


import java.io.Serializable;

public class Users implements Serializable {

	private String userName;
	private String passWord;
	private String name;
	private String surname;
	private int age;
	private Boolean gender;
	private String email;
	private String userID;
	private int phoneNumber;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String userName, String passWord, String name, String surname, int age, Boolean gender, String email,
			String userID, int phoneNumber) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.userID = userID;
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return "users";
	}
}
