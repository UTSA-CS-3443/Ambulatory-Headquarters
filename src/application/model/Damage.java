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
		return ((iLevelBonus * defaultPower) + 2) * ratioAD * iModifier;
	}
	
	public void showAttackRange(Unit attacker) {
		
	}
}