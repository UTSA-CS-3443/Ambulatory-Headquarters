package application.model;

import units.Unit;

public class Damage {
	public static int doDamage(Unit attacker, Unit defender) {
		int iModifier = 1;	
		int iLevelBonus = 5 * (attacker.getiLevel() - defender.getiLevel());
		if (iLevelBonus < 0){
			iLevelBonus = 0;
		}
		int defaultPower = attacker.getiAttack() - defender.getiDefense();
		if (defaultPower <= 0) {
			defaultPower = 10;
		}
		//int ratioAD = (3 * attacker.getiAttack()) / (defender.getiDefense() * 4);
		int iDamageDone = ((iLevelBonus + defaultPower)) * iModifier;
		int iMinDamage = 10 * iLevelBonus;
		
		if (iDamageDone <= 0) {
			defender.iCurrHitPointsDown(iMinDamage);
			if (defender.getiCurrHitPoints() < 0) {
				defender.setiCurrHitPoints(0);
			}
			return iMinDamage;
		}
		else {
			defender.iCurrHitPointsDown(iDamageDone);
			if (defender.getiCurrHitPoints() < 0) {
				defender.setiCurrHitPoints(0);
			}
			return iDamageDone;
		}
		
		
	}
	
	public void showAttackRange(Unit attacker) {
		
	}
}