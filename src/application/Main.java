package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;

/**
 * 
 * @author Classic Cannon
 *
 */
public class Main extends Application {
	public static Stage stage;

	/**
	 * loads the main menu
	 */
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/MainMenu.fxml"));
			Scene scene = new Scene(root,1280,720);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.stage = primaryStage;
		
		

	}
	
	/**
	 * starts the game
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
