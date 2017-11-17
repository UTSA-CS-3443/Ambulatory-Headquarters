package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CharacterSelectController implements EventHandler<ActionEvent> 
{
	
	public CharacterSelectController() 
	{
		super();
	}
	
	
	@Override
	public void handle(ActionEvent event) 
	{
		Button b = (Button)event.getSource();
		String text = b.getText();
		
		// sends game back to MainMenu.fxml
		if (text.equals("<--Back")) 
		{
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
		if (text.equals("START!")) 
		{
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
