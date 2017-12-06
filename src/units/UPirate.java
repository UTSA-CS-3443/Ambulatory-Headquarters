package units;

import javafx.scene.image.Image;
import map.Map;

/**Holds all information for Pirate
 * @author Alec
 *
 */
public class UPirate extends Unit{
	private Image image = new Image("file:Pirate.png");
	
	private int iHitPointsBASE = 75;
	private int iAttackBASE = 40;
	private int iDefenseBASE = 35;
	private int iMobilityBASE = 5;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 20;
	private int iDefenseINC = 25;
	
	private int iSkillBase;
	private String sSkillName = "Ahoy!";
	
	public UPirate() {
		this.setiUnitID(11);
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
	
	// Single-Target Burst 2x, Range 1-2
}
