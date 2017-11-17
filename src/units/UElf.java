package units;

public class UElf extends Unit{
	
	private int iHitPointsBASE = 50;
	private int iAttackBASE = 20;
	private int iDefenseBASE = 5;
	private int iMobilityBASE = 3;
	
	private int iHitPointsINC = 10;
	private int iAttackINC = 20;
	private int iDefenseINC = 5;
	
	public UElf() {
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		this.addiATKRNG(2);
		
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
	
	// Level 1: Prayer to Alynn		- Single Target Heal
	// Level 3: Petrify				- CC
	// Levle 5: Wrath of Zaleria	- AoE Spell
	
	public String getName()
	{
		return "Elf";
	}
}
