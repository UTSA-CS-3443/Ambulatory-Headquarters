package application.model;

import units.Unit;

/**Damage class; handles anything to do with a unit taking or doing damage
 * 
 * @author Alec
 *
 */
/**The main damage formula. This is for basic attack (only attack currently implemented).
 * Damage formula takes into account level difference with a linear damage curve.
 * Minimum damage dealt is always 10. Not possible to do less than 10 damage.
 * 
 * @author Alec
 *
 */
public class Damage {
	public static int doDamage(Unit attacker, Unit defender) {
		int iModifier = 1;	
		int iLevelBonus = 5 * (attacker.getiLevel() - defender.getiLevel());
		if (iLevelBonus < 0){
			iLevelBonus = 1;	
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
	
	/**
	 * @param attacker Unit doing the attacking; method not implemented with our current combat system. This was supposed to be used more as a display notifier
	 */
	public void showAttackRange(Unit attacker) {
		
	}
}