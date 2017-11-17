package application.controller;

import application.Main;
import application.model.Player;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.beans.binding.*;
import javafx.collections.*;

public class MainController implements EventHandler<ActionEvent> {
	@FXML
	private Label turnCountLb;
	private Label notificationsLb;
	
	public boolean easyDiff;
	public boolean mediumDiff;
	public boolean hardDiff;
	
	
	
	public MainController() {
		super();
		easyDiff =  false;
		mediumDiff = true;
		hardDiff = false;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		String text = b.getText();
		
		
	}
	
	
	
}
