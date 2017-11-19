package application.controller;

import application.Main;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import map.*;
import units.*;
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
	public Button prevClicked;
	
	private Map map;
	
	Unit selected;
	Location selectedLocation;
	
	public MainController() 
	{
		super();
		map = new Map();
		
	}
	public void handleReady(ActionEvent event)
	{
		processMap();
	}
	
	@Override
	public void handle(ActionEvent event) 
	{
		Button b = (Button)event.getSource();
		System.out.println(mapPane.getRowIndex(b) + "," + mapPane.getColumnIndex(b));
		String text = b.getText();
		processMap();
		
		if(selected == null)
		{
			selected = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
			selectedLocation = new Location(map,mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
			prevClicked = b;
			System.out.println("prevClicked set");
		}
		else
		{
			if(map.move(selectedLocation.getRow(), selectedLocation.getCol(), mapPane.getRowIndex(b), mapPane.getColumnIndex(b)))
			{
				System.out.println(selected.getName() + " moved from " + 
									selectedLocation.getRow()+", "+selectedLocation.getCol() + 
									" to " + mapPane.getRowIndex(b) + ", " + mapPane.getColumnIndex(b));
				selected = null;
				processMap();
				prevClicked.setText(",");
				prevClicked = null;
			}
		}
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
