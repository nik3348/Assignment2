package application;
	
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	static Stage primaryStage;
	static Parent root;
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}

	public static Parent getRoot() {
		return root;
	}

	public static void setRoot(Parent root) {
		Main.root = root;
	}

	
	@Override
	public void start(Stage primaryStage) {
		try {
			Main.primaryStage = primaryStage;
			root = FXMLLoader.load(getClass().getResource("/scenes/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/scenes/application.css");
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PrintWriter writer = null;
		try {
			
            if(!(new File("res/files/employees.txt").exists()))
            	writer = new PrintWriter("res/files/employees.txt");
            if(!(new File("res/files/customers.txt").exists()))
            	writer = new PrintWriter("res/customers.txt");
            if(!(new File("res/files/films.txt").exists()))
            	writer = new PrintWriter("res/files/films.txt");
            if(writer != null)
            	writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		launch(args);
	}
}
