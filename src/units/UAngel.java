package units;

public class UAngel extends Unit{

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
		
		this.setiHitPoints(this.iHitPointsBASE);
		
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
	
	// - Heal ally by DMG formula * 2; range 1, 2, 3
}
