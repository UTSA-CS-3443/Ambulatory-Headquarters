package units;

public class UUndead extends Unit{

	private int iHitPointsBASE = 50;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 20;
	private int iMobilityBASE = 1;
	
	private int iHitPointsINC = 50;
	private int iAttackINC = 30;
	private int iDefenseINC = 20;
	
	public UUndead() {
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
			this.setiMobility(this.iMobilityBASE + 2);
		}
		
		if (this.getiLevel() == 5) {
			this.setiMobility(this.iMobilityBASE + 4);
		}
	}
	
	// Level 1: From the grave				- 3 Adjacent DMG
	// Level 3: Scavenge					- Self-heal 50%
	// Level 5: Army of the Undead			- 3x3 frontal attack
	
	public String getName()
	{
		return "Undead";
	}
}
