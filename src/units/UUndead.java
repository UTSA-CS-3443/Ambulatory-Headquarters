package units;

import javafx.scene.image.Image;
import map.Map;

/**Holds all information for Undead
 * @author Alec
 *
 */
public class UUndead extends Unit{
	private Image image = new Image("file:Undead.png");

	private int iHitPointsBASE = 50;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 20;
	private int iMobilityBASE = 1;
	
	private int iHitPointsINC = 50;
	private int iAttackINC = 30;
	private int iDefenseINC = 20;
	
	private int iSkillBase;
	private String sSkillName = "Scavenge";
	
	public UUndead() {
		this.setiUnitID(14);
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
	
	// Level 3: Scavenge					- Self-heal 50% of max HP
	
}
