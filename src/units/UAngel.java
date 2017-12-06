package units;

import javafx.scene.image.Image;
import map.Map;

/**Holds all information for Angel
 * 
 * @author Alec
 *
 */
public class UAngel extends Unit{
	private Image image = new Image("file:Angel.png");
	
	private int iHitPointsBASE = 75;
	private int iAttackBASE = 20;
	private int iDefenseBASE = 25;
	private int iMobilityBASE = 5;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 25;
	private int iDefenseINC = 25;
	
	private int iSkillBase;
	private String sSkillName = "Song of Clarity";
	
	public UAngel() {
		this.setiUnitID(1);
		this.setUImage(image);
		
		this.setiMaxHitPoints(this.iHitPointsBASE);
		this.setiCurrHitPoints(this.getiMaxHitPoints());
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(2);
		this.addiATKRNG(3);
		
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
	
	// - Heal ally by DMG formula * 2; range 1, 2, 3
}
