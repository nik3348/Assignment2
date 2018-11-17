package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;

public class LoginController implements Initializable{

	Users currentUser;
	static HashSet<Employee> employees = new HashSet<Employee>();
	static HashSet<Customer> customers = new HashSet<Customer>();
	//static HashSet<Film> films = new HashSet<Film>();
	
    @FXML
    private TextField passWord;

    @FXML
    private Button newUser;

    @FXML
    private TextField userName;

    @FXML
    private Button login;

    @FXML
    private Text textSignIn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Employee> load(String file) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		FileInputStream fi;
		ObjectInputStream oi;
		try {
			 fi = new FileInputStream(new File("src/res/" + file));
			 oi = new ObjectInputStream(fi);
		
			while (true) {
				System.out.println("reading");
				Employee obj = (Employee) oi.readObject();
			    list.add(obj);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Good");
		
		for (Object s : list) {

            if (file.contains("employees"))
                employees.add((Employee) s);
            else if (file.contains("customers"))
                customers.add((Customer) s);
            else if (file.contains("films")) {
                //films.add( new Film ((String) s, (String) item.get("description"), (String) item.get("trailer"), (String) item.get("startDate"), (String) item.get("endDate"), times));
            }
            /*else if (file.contains("bookings")) {
                String customerUsername = Encryption.decrypt((String) item.get("username"));
                bookings.add(new BookingHistoryItem((String) item.get("status"), customerUsername,
                        getCustomerByUsername(customerUsername).getFirstName(), getCustomerByUsername(customerUsername).getLastName(),
                        (String) item.get("film"), (String) item.get("date"),
                        (String) item.get("time"), (String) item.get("seat"), (String) (s)));
            }*/
        }
		
		return list;
	}
	
	public void login(ActionEvent event) {		
		Window owner = login.getScene().getWindow();
		Boolean wrongCredentials = true;
		
		if(userName.getText().isEmpty()) {
            AlertHelper.showAlert(AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your name");
            return;
        }
		if(passWord.getText().isEmpty()) {
            AlertHelper.showAlert(AlertType.ERROR, owner, "Form Error!", 
                    "Please enter a password");
            return;
        }
		
		load("employees.txt");
		//load("customers.txt");
		ArrayList<Users> users = new ArrayList<Users>();
		users.addAll(employees);
		users.addAll(customers);
		System.out.println(users);
		
		for(Users u: users) {
			System.out.println(u.getUserName() + u.getPassWord());
			if(userName.getText().equals(u.getUserName()) && passWord.getText().equals(u.getPassWord())) {
				wrongCredentials = false;
				if(u.getType().equals("employee")) {
					
				}
				AlertHelper.showAlert(AlertType.ERROR, owner, "Form Error!", 
	                    "Logged IN");
	            return;
			}
			else {
				wrongCredentials = true;
				System.out.println("Go to sleep");
			}
		}
		if(wrongCredentials == true) {
			AlertHelper.showAlert(AlertType.ERROR, owner, "Form Error!", 
                    "Wrong Username or Password");
            return;
		}
	}
}
