package application.controller;

import java.util.ArrayList;
import java.util.Random;

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
	public int turnCount = 0;
	
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
		String text = b.getText();
		
		if(selected == null)
		{
			if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) != null && map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly())
			{
				selected = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
				allyNameLb.setText(selected.getUnitName());
				allyLb.setText("HP: " + selected.getiMaxHitPoints() + "\n" + 
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
				enemyLb.setText("HP: " + selectedEnemy.getiMaxHitPoints() + "\n" + 
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
				turnCount++;
				turnCountLb.setText("Turn Count: " + turnCount);
				isWon();
				notification(selected.getUnitName() + " moved from " + 
									selectedLocation.getRow()+", "+selectedLocation.getCol() + 
									" to " + mapPane.getRowIndex(b) + ", " + mapPane.getColumnIndex(b));
				System.out.println(selected.getUnitName() + " moved from " + 
									selectedLocation.getRow()+", "+selectedLocation.getCol() + 
									" to " + mapPane.getRowIndex(b) + ", " + mapPane.getColumnIndex(b));
				ememyTurn();
				selected = null;
				prevClicked.setText("");
				prevClicked = null;
				
				// Counting units to confirm a win
				// Denoting spaces to confirm a win for each level
				if (currentLevel == 1) {
					if((mapPane.getRowIndex(b) == 10 && mapPane.getColumnIndex(b) == 14) || (mapPane.getRowIndex(b) == 11 && mapPane.getColumnIndex(b) == 15) 
							|| (mapPane.getRowIndex(b) == 11 && mapPane.getColumnIndex(b) == 14) || (mapPane.getRowIndex(b) == 10 && mapPane.getColumnIndex(b) == 15))  {
						System.out.println("YOU Entered a win space");
						map.remove(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
						winning++;
						isWon();
					}
				}
				
				if (currentLevel == 2) {
					if((mapPane.getRowIndex(b) == 0 && mapPane.getColumnIndex(b) == 15) || (mapPane.getRowIndex(b) == 0 && mapPane.getColumnIndex(b) == 14) 
							|| (mapPane.getRowIndex(b) == 1 && mapPane.getColumnIndex(b) == 15) || (mapPane.getRowIndex(b) == 1 && mapPane.getColumnIndex(b) == 14))  {
						System.out.println("YOU Entered a win space");
						map.remove(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
						winning++;
						isWon();
					}
				}
				
				if (currentLevel == 3) {
					if((mapPane.getRowIndex(b) == 10 && mapPane.getColumnIndex(b) == 15) || (mapPane.getRowIndex(b) == 10 && mapPane.getColumnIndex(b) == 14) 
							|| (mapPane.getRowIndex(b) == 11 && mapPane.getColumnIndex(b) == 15))  {
						System.out.println("YOU Entered a win space");
						map.remove(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
						winning++;
						isWon();
					}
				}
				
				if (currentLevel == 4) {
					if((mapPane.getRowIndex(b) == 0 && mapPane.getColumnIndex(b) == 15) || (mapPane.getRowIndex(b) == 0 && mapPane.getColumnIndex(b) == 14) 
							|| (mapPane.getRowIndex(b) == 1 && mapPane.getColumnIndex(b) == 15) || (mapPane.getRowIndex(b) == 1 && mapPane.getColumnIndex(b) == 14))  {
						System.out.println("YOU Entered a win space");
						map.remove(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
						winning++;
						isWon();
					}
				}
				
				if (currentLevel == 5) {
					if((mapPane.getRowIndex(b) == 10 && mapPane.getColumnIndex(b) == 15) || (mapPane.getRowIndex(b) == 10 && mapPane.getColumnIndex(b) == 14) 
							|| (mapPane.getRowIndex(b) == 11 && mapPane.getColumnIndex(b) == 15))  {
						System.out.println("YOU Entered a win space");
						map.remove(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
						winning++;
						isWon();
					}
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
				if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) != null && map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly() == false)
				{
					if(selectedLocation != null && (Math.abs(selectedLocation.getRow()-mapPane.getRowIndex(b)) + Math.abs(selectedLocation.getCol()-mapPane.getColumnIndex(b))) <= selected.getiATKRNG().get(0))
					{
						turnCount++;
						turnCountLb.setText("Turn Count: " + turnCount);
						isWon();
						
						if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getUnitName().equals("Wall"))
						{
							notification("Can't attack a wall");
						}
						else
						{
							notification(selected.getUnitName()+ " dealt "+Damage.doDamage(selected,map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)))+" damage to "+map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getUnitName());
							if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getiMaxHitPoints() <= 0)
							{
								notification(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getUnitName() + " died");
								map.remove(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
								processMap();
							}
							selected = null;
							prevClicked = null;								
						}
					
					}
					else
						notification("Too far cannot attack");

				}
				if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) != null && map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly())
				{
					selected = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
					allyNameLb.setText(selected.getUnitName());
					allyLb.setText("HP: " + selected.getiMaxHitPoints() + "\n" + 
									"Level: " + selected.getiLevel() + "\n" + 
									"Mobility: " + selected.getiMobility() + "\n" + 
									"Atk.: " + selected.getiAttack() + "\n" + 
									"Def.: " + selected.getiDefense());
					selectedLocation = new Location(map,mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
					prevClicked = b;
					
					if (map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getiMaxHitPoints() <= 0) {
						System.out.println("Ally Died");
						String s = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).getUnitName();
						notification(s+" Died");
						map.remove(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
						processMap();
						allyGameOver();
						//
						//
						//
					}
				}
				if(map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)) != null && map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b)).isbAlly() == false)
				{
					selectedEnemy = map.get(mapPane.getRowIndex(b), mapPane.getColumnIndex(b));
					enemyNameLb.setText(selectedEnemy.getUnitName());
					enemyLb.setText("HP: " + selectedEnemy.getiMaxHitPoints() + "\n" + 
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
		int currentIndex = 0;
		for(int i = 0; i < map.getRow(); i++)
		{
			for(int j = 0; j < map.getCol(); j++)
			{
				b = (Button)children.get(currentIndex);
				b.setText("");
				if(map.get(i, j) != null)
				{
					b.setStyle("-fx-focus-color: transparent;");
					BackgroundImage backgroundImage = new BackgroundImage(map.get(i, j).getImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
					b.setFocusTraversable(false);
					b.setBackground(new Background(backgroundImage));
				}
				else if(currentLevel == 1 && ((i == 10 && j == 14) || (i == 11 && j == 14) || (i == 10 && j == 15) || (i == 11 && j == 15)))
				{
					Image image = new Image("file:WinTile.png");
					b.setStyle("-fx-focus-color: transparent;");
					BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
					b.setFocusTraversable(false);
					b.setBackground(new Background(backgroundImage));
				}
				else if(currentLevel == 2 && ((i == 0 && j == 14) || (i == 1 && j == 14) || (i == 0 && j == 15) || (i == 1 && j == 15)))
				{
					Image image = new Image("file:WinTile.png");
					b.setStyle("-fx-focus-color: transparent;");
					BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
					b.setFocusTraversable(false);
					b.setBackground(new Background(backgroundImage));
				}
				else if(currentLevel == 3 && ((i == 10 && j == 14) || (i == 11 && j == 14) || (i == 10 && j == 15) || (i == 11 && j == 15)))
				{
					Image image = new Image("file:WinTile.png");
					b.setStyle("-fx-focus-color: transparent;");
					BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
					b.setFocusTraversable(false);
					b.setBackground(new Background(backgroundImage));
				}
				else if(currentLevel == 4 && ((i == 0 && j == 14) || (i == 1 && j == 14) || (i == 0 && j == 15) || (i == 1 && j == 15)))
				{
					Image image = new Image("file:WinTile.png");
					b.setStyle("-fx-focus-color: transparent;");
					BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
					b.setFocusTraversable(false);
					b.setBackground(new Background(backgroundImage));
				}
				else if(currentLevel == 5 && ((i == 10 && j == 14) || (i == 11 && j == 14) || (i == 10 && j == 15) || (i == 11 && j == 15)))
				{
					Image image = new Image("file:WinTile.png");
					b.setStyle("-fx-focus-color: transparent;");
					BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
					b.setFocusTraversable(false);
					b.setBackground(new Background(backgroundImage));
				}
				else
				{
					Image image = new Image("file:GrassTile.png");
					b.setStyle("-fx-focus-color: transparent;");
					BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
					b.setFocusTraversable(false);
					b.setBackground(new Background(backgroundImage));
				}
				currentIndex++;
			}
		}
	}
	public void notification(String s)
	{
		notificationsLb.setText(s+"\n"+notificationsLb.getText());
	}
	
	/**
	 * Checks to see if the player has won the game. It keeps track of how many players have entered
	 * a win zone. It is dependent on how many players are still alive. If player wins level, it proceeds to next level.
	 * If player wins final level, it ends game. If player reaches 100 turns it results in game over
	 */
	public void isWon() {
		int numberDead=0;
		int numToWin=0;
		for (int i=0; i<3; i++) {
			if (CharacterSelectController.charList.get(i).getiMaxHitPoints() == 0)
				numberDead++;
		}
		if (numberDead == 0)
			numToWin = 3;
		else if (numberDead == 1)
			numToWin = 2;
		else if (numberDead == 2)
			numToWin = 1;
		if (winning == numToWin) {
			System.out.println("YOU WON THE LEVEL winning:" +winning+" numToWin: "+numToWin);
			map.reset();
			currentLevel++;
			if (currentLevel >= 6) {
				try {
					// change over to a second view
					Parent root = FXMLLoader.load(getClass().getResource("../view/endGame.fxml"));   // Load the FXML
					Main.stage.setScene(new Scene(root, 1280, 720));							   // Add the scene to the stage
					Main.stage.show();														   // Show the stage to the user
				}catch(Exception e) {
					e.printStackTrace(); // TODO: app should do something more productive if errors occur...
				}
			}
			else {
				map.loadMap(currentLevel);
				processMap();
				winning=0;
				turnCount = 0;
				turnCountLb.setText("Turn Count: " + turnCount);
			}
		}
		else if (winning != numToWin && turnCount >= 100) {
			System.out.println("Game Over");
			try {
				// change over to a second view
				Parent root = FXMLLoader.load(getClass().getResource("../view/GameOver.fxml"));   // Load the FXML
				Main.stage.setScene(new Scene(root, 1280, 720));							   // Add the scene to the stage
				Main.stage.show();														   // Show the stage to the user
			}catch(Exception e) {
				e.printStackTrace(); // TODO: app should do something more productive if errors occur...
			}
		}
	}
	
	public void ememyTurn()
	{
		for(int r = 0; r < map.getRow(); r++)
		{
			for(int c = 0; c < map.getCol(); c++)
			{
				boolean attacked = false;
				if(map.get(r, c) != null && map.get(r, c).getUnitName().contains("Enemy"))
				{
					boolean[][] moveable = map.moveable(map.getMatrix(), r, c, map.get(r, c).getiMobility());
					ArrayList<Location> list = new ArrayList<Location>();
					for(int i = map.firstTrue.getRow(); i <= map.lastTrue.getRow(); i++)
					{
						for(int j = map.firstTrue.getCol(); j <= map.lastTrue.getCol(); j++)
						{
							if(moveable[i][j])
								list.add(new Location(map,i,j));
						}
					}
					for(int x = 0; x < list.size(); x++)
					{
						if(map.get(list.get(x).getRow(), list.get(x).getCol()) != null && map.get(list.get(x).getRow(), list.get(x).getCol()).isbAlly())
						{
							int range = (Math.abs(r-list.get(x).getRow())+Math.abs(c-list.get(x).getCol()));
							if(range <= map.get(r,c).getiATKRNG().get(0))
							{
								notification(map.get(r, c).getUnitName()+" attacks "+map.get(list.get(x).getRow(), list.get(x).getCol()).getUnitName()+" dealing " + Damage.doDamage(map.get(r, c), (map.get(list.get(x).getRow(), list.get(x).getCol())))+" damage");
								attacked = true;
								break;
							}
						}
					}
					if(!attacked && list.size() > 0)
					{
						Random rand = new Random();
						int random = rand.nextInt(list.size());
						map.move(r, c, list.get(random).getRow(), list.get(random).getCol());
						//notification("Enemy moved from "+r+","+c+" to "+list.get(random).getRow()+","+list.get(random).getCol());
					}
				}
			}
		}
		processMap();
	}
	
	/**
	 * Checks to see how many allys are alive. If all 3 are dead, it results in game over
	 */
	public void allyGameOver() {
		int numberDead=0;
		for (int i=0; i<3; i++) {
			if (CharacterSelectController.charList.get(i).getiMaxHitPoints() == 0)
				numberDead++;
		}
		if (numberDead >=3) {
			System.out.println("Game Over via ally death " + numberDead);
			try {
				// change over to a second view
				Parent root = FXMLLoader.load(getClass().getResource("../view/GameOver.fxml"));   // Load the FXML
				Main.stage.setScene(new Scene(root, 1280, 720));							   // Add the scene to the stage
				Main.stage.show();														   // Show the stage to the user
			}catch(Exception e) {
				e.printStackTrace(); // TODO: app should do something more productive if errors occur...
			}
		}
	}
}
