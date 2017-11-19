package units;

public class UBabyDragon extends Unit{
	
	private int iHitPointsBASE = 25;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 30;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 50;
	private int iAttackINC = 30;
	private int iDefenseINC = 30;
	
	private int iSkillBase;

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
		
		this.setiSkillMod(iSkillBase);

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
	

	// Level 3: Land of Fire				- Search map for all enemies and do Damage * .5 mod to all enemies


}
