package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * This class handles teh end game views, specifically the endGame.fxml and
 * GameOver.fxml. This allows the player to quit the game when they either win
 * or lose the game.
 * 
 * @author Classic Cannon
 *
 */
public class EndController {
	public void handle(ActionEvent event) {
		Button b = (Button) event.getSource();
		String text = b.getText();

		if (text.equals("Quit")) {
			Main.stage.close();
			System.out.println("Exit");
		}
	}
}
