package units;

public class UCake extends Unit{
	
	private int iHitPointsBASE = 100;
	private int iAttackBASE = 10;
	private int iDefenseBASE = 10;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 50;
	private int iAttackINC = 10;
	private int iDefenseINC = 10;
	
	public UCake() {
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
	// Level 2: Excess Frosting				- Adjacent slow
	// Level 3: Happy Birthday				- Adjacent heal

	public String getName()
	{
		return "Cake";
	}
}
