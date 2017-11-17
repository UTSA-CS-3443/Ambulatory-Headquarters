package units;

import java.util.ArrayList;

public abstract class Unit {
	private int iLevel = 1;
	private int iHitPoints;
	private int iAttack;
	private int iDefense;
	private ArrayList<Integer> iATKRNG = new ArrayList<Integer>();;
	private int iMobility;
	private boolean bAlly;
	private boolean bEnemy;
	
	public abstract String getName();
	
	// LEVEL METHODS
	public int getiLevel() {
		return this.iLevel;
	}
	
	public abstract void iLevelInc();
	
	public void iLevelUp() {
		this.iLevel++;
	}
	
	// HP METHODS
	public int getiHitPoints() {
		return iHitPoints;
	}
	public void setiHitPoints(int iHitPoints) {
		this.iHitPoints = iHitPoints;
	}
	
	public void iHitPointsUp(int addHitPoints) {
		this.iHitPoints += addHitPoints;
	}
	
	// ATTACK METHODS
	public int getiAttack() {
		return iAttack;
	}
	public void setiAttack(int iAttack) {
		this.iAttack = iAttack;
	}
	public void iAttackUp(int addATKPoints) {
		this.iHitPoints += addATKPoints;
	}
	
	// DEFENSE METHODS
	public int getiDefense() {
		return iDefense;
	}
	public void setiDefense(int iDefense) {
		this.iDefense = iDefense;
	}
	public void iDefenseUp(int addDEFPoints) {
		this.iHitPoints += addDEFPoints;
	}
	
	// ATTACK RANGE METHODS
	public ArrayList<Integer> getiATKRNG() {
		return iATKRNG;
	}
	/**
	 * @param iATKRNG Method to add attack ranges. Attack ranges stored in an array.
	 */
	public void addiATKRNG(int iATKRNG) {
		this.iATKRNG.add(iATKRNG);
	}
	
	// MOBILITY METHODS
	public int getiMobility() {
		return iMobility;
	}
	public void setiMobility(int iMobility) {
		this.iMobility = iMobility;
	}
	public void iMobilityUp(int addMOVPoints) {
		this.iHitPoints += addMOVPoints;
	}
	
	// ALLY METHODS
	public boolean isbAlly() {
		return bAlly;
	}
	public void setbAlly(boolean b) {
		this.bAlly = b;
	}
	
	// ENEMY METHODS
	public boolean isbEnemy() {
		return bEnemy;
	}
	public void setbEnemy(boolean b) {
		this.bEnemy = b;
	}
}
