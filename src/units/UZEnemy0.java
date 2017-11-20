package units;

import javafx.scene.image.Image;
import map.Map;

public class UZEnemy0 extends Unit{
	private Image image = new Image("file:Enemy1.PNG");
	
	private int iHitPointsBASE = 50;
	private int iAttackBASE = 20;
	private int iDefenseBASE = 20;
	private int iMobilityBASE = 3;
	
	private int iHitPointsINC = 15;
	private int iAttackINC = 15;
	private int iDefenseINC = 15;
	
	private int iSkillBase = 1;

	public UZEnemy0() {
		this.setiUnitID(16);
		this.setUImage(image);
		
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		
		this.setiMobility(this.iMobilityBASE);
		
		this.setbAlly(false);
		
		this.setiSkillMod(iSkillBase);
	}
	
	public void iLevelInc() {
		this.iLevelUp();
		this.iHitPointsUp(0);
		this.iAttackUp(0);
		this.iDefenseUp(0);
		
		if (this.getiLevel() == 3) {
			this.setiMobility(this.iMobilityBASE + 0);
		}
	}

	@Override
	public void useSkill(Map map, int row, int col) {
		// TODO Auto-generated method stub
		
	}

}
