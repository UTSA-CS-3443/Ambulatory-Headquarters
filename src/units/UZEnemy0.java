package units;

public class UZEnemy0 extends Unit{
	private int iHitPointsBASE = 50;
	private int iAttackBASE = 20;
	private int iDefenseBASE = 20;
	private int iMobilityBASE = 3;
	
	private int iHitPointsINC = 15;
	private int iAttackINC = 15;
	private int iDefenseINC = 15;
	
	private int iSkill1Base = 1;
	private int iSkill2Base =1;
	private int iSkill3Base = 1;
	
	public UZEnemy0() {
		this.setiUnitID(100);
		
		this.setiHitPoints(this.iHitPointsBASE);
		
		this.setiAttack(this.iAttackBASE);
		this.setiDefense(this.iDefenseBASE);
		
		this.addiATKRNG(1);
		
		this.setiMobility(this.iMobilityBASE);
		
		this.setbAlly(true);
		
		this.setiSkill1Mod(iSkill1Base);
		this.setiSkill2Mod(iSkill2Base);
		this.setiSkill3Mod(iSkill3Base);
	}
	
	public void iLevelInc() {
		this.iLevelUp();
		this.iHitPointsUp(0);
		this.iAttackUp(0);
		this.iDefenseUp(0);
		
		if (this.getiLevel() == 3) {
			this.setiMobility(this.iMobilityBASE + 0);
		}
	}

}
