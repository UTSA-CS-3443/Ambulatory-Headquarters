package units;

public class ULunarOctopus extends Unit{

	private int iHitPointsBASE = 50;
	private int iAttackBASE = 50;
	private int iDefenseBASE = 10;
	private int iMobilityBASE = 4;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 30;
	private int iDefenseINC = 15;
	
	private int iSkill1Base;
	private int iSkill2Base;
	private int iSkill3Base;
	
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
		
		this.setiSkill1Mod(iSkill1Base);
		this.setiSkill2Mod(iSkill2Base);
		this.setiSkill3Mod(iSkill3Base);
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
	
	// Level 1: High Tide					- Heal adjacent 2x2 
	// Level 3: Ooze						- Destroy 1 wall
	// Level 5: Moonbeam					- 1x3 AoE
	
}
