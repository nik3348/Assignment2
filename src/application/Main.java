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
		    
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("application/application.css");
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
			
            if(!(new File("src/res/employees.txt").exists()))
            	writer = new PrintWriter("src/res/employees.txt");
            if(!(new File("src/res/customers.txt").exists()))
            	writer = new PrintWriter("src/res/customers.txt");
            if(!(new File("src/res/films.txt").exists()))
            	writer = new PrintWriter("src/res/films.txt");
            if(writer != null)
            	writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		launch(args);
	}
}
