package units;

public class UNinja extends Unit{
	
	private int iHitPointsBASE = 50;
	private int iAttackBASE = 50;
	private int iDefenseBASE = 50;
	private int iMobilityBASE = 5;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 30;
	private int iDefenseINC = 25;
	
	private int iSkillBase;
	
	public UNinja() {
		this.setiUnitID(9);
		
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		
		this.setiMobility(this.iMobilityBASE);
		
		this.setbAlly(true);
		
		this.setiSkillMod(iSkillBase);
	}

	@Override
	public void iLevelInc() {
		this.iLevelUp();
		this.iHitPointsUp(iHitPointsINC);
		this.iAttackUp(this.iAttackINC);
		this.iDefenseUp(this.iDefenseINC);
		
		if (this.getiLevel() == 3) {
			this.setiMobility(this.iMobilityBASE + 2);
		}
		
		if (this.getiLevel() == 5) {
			this.setiMobility(this.iMobilityBASE + 4);
		}
	}
	
	// Level 5: Assassination Contract		- Set enemy defense to 0

}
