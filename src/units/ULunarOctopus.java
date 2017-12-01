package units;

import javafx.scene.image.Image;
import map.Map;

public class ULunarOctopus extends Unit{
	private Image image = new Image("file:LunarOctopus.png");

	private int iHitPointsBASE = 50;
	private int iAttackBASE = 50;
	private int iDefenseBASE = 10;
	private int iMobilityBASE = 4;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 30;
	private int iDefenseINC = 15;
	
	private int iSkillBase;
	private String sSkillName = "Lunar Tide";
	
	public ULunarOctopus() {
		this.setiUnitID(8);
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
	
	//- Heal all adjacent allies
	
}
