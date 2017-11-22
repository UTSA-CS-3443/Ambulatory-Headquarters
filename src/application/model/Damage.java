package application.model;

import units.Unit;

public class Damage {
	public static int doDamage(Unit attacker, Unit defender) {
		int iModifier = 1;	
		int iLevelBonus = 5 * (attacker.getiLevel() - defender.getiLevel());
		int defaultPower = attacker.getiAttack() - defender.getiDefense();
		if (defaultPower <= 0) {
			defaultPower = 10;
		}
		int ratioAD = (2 * attacker.getiAttack()) / (defender.getiDefense() * 3);
		int iDamageDone = ((iLevelBonus + defaultPower)) * ratioAD * iModifier;
		int iMinDamage = 10 * iLevelBonus;
		
		if (iDamageDone <= 0) {
			defender.iHitPointsDown(iMinDamage);
			if (defender.getiHitPoints() < 0) {
				defender.setiHitPoints(0);
			}
			return iMinDamage;
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