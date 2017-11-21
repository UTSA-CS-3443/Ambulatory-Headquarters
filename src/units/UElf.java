package units;

import javafx.scene.image.Image;
import map.Map;

public class UElf extends Unit{
	private Image image = new Image("file:knighttest.png");
	
	private int iHitPointsBASE = 50;
	private int iAttackBASE = 20;
	private int iDefenseBASE = 5;
	private int iMobilityBASE = 3;
	
	private int iHitPointsINC = 10;
	private int iAttackINC = 20;
	private int iDefenseINC = 5;
	
	private int iSkillBase = 2;
	private String sSkillName = "Prayer to Alynn";
	
	public UElf() {
		this.setiUnitID(5);
		this.setUImage(image);
		
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		this.addiATKRNG(2);
		
		this.setiMobility(this.iMobilityBASE);
		
		this.setbAlly(true);
		
		this.setiSkillMod(iSkillBase);
		this.setsSkillName(sSkillName);
	}

	@Override
	public void iLevelInc() {
		this.iLevelUp();
		this.iHitPointsUp(iHitPointsINC);
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
	
	// Level 1: Prayer to Alynn		- Single Target Heal Dmg * 2 mod
	
}
