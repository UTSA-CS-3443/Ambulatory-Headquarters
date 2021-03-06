package application.controller;

import application.Main;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.beans.binding.*;
import javafx.collections.*;

/**
 * This Class handles difficulty selection for the MainMenu.fxml. It also allows
 * for the loading of the next view
 * 
 * @author Classic Cannon
 *
 */
public class MainMenuController implements EventHandler<ActionEvent> {
	@FXML
	private Label turnCountLb;
	private Label notificationsLb;

	/**
	 * Easy difficulty
	 */
	public static boolean easyDiff;

	/**
	 * Medium difficulty
	 */
	public static boolean mediumDiff;

	/**
	 * Hard difficulty
	 */
	public static boolean hardDiff;

	/**
	 * Constructor to initialize all difficulties to false
	 */
	public MainMenuController() {
		super();
		easyDiff = false;
		mediumDiff = false;
		hardDiff = false;
	}

	@Override
	/**
	 * Handles selection of difficulty and loading of next view
	 */
	public void handle(ActionEvent event) {
		Button b = (Button) event.getSource();
		String text = b.getText();

		// choose difficulty by clicking buttons and altering booleans
		if (text.equals("EASY")) {
			easyDiff = true;
			mediumDiff = false;
			hardDiff = false;
			System.out.println("EASY!!");
		}

		if (text.equals("MEDIUM")) {
			mediumDiff = true;
			easyDiff = false;
			hardDiff = false;
			System.out.println("MEDIUM!!");
		}

		if (text.equals("HARD")) {
			hardDiff = true;
			easyDiff = false;
			mediumDiff = false;
			System.out.println("HARD!!");
		}

		// exits game
		if (text.equals("EXIT")) {
			Main.stage.close();
			System.out.println("Exit");
		}

		// loads MenuCharacterSelect.fxml only after user selects a difficulty and
		// clicks load
		if (text.equals("LOAD") && (easyDiff == true || mediumDiff == true || hardDiff == true)) {
			try {
				// change over to a second view
				Parent root = FXMLLoader.load(getClass().getResource("../view/MenuCharacterSelect.fxml")); // Load the
																											// FXML
				Main.stage.setScene(new Scene(root, 1280, 720)); // Add the scene to the stage
				Main.stage.show(); // Show the stage to the user
			} catch (Exception e) {
				e.printStackTrace(); // TODO: app should do something more productive if errors occur...
			}
		}
	}

}
