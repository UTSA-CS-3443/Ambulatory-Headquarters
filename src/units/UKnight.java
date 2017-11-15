package units;

public class UKnight extends Unit{
	
	private int iHitPointsBASE = 100;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 50;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 20;
	private int iDefenseINC = 25;
	
	public UKnight() {
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		
		this.setiMobility(this.iMobilityBASE);
		
		this.setbAlly(true);
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
	
	// Level 1: Knight's Honor				- Reduce dmg by 50%
	// Level 3: Into the Fray				- Boost Adjacent Ally Mobility by 1
	// Level 5: Excalibur					- AoE in cross in any of 4 directions

}