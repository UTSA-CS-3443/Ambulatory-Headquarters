package application.controller;

import application.Main;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import map.Map;
import javafx.beans.binding.*;
import javafx.collections.*;

public class MainController implements EventHandler<ActionEvent> 
{
	@FXML
	private Label turnCountLb;
	@FXML
	private Label notificationsLb;
	@FXML
	private AnchorPane allyPane;
	@FXML
	private AnchorPane enemyPane;
	@FXML
	private GridPane mapPane;
	@FXML
	public Button zero;
	
	private Map map;
	
	public MainController() 
	{
		super();
		map = new Map();
		
	}
	
	@Override
	public void handle(ActionEvent event) 
	{
		Button b = (Button)event.getSource();
		String text = b.getText();
		System.out.println(text);
		processMap();
		zero.setText("done");
	}
	
	public void processMap()
	{
		ObservableList<Node> children = mapPane.getChildren();
		Button b;
		for(int i = 0; i < map.getRow(); i++)
		{
			for(int j = 0; j < map.getCol(); j++)
			{
				if(map.get(i, j) != null)
				{
					for(Node node : children)
					{
						 if(mapPane.getRowIndex(node) == i && mapPane.getColumnIndex(node) == j)
						 {
							 b = (Button)node;
							 b.setText(map.get(i, j).getName());
						 }
					}					
				}
			}
		}
	}
}
