package units;

public class UOrc extends Unit{
	
	private int iHitPointsBASE = 80;
	private int iAttackBASE = 80;
	private int iDefenseBASE = 60;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 40;
	private int iAttackINC = 20;
	private int iDefenseINC = 30;
	
	private int iSkill1Base;
	private int iSkill2Base;
	private int iSkill3Base;
	
	public UOrc() {
		this.setiUnitID(10);
		
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
	
	// Level 1: Pummel				- Single-Target Burst
	// Level 3: Bloodlust Ritual	- Increase Attack and decrease defense
	// Level 5: Warborn Pact		- Sacrifice 50% remaining HP to increase Attack for 5 turns

	public String getName()
	{
		return "Orc";
	}
}
