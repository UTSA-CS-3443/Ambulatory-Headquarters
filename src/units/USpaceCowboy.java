package units;

public class USpaceCowboy extends Unit{
	
	private int iHitPointsBASE = 100;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 10;
	private int iMobilityBASE = 2;
	
	private int iHitPointsINC = 50;
	private int iAttackINC = 20;
	private int iDefenseINC = 20;
	
	private int iSkillBase;
	
	private boolean wormholeOpen = false;
	
	public USpaceCowboy() {
		this.setiUnitID(12);
		
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
	
	// Level 5: Wormhole			- Create wormhole anywhere on map. Only 1 wormhole can be opened at a time.

}
