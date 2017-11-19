package units;

public class UAngel extends Unit{

	private int iHitPointsBASE = 75;
	private int iAttackBASE = 20;
	private int iDefenseBASE = 25;
	private int iMobilityBASE = 5;
	
	private int iHitPointsINC = 25;
	private int iAttackINC = 25;
	private int iDefenseINC = 25;
	
	private int iSkill1Base;
	private int iSkill2Base;
	private int iSkill3Base;
	
	public UAngel() {
		this.setiUnitID(1);
		
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(2);
		this.addiATKRNG(3);
		
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
	
	// Level 1: Song of Serenity				- Increase ally Max HP by 20 
	// Level 3: Hymn of the Heavens				- Increase ally Max DEF by 20
	// Level 5: Mythical Harp					- AoE dmg 3x3, except for center
	
	public String getName()
	{
		return "Angel";
	}
}
