package units;

import javafx.scene.image.Image;
import map.Map;

public class UCake extends Unit{
	private Image image = new Image("file:Cake.png");
	
	private int iHitPointsBASE = 100;
	private int iAttackBASE = 10;
	private int iDefenseBASE = 10;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 50;
	private int iAttackINC = 10;
	private int iDefenseINC = 10;
	
	private int iSkillBase;
	private String sSkillName = "Takes the Cake";
	
	public UCake() {
		this.setiUnitID(3);
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
		// TODO Auto-generated method stub
		
	}
	
	// Adjacent heal

}
