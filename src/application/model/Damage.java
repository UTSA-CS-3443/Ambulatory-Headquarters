package application.model;

import units.Unit;

public class Damage {
	public static int doDamage(Unit attacker, Unit defender) {
		int iModifier = 1;
		if (attacker.getiATKSlot() == 0) {
			iModifier = 1;
		}
		
		int iLevelBonus = 2 * attacker.getiLevel() / 5 + 2;
		int defaultPower = 10;
		int ratioAD = attacker.getiAttack() / defender.getiDefense();
		int iDamageDone = ((iLevelBonus * defaultPower) + 2) * ratioAD * iModifier;
		defender.iHitPointsDown(iDamageDone);
		return iDamageDone;
		
	}
	
	public void showAttackRange(Unit attacker) {
		
	}
}