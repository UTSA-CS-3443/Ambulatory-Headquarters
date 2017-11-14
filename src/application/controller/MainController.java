package application.controller;

import application.Main;
import application.model.Player;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class MainController  implements EventHandler<ActionEvent>
{
	@FXML
	private Label turnCountLb;
	private Label notificationsLb;
	
	public boolean easyDiff;
	public boolean mediumDiff;
	public boolean hardDiff;
	
	public MainController()
	{
		super();
	}
	@Override
	public void handle(ActionEvent event) 
	{
		Button b = (Button)event.getSource();
		String text = b.getText();
		
		
		//choose difficulty by clicking buttons and altering booleans
		if (text.equals("EASY")) {
			easyDiff = true;
			System.out.println("EASY!!");
		}
		
		if (text.equals("MEDIUM")) {
			easyDiff = true;
			System.out.println("MEDIUM!!");
		}
		
		if (text.equals("HARD")) {
			easyDiff = true;
			System.out.println("HARD!!");
		}
		
		// exits game
		if (text.equals("EXIT")) {
			Main.stage.close();
			System.out.println("Exit");
		}
		
		// loads MenuCharacterSelect.fxml only after user selects a difficulty and clicks load
		if (text.equals("LOAD") && (easyDiff == true || mediumDiff == true || hardDiff == true)) {
			try {
				// change over to a second view
				Parent root = FXMLLoader.load(getClass().getResource("../view/MenuCharacterSelect.fxml"));   // Load the FXML
				Main.stage.setScene(new Scene(root, 1600, 900));							   // Add the scene to the stage
				Main.stage.show();														   // Show the stage to the user
			}catch(Exception e) {
				e.printStackTrace(); // TODO: app should do something more productive if errors occur...
			}
		}
		
		// sends game back to MainMenu.fxml
		if (text.equals("<--Back")) {
			System.out.println("BACK!!");
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
				Scene scene = new Scene(root,1600,900);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.stage.setScene(scene);
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// starts game by loading MainGame.fxml
		if (text.equals("START!")) {
			System.out.println("START!!");
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/MainGame.fxml"));
				Scene scene = new Scene(root,1600,900);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.stage.setScene(scene);
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
