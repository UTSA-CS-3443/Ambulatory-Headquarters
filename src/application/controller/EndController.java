package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class EndController {
	public void handle(ActionEvent event)
	{
		Button b = (Button)event.getSource();
		String text = b.getText();
		
		if (text.equals("Quit")) {
			Main.stage.close();
			System.out.println("Exit");
		}
	}
}
