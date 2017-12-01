package units;

import javafx.scene.image.Image;
import map.Map;

public class USpaceCowboy extends Unit{
	private Image image = new Image("file:SpaceCowboy.png");
	
	private int iHitPointsBASE = 100;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 10;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 50;
	private int iAttackINC = 20;
	private int iDefenseINC = 20;
	
	private int iSkillBase;
	private String sSkillName = "Wormhole";
	
	private boolean wormholeOpen = false;
	
	public USpaceCowboy() {
		this.setiUnitID(12);
		this.setUImage(image);
		
		this.setiMaxHitPoints(this.iHitPointsBASE);
		this.setiCurrHitPoints(this.getiMaxHitPoints());
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(2);
		this.addiATKRNG(3);
		this.addiATKRNG(4);
		
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
		
		if (this.getiLevel() == 5) {
			this.setiMobility(this.iMobilityBASE + 2);
		}
	}

	@Override
	public void useSkill(Map map, int row, int col) {
		// TODO Auto-generated method stub
		
	}
	
	// Level 5: Global TP

}
