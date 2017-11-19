package units;

public class UAlien extends Unit{
	
	private int iHitPointsBASE = 50;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 20;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 20;
	private int iAttackINC = 25;
	private int iDefenseINC = 20;
	
	private int iSkillBase = 2;
	
	public UAlien() {
		this.setiUnitID(0);
		
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
			this.setiMobility(this.iMobilityBASE + 1);
		}
	}
	
	// Level 3: Ray Gun					- Single Target 3x
}
