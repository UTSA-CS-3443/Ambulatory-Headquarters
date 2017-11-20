package units;

import java.util.ArrayList;

import javafx.scene.image.Image;
import map.Map;

public abstract class Unit {
	private String[] allyList = {"Alien",	"Angel",	"Baby Dragon",	"Cake",				"CatBUrglar",
								"Elf",		"Ghost",	"Knight",		"Lunar Octopus",	"Ninja",
								"Orc",		"Pirate",	"Space Cowboy",	"Teddybear",		"Undead",
								"Wall",		"Enemy 1",	"Enemy 2",		"Enemy 3",			"Enemy 4"};
	private int iUnitID;
	private int iLevel = 1;
	private int iHitPoints;
	private int iAttack;
	private int iDefense;
	private ArrayList<Integer> iATKRNG = new ArrayList<Integer>();;
	private int iMobility;
	private boolean bAlly;
	private boolean bEnemy;
	
	private String sSkillName;
	private int iATKSlot = 0; // reg attack = 0, skills = 1
	private int iSkillMod = 1;
	
	private boolean iAttackCounter = true;
	private boolean iMoveCounter = true;
	
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
	
	public void iHitPointsDown(int minusHitPoints) {
		this.iHitPoints -= minusHitPoints;
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
	public void setsSkillName(String skillName) {
		this.sSkillName = skillName;
	}
	
	public int getiSkillMod() {
		return this.iSkillMod;
	}
	
	public void setiSkillMod(int mod) {
		this.iSkillMod = mod;
	}
	
	public abstract void useSkill(Map map, int row, int col);
	
	// Attack and Move counter METHODS
	public void resetCounters() {
		this.iAttackCounter = true;
		this.iMoveCounter = true;
	}
	
	public boolean getiAttackCounter() {
		return this.iAttackCounter;
	}
	
	public boolean getiMoveCounter() {
		return this.iMoveCounter;
	}
	
	public void noMoreAttacks() {
		this.iAttackCounter = false;
	}
	
	public void noMoreMoves() {
		this.iMoveCounter = false;
	}


}
