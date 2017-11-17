package units;

public class UAlien extends Unit{
	
	private int iHitPointsBASE = 50;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 20;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 20;
	private int iAttackINC = 25;
	private int iDefenseINC = 20;
	
	public UAlien() {
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
	}
	
	// Level 1: N/A
	// Level 3: Ray Gun					- Single Target DMG
	// Level 5: Call Spaceship			- Single Target global DMG
	
	public String getName()
	{
		return "Alien";
	}
}
