package application.controller;

import application.Main;
import application.model.Damage;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private Label allyLb;
	@FXML
	private Label allyNameLb;
	@FXML
	private Label enemyLb;
	@FXML
	private Label enemyNameLb;
	@FXML
	private AnchorPane allyPane;
	@FXML
	private AnchorPane enemyPane;
	@FXML
	private GridPane mapPane;
	@FXML
	public Button prevClicked;
	@FXML
	public Button readyBtn;
	
	private Map map;
	private boolean ready;
	
	Unit selected;
	Unit selectedEnemy;
	Location selectedLocation;
	
	public int winning=0;
	public int currentLevel = 1;
	
	public MainController() 
	{
		super();
		ready = false;
		map = new Map();
		
	}
	public void handleReady(ActionEvent event)
	{
		ready = true;
		readyBtn.setVisible(false);
		processMap();
	}
	
	@Override
	public void handle(ActionEvent event) 
	{
		
		if(!ready)
		{
			notification("Not ready");
			return;
		}
			
		Button b = (Button)event.getSource();
		System.out.println(mapPane.getRowIndex(b) + "," + mapPane.getColumnIndex(b));
		String text = b.getText();
		processMap();
		
		if(selected == null)
		{
			if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) != null && map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly())
			{
				selected = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
				allyNameLb.setText(selected.getUnitName());
				allyLb.setText("HP: " + selected.getiHitPoints() + "\n" + 
								"Level: " + selected.getiLevel() + "\n" + 
								"Mobility: " + selected.getiMobility() + "\n" + 
								"Atk.: " + selected.getiAttack() + "\n" + 
								"Def.: " + selected.getiDefense());
				selectedLocation = new Location(map,mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
				prevClicked = b;
				System.out.println("prevClicked set");
			}
			if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) != null && map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly() == false)
			{
				selectedEnemy = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
				enemyNameLb.setText(selectedEnemy.getUnitName());
				enemyLb.setText("HP: " + selectedEnemy.getiHitPoints() + "\n" + 
								"Level: " + selectedEnemy.getiLevel() + "\n" + 
								"Mobility: " + selectedEnemy.getiMobility() + "\n" + 
								"Atk.: " + selectedEnemy.getiAttack() + "\n" + 
								"Def.: " + selectedEnemy.getiDefense());
				//selectedLocation = new Location(map,mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
				//prevClicked = b;
				//System.out.println("prevClicked set");
			}
		}
		else
		{
			if(map.move(selectedLocation.getRow(), selectedLocation.getCol(), mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) == 1)
			{
				notification(selected.getUnitName() + " moved from " + 
									selectedLocation.getRow()+", "+selectedLocation.getCol() + 
									" to " + mapPane.getRowIndex(b) + ", " + mapPane.getColumnIndex(b));
				System.out.println(selected.getUnitName() + " moved from " + 
									selectedLocation.getRow()+", "+selectedLocation.getCol() + 
									" to " + mapPane.getRowIndex(b) + ", " + mapPane.getColumnIndex(b));
				selected = null;
				processMap();
				prevClicked.setText(",");
				prevClicked = null;
				
				// Counting units to confirm a win
				if((mapPane.getRowIndex(b) == 10 && mapPane.getColumnIndex(b) == 14) || (mapPane.getRowIndex(b) == 11 && mapPane.getColumnIndex(b) == 15) 
					|| (mapPane.getRowIndex(b) == 11 && mapPane.getColumnIndex(b) == 14) || (mapPane.getRowIndex(b) == 10 && mapPane.getColumnIndex(b) == 15))  {
					System.out.println("YOU WIN");
					winning++;
					isWon(winning);
				}
			}
			if(map.move(selectedLocation.getRow(), selectedLocation.getCol(), mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) == 3)
			{
				notification("Too far: "+selected.getUnitName() + " can only move " + selected.getiMobility() + " blocks");
				selected = null;
				prevClicked = null;
			}
			if(map.move(selectedLocation.getRow(), selectedLocation.getCol(), mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) == 2)
			{
				if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly() == false)
				{
					if((Math.abs(selectedLocation.getRow()-mapPane.getRowIndex(b)) + Math.abs(selectedLocation.getCol()-mapPane.getColumnIndex(b))) <= selected.getiATKRNG().get(0))
					{
						notification(selected.getUnitName()+ " dealt "+Damage.doDamage(selected,map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)))+" damage to "+map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getUnitName());
						if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getiHitPoints() <= 0)
						{
							notification(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getUnitName() + " died");
							map.remove(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
							b.setText(",");
							processMap();
						}
						selected = null;
						prevClicked = null;						
					}
					else
						notification("Too far cannot attack");

				}
				if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly())
				{
					selected = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
					allyNameLb.setText(selected.getUnitName());
					allyLb.setText("HP: " + selected.getiHitPoints() + "\n" + 
									"Level: " + selected.getiLevel() + "\n" + 
									"Mobility: " + selected.getiMobility() + "\n" + 
									"Atk.: " + selected.getiAttack() + "\n" + 
									"Def.: " + selected.getiDefense());
					selectedLocation = new Location(map,mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
					prevClicked = b;
					
				}
				if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly() == false)
				{
					selectedEnemy = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
					enemyNameLb.setText(selectedEnemy.getUnitName());
					enemyLb.setText("HP: " + selectedEnemy.getiHitPoints() + "\n" + 
									"Level: " + selectedEnemy.getiLevel() + "\n" + 
									"Mobility: " + selectedEnemy.getiMobility() + "\n" + 
									"Atk.: " + selectedEnemy.getiAttack() + "\n" + 
									"Def.: " + selectedEnemy.getiDefense());
					//selectedLocation = new Location(map,mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
					//prevClicked = b;
					//System.out.println("prevClicked set");
				}
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
							 b.setText(map.get(i, j).getUnitName());
						 }
					}					
				}
				else
				{
					for(Node node : children)
					{
						 if(mapPane.getRowIndex(node) == i && mapPane.getColumnIndex(node) == j)
						 {
							 b = (Button)node;
							 b.setText("");
							 Image image = new Image("file:GrassTile.png");
							 ImageView iv = new ImageView(image);
							 iv.setLayoutX(0.0);
							 iv.setLayoutY(0.0);
							 iv.setFitHeight(45.0);
							 iv.setFitWidth(45.0);
							 b.setGraphicTextGap(0.0);
							 b.setGraphic(iv);
						 }
					}	
				}
			}
		}
	}
	public void notification(String s)
	{
		notificationsLb.setText(s+"\n"+notificationsLb.getText());
	}
	
	public void isWon(int winning) {
		if (winning == 3) {
			System.out.println("YOU WON THE GAME BOI");
			map.reset();
			currentLevel++;
			map.loadMap(currentLevel);
			processMap();
			winning=0;
		}
	}
	
}
