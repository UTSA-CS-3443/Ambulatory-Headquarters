package units;

import javafx.scene.image.Image;
import map.Map;

/**Holds all information for Orc
 * @author Alec
 *
 */
public class UOrc extends Unit{
	private Image image = new Image("file:Orc.png");
	
	private int iHitPointsBASE = 80;
	private int iAttackBASE = 80;
	private int iDefenseBASE = 60;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 40;
	private int iAttackINC = 20;
	private int iDefenseINC = 30;
	
	private int iSkillBase;
	private String sSkillName = "Bloodlust Ritual";
	
	public UOrc() {
		this.setiUnitID(10);
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
			this.setiMobility(this.iMobilityBASE + 2);
		}
		
		if (this.getiLevel() == 5) {
			this.setiMobility(this.iMobilityBASE + 4);
		}
	}

	@Override
	public void useSkill(Map map, int row, int col) {
		// TODO Auto-generated method stub
		
	}
	
	// Increase Attack and decrease defense

}
