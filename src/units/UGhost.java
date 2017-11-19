package units;

public class UGhost extends Unit{
	
	private int iHitPointsBASE = 75;
	private int iAttackBASE = 20;
	private int iDefenseBASE = 30;
	private int iMobilityBASE = 5;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 20;
	private int iDefenseINC = 15;
	
	private int iSkillBase;
	private String sSkillName = "Ethereal (Passive)";
	
	public UGhost() {
		this.setiUnitID(6);
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		
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
			this.setiMobility(this.iMobilityBASE + 1);
		}
	}
}
