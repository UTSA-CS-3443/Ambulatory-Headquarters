package application.model;

import units.Unit;

public class Damage {
	public static int doDamage(Unit attacker, Unit defender) {
		int iModifier = 1;	
		int iLevelBonus = 2 * attacker.getiLevel() / 5 + 2;
		int defaultPower = 10;
		int ratioAD = attacker.getiAttack() / defender.getiDefense();
		int iDamageDone = ((iLevelBonus * defaultPower) + 2) * ratioAD * iModifier;
		
		if (iDamageDone <= 0) {
			defender.iHitPointsDown(1);
			if (defender.getiHitPoints() < 0) {
				defender.setiHitPoints(0);
			}
			return 1;
		}
		else {
			defender.iHitPointsDown(iDamageDone);
			if (defender.getiHitPoints() < 0) {
				defender.setiHitPoints(0);
			}
			return iDamageDone;
		}
		
		
	}
	
	public void showAttackRange(Unit attacker) {
		
	}
}