package units;

public class UCatBurglar extends Unit{
	
	private int iHitPointsBASE = 30;
	private int iAttackBASE = 30;
	private int iDefenseBASE = 10;
	private int iMobilityBASE = 5;
	
	private int iHitPointsINC = 15;
	private int iAttackINC = 15;
	private int iDefenseINC = 15;
	
	private int iSkillBase;
	private String sSkillName = "What's Yours, Is Mine";
	
	public UCatBurglar() {
		this.setiUnitID(4);
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		this.addiATKRNG(2);
		this.addiATKRNG(3);
		
		this.setiMobility(this.iMobilityBASE);
		
		this.setbAlly(true);
		
		this.setiSkillMod(iSkillBase);
		this.setsSkillName(sSkillName);
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
	
	// Steal 20 ATK, 20 DEF, 20HP from enemy



}
