package units;

import javafx.scene.image.Image;
import map.Map;

/**Holds all information for Ghost
 * @author Alec
 *
 */
public class UGhost extends Unit{
	private Image image = new Image("file:Ghost.png");
	
	private int iHitPointsBASE = 75;
	private int iAttackBASE = 20;
	private int iDefenseBASE = 30;
	private int iMobilityBASE = 5;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 20;
	private int iDefenseINC = 15;
	
	private int iSkillBase;
	private String sSkillName = "Ethereal (Passive)";
	
	public UGhost() {
		this.setiUnitID(6);
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
}
