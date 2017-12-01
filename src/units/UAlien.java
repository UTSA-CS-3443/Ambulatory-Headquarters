package units;

import map.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class UAlien extends Unit{
		private Image image = new Image("file:Alien.png");
	
	private int iHitPointsBASE = 50;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 20;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 20;
	private int iAttackINC = 25;
	private int iDefenseINC = 20;
	
	private int iSkillBase = 2;
	private String sSkillName = "Ray Gun";
	
	public UAlien() {
		this.setiUnitID(0);
		this.setUImage(image);
		
		this.setiMaxHitPoints(this.iHitPointsBASE);
		this.setiCurrHitPoints(this.getiMaxHitPoints());
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		
		this.setiMobility(this.iMobilityBASE);
		
		this.setbAlly(true);
		
		this.setiSkillMod(iSkillBase);
		this.setsSkillName(sSkillName);
	}

	@Override
	public void iLevelInc() {
		this.iLevelUp();
		this.iCurrHitPointsUp(iHitPointsINC);
		this.iAttackUp(this.iAttackINC);
		this.iDefenseUp(this.iDefenseINC);
		
		if (this.getiLevel() == 3) {
			this.setiMobility(this.iMobilityBASE + 1);
		}
	}
	
	@Override
	public void useSkill(Map map, int row, int col) {
		if(map.get(row, col).isbAlly() == false) {
			// 2x mod
		}
		
	}
}
