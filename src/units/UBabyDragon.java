package units;

public class UBabyDragon extends Unit{
	
	private int iHitPointsBASE = 25;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 30;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 50;
	private int iAttackINC = 30;
	private int iDefenseINC = 30;
	
	private int iSkill1Base;
	private int iSkill2Base;
	private int iSkill3Base;
	
	public UBabyDragon() {
		this.setiUnitID(2);
		
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		this.addiATKRNG(2);
		this.addiATKRNG(3);
		
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
			this.setiMobility(this.iMobilityBASE + 2);
		}
		
		if (this.getiLevel() == 5) {
			this.setiMobility(this.iMobilityBASE + 4);
		}
	}
	
	// Level 1: Fireball				- 3 Adjacent DMG
	// Level 3: Ray Gun					- Single Target DMG
	// Level 5: Whelp			- Single Target global DMG

}
