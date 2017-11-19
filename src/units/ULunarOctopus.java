package units;

public class ULunarOctopus extends Unit{

	private int iHitPointsBASE = 50;
	private int iAttackBASE = 50;
	private int iDefenseBASE = 10;
	private int iMobilityBASE = 4;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 30;
	private int iDefenseINC = 15;
	
	private int iSkillBase;
	
	public ULunarOctopus() {
		this.setiUnitID(8);
		
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(2);
		this.addiATKRNG(3);
		this.addiATKRNG(4);
		
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
		
		if (this.getiLevel() == 5) {
			this.setiMobility(this.iMobilityBASE + 2);
		}
	}
	
	// Level 3: Lunar Tide					- Heal all adjacent allies
	
}
