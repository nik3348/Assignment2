package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SceneLoader {
	public static void loadScene (String sceneName) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource(sceneName));
		Main.setRoot(loader.load());
		Scene scene = new Scene(Main.getRoot());
		scene.getStylesheets().add("/scenes/application.css");
		Main.getPrimaryStage().setScene(scene);
		Main.getPrimaryStage().show();	
	}
}
