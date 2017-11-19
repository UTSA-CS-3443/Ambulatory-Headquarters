package units;

import java.util.ArrayList;

public abstract class Unit {
	private String[] allyList = {"Alien",	"Angel",	"Baby Dragon",	"Cake",				"CatBUrglar",
								"Elf",		"Ghost",	"Knight",		"Lunar Octopus",	"Ninja",
								"Orc",		"Pirate",	"Space Cowboy",	"Teddybear",		"Undead",
								"Enemy 1",	"Enemy 2", 	"Enemy 3"};
	private int iUnitID;
	private int iLevel = 1;
	private int iHitPoints;
	private int iAttack;
	private int iDefense;
	private ArrayList<Integer> iATKRNG = new ArrayList<Integer>();;
	private int iMobility;
	private boolean bAlly;
	private boolean bEnemy;
	
	private int iATKSlot = 0; // reg attack = 0, skills = 1,2,3 respectively
	private int iSkill1Mod;
	private int iSkill2Mod;
	private int iSkill3Mod;
	
	
	
	// UNIT ID METHOD
	public String getUnitName() {	
		return this.allyList[this.iUnitID];
	}
	
	public void setiUnitID(int unitID) {
		this.iUnitID = unitID;
	}
	
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
	
	// ATTACK SLOT METHOD
	public int getiATKSlot() {
		return this.iATKSlot;
	}
	
	// SKILL MOD METHODS
	public int getiSkill1Mod() {
		return this.iSkill1Mod;
	}
	
	public void setiSkill1Mod(int mod) {
		this.iSkill1Mod = mod;
	}
	
	public int getiSkill2Mod() {
		return this.iSkill2Mod;
	}
	
	public void setiSkill2Mod(int mod) {
		this.iSkill2Mod = mod;
	}
	
	public int getiSkill3Mod() {
		return this.iSkill3Mod;
	}
	
	public void setiSkill3Mod(int mod) {
		this.iSkill3Mod = mod;
	}
}
