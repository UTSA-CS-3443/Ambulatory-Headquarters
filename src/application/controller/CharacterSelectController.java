package application.controller;

import java.util.ArrayList;

import application.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import units.UAlien;
import units.UAngel;
import units.UBabyDragon;
import units.UCake;
import units.UCatBurglar;
import units.UElf;
import units.UGhost;
import units.UKnight;
import units.ULunarOctopus;
import units.UNinja;
import units.UOrc;
import units.UPirate;
import units.USpaceCowboy;
import units.UTeddybear;
import units.UUndead;
import units.Unit;

public class CharacterSelectController implements EventHandler<ActionEvent> 
{
	@FXML
	CheckBox alienCb;
	@FXML
	CheckBox angelCb;
	@FXML
	CheckBox babyDragonCb;
	@FXML
	CheckBox cakeCb;
	@FXML
	CheckBox catBurglarCb;
	@FXML
	CheckBox elfCb;
	@FXML
	CheckBox ghostCb;
	@FXML
	CheckBox knightCb;
	@FXML
	CheckBox lunarOctopusCb;
	@FXML
	CheckBox ninjaCb;
	@FXML
	CheckBox orcCb;
	@FXML
	CheckBox pirateCb;
	@FXML
	CheckBox spaceCowboyCb;
	@FXML
	CheckBox teddyBearCb;
	@FXML
	CheckBox undeadCb;
	
	public static ArrayList<Unit> charList = new ArrayList<Unit>();
	
	public CharacterSelectController() 
	{
		super();
	}
	
	
	@Override
	public void handle(ActionEvent event) 
	{
		Button b = (Button)event.getSource();
		String text = b.getText();
		
		int unitCount = 0;
		
		int[] charS ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		//ArrayList<Unit> charList = new ArrayList<Unit>();		
		
		// sends game back to MainMenu.fxml
		if (text.equals("<--Back")) 
		{
			System.out.println("BACK!!");
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
				Scene scene = new Scene(root,1280,720);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.stage.setScene(scene);
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		//Alien
		if (alienCb.isSelected()) {
			unitCount++;
			charS[0] = 1;
			System.out.println("ALIEN"+unitCount);
		}
		else if (!alienCb.isSelected()) {
			charS[0] = 0;
		}
		
		//Angel
		if (angelCb.isSelected()) {
			unitCount++;
			charS[1] = 1;
			System.out.println("ANGEL"+unitCount);
		}
		else if (!angelCb.isSelected()) {
			charS[1] = 0;
		}
		
		//Baby Dragon
		if (babyDragonCb.isSelected()) {
			unitCount++;
			charS[2]=1;
			System.out.println("BABEDRAGON"+unitCount);
		}
		else if (!babyDragonCb.isSelected()) {
			charS[2] = 0;
		}
		
		//Cake
		if (cakeCb.isSelected()) {
			unitCount++;
			charS[3]=1;
			System.out.println("CAKE"+unitCount);
		}
		else if (!cakeCb.isSelected()) {
			charS[3] = 0;
		}
		
		//Cat Burglar
		if (catBurglarCb.isSelected()) {
			unitCount++;
			charS[4]=1;
			System.out.println("CATBURGLAR"+unitCount);
		}
		else if (!catBurglarCb.isSelected()) {
			charS[4] = 0;
		}
		
		//Elf
		if (elfCb.isSelected()) {
			unitCount++;
			charS[5]=1;
			System.out.println("ELF"+unitCount);
		}
		else if (!elfCb.isSelected()) {
			charS[5] = 0;
		}
		
		//Ghost
		if (ghostCb.isSelected()) {
			unitCount++;
			charS[6]=1;
			System.out.println("GHOST"+unitCount);
		}
		else if (!ghostCb.isSelected()) {
			charS[6] = 0;
		}
		
		//Knight
		if (knightCb.isSelected()) {
			unitCount++;
			charS[7]=1;
			System.out.println("KNIGHT"+unitCount);
		}
		else if (!knightCb.isSelected()) {
			charS[7] = 0;
		}
		
		//Lunar Octopus..whatever that is
		if (lunarOctopusCb.isSelected()) {
			unitCount++;
			charS[8]=1;
			System.out.println("LUNAR OCTOPUS"+unitCount);
		}
		else if (!lunarOctopusCb.isSelected()) {
			charS[8] = 0;
		}
		
		//Ninja
		if (ninjaCb.isSelected()) {
			unitCount++;
			charS[9]=1;
			System.out.println("NINJA"+unitCount);
		}
		else if (!ninjaCb.isSelected()) {
			charS[9] = 0;
		}
		
		//Orc
		if (orcCb.isSelected()) {
			unitCount++;
			charS[10]=1;
			System.out.println("ORC"+unitCount);
		}
		else if (!orcCb.isSelected()) {
			charS[10] = 0;
		}
		
		//Pirate
		if (pirateCb.isSelected()) {
			unitCount++;
			charS[11]=1;
			System.out.println("PIRATE"+unitCount);
		}
		else if (!pirateCb.isSelected()) {
			charS[11] = 0;
		}
		
		//Space Cowboy
		if (spaceCowboyCb.isSelected()) {
			unitCount++;
			charS[12]=1;
			System.out.println("SPACECOWBOY"+unitCount);
		}
		else if (!spaceCowboyCb.isSelected()) {
			charS[12] = 0;
		}
		
		//Teddy Bear
		if (teddyBearCb.isSelected()) {
			unitCount++;
			charS[13]=1;
			System.out.println("TEDDYBEAR"+unitCount);
		}
		else if (!teddyBearCb.isSelected()) {
			charS[13] = 0;
		}
		//Undead
		if (undeadCb.isSelected()) {
			unitCount++;
			charS[14]=1;
			System.out.println("UNDEAD"+unitCount);
		}
		else if (!undeadCb.isSelected()) {
			charS[14] = 0;
		}
		
		
		// starts game by loading MainGame.fxml
		if (text.equals("START!") && unitCount ==3) {
			//This is probably super inefficient but idc. It reads through charS and determines what characters
			//need to be created and added to arrayList of player selected characters
			for (int i=0; i<15; i++) {
				if(charS[0] == 1) {
					UAlien alien = new UAlien();
					charList.add(alien);
				}
				if(charS[1] == 1) {
					UAngel angel = new UAngel();
					charList.add(angel);
				}
				if(charS[2] == 1) {
					UBabyDragon babyDragon = new UBabyDragon();
					charList.add(babyDragon);
				}
				if(charS[3] == 1) {
					UCake cake = new UCake();
					charList.add(cake);
				}
				if(charS[4] == 1) {
					UCatBurglar catBurglar = new UCatBurglar();
					charList.add(catBurglar);
				}
				if(charS[5] == 1) {
					UElf elf = new UElf();
					charList.add(elf);
				}
				if(charS[6] == 1) {
					UGhost ghost = new UGhost();
					charList.add(ghost);
				}
				if(charS[7] == 1) {
					UKnight knight = new UKnight();
					charList.add(knight);
				}
				if(charS[8] == 1) {
					ULunarOctopus lunarOctopus = new ULunarOctopus();
					charList.add(lunarOctopus);
				}
				if(charS[9] == 1) {
					UNinja ninja = new UNinja();
					charList.add(ninja);
				}
				if(charS[10] == 1) {
					UOrc orc = new UOrc();
					charList.add(orc);
				}
				if(charS[11] == 1) {
					UPirate pirate= new UPirate();
					charList.add(pirate);
				}
				if(charS[12] == 1) {
					USpaceCowboy spaceCowboy = new USpaceCowboy();
					charList.add(spaceCowboy);
				}
				if(charS[13] == 1) {
					UTeddybear teddyBear= new UTeddybear();
					charList.add(teddyBear);
				}
				if(charS[14] == 1) {
					UUndead undead = new UUndead();
					charList.add(undead);
				}
				System.out.printf("%d", charS[i]);
			}
			System.out.println("\nSTART!!");
			System.out.println(charList);
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/MainGame.fxml"));
				Scene scene = new Scene(root,1280,720);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.stage.setScene(scene);
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (text.equals("START!") && (unitCount < 3 || unitCount > 3)) {
			System.out.println("ONLY SELECT 3 UNITS");
		}
	}

}
