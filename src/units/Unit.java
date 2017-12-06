package units;

import java.util.ArrayList;

import javafx.scene.image.Image;
import map.Map;

/**Unit abstract class has all stats and images for ally and enemy units.
 * Has getters and setters.
 * @author Alec
 *
 */
public abstract class Unit {
	private String[] allyList = {"Alien",	"Angel",	"Baby Dragon",	"Cake",				"Cat Burglar",
								"Elf",		"Ghost",	"Knight",		"Lunar Octopus",	"Ninja",
								"Orc",		"Pirate",	"Space Cowboy",	"Teddybear",		"Undead",
								"Wall",		"Enemy 1"};
	private int iUnitID;
	private Image image;
	
	private int iLevel = 1;
	private int iMaxHitPoints;
	private int iCurrHitPoints;
	private int iAttack;
	private int iDefense;
	private ArrayList<Integer> iATKRNG = new ArrayList<Integer>();;
	private int iMobility;
	private boolean bAlly;
	
	private String sSkillName;
	private int iATKSlot = 0; // reg attack = 0, skills = 1
	private int iSkillMod = 1;
	
	private boolean iAttackCounter = true;
	private boolean iMoveCounter = true;
	
	// UNIT ID METHOD
	/**
	 * @return Unit's name
	 */
	public String getUnitName() {	
		return this.allyList[this.iUnitID];
	}
	
	/**
	 * @param unitID Book-keeping unit ID to match arrays
	 */
	public void setiUnitID(int unitID) {
		this.iUnitID = unitID;
	}
	
	// UNIT IMAGE
	/**
	 * @return Unit's image
	 */
	public Image getImage() {
		return this.image;
	}
	
	/**
	 * @param uImage Image to assign to unit
	 */
	public void setUImage(Image uImage) {
		this.image = uImage;
	}
	
	// LEVEL METHODS
	/**
	 * @return Unit's level
	 */
	public int getiLevel() {
		return this.iLevel;
	}
	
	/**
	 * abstract method on how the unit levels up (stat increases)
	 */
	public abstract void iLevelInc();
	
	/**
	 * Increases unit's level by 1
	 */
	public void iLevelUp() {
		this.iLevel++;
	}
	
	// HP METHODS
	/**
	 * @return Unit's max HP capacity
	 */
	public int getiMaxHitPoints() {
		return iMaxHitPoints;
	}
	
	/**
	 * @return Unit's current HP as a result of combat
	 */
	public int getiCurrHitPoints() {
		return iCurrHitPoints;
	}
	
	/**
	 * @param iHitPoints Sets unit's max HP capacity
	 */
	public void setiMaxHitPoints(int iHitPoints) {
		this.iMaxHitPoints = iHitPoints;
	}
	
	/**
	 * @param iHitPoints re-assign unit's current HP; used by damage class
	 */
	public void setiCurrHitPoints(int iHitPoints) {
		this.iCurrHitPoints = iHitPoints;
	}
	
	/**
	 * @param addHitPoints amount to increase HP capacity
	 */
	public void iMaxHitPointsUp(int addHitPoints) {
		this.iMaxHitPoints += addHitPoints;
	}
	
	/**
	 * @param addHitPoints amount to increase current HP (ie. heal)
	 */
	public void iCurrHitPointsUp(int addHitPoints) {
		this.iCurrHitPoints += addHitPoints;
	}
	
	/**
	 * @param minusHitPoints amount to decrease unit's HP capacity; potential if skills were ever implemented 
	 */
	public void iMaxHitPointsDown(int minusHitPoints) {
		this.iMaxHitPoints -= minusHitPoints;
	}
	
	/**
	 * @param minusHitPoints amount to decrease current HP
	 */
	public void iCurrHitPointsDown(int minusHitPoints) {
		this.iCurrHitPoints -= minusHitPoints;
	}
	
	/**
	 * fully heals unit to HP capacity; called at the start of each level
	 */
	public void fullHeal() {
		this.iCurrHitPoints = this.iMaxHitPoints;
	}
	
	// ATTACK METHODS
	/**
	 * @return Unit's attack power
	 */
	public int getiAttack() {
		return iAttack;
	}
	/**
	 * @param iAttack Desired attack power
	 */
	public void setiAttack(int iAttack) {
		this.iAttack = iAttack;
	}
	/**
	 * @param addATKPoints amount to increase attack power
	 */
	public void iAttackUp(int addATKPoints) {
		this.iAttack += addATKPoints;
	}
	
	// DEFENSE METHODS
	/**
	 * @return Unit's defense stat
	 */
	public int getiDefense() {
		return iDefense;
	}
	/**
	 * @param iDefense Desired defense stat
	 */
	public void setiDefense(int iDefense) {
		this.iDefense = iDefense;
	}
	/**
	 * @param addDEFPoints amount to increase defense stat
	 */
	public void iDefenseUp(int addDEFPoints) {
		this.iDefense += addDEFPoints;
	}
	
	// ATTACK RANGE METHODS
	/**
	 * @return Array of all possible attack ranges
	 */
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
	/**
	 * @return Unit's mobility; number of squares able to move per turn
	 */
	public int getiMobility() {
		return iMobility;
	}
	/**
	 * @param iMobility set desired mobility
	 */
	public void setiMobility(int iMobility) {
		this.iMobility = iMobility;
	}
	/**
	 * @param addMOVPoints amount to increase mobility
	 */
	public void iMobilityUp(int addMOVPoints) {
		this.iMobility += addMOVPoints;//
	}
	
	// ALLY METHODS
	/**
	 * @return true if unit is an ally
	 */
	public boolean isbAlly() {
		return bAlly;
	}
	/**
	 * @param b set desired type of unit (true for ally)
	 */
	public void setbAlly(boolean b) {
		this.bAlly = b;
	}
	
	// ATTACK SLOT METHOD
	/**
	 * @return integer for which attack to use. Multiple attacks not implemented.
	 */
	public int getiATKSlot() {
		return this.iATKSlot;
	}
	
	// SKILL MOD METHODS
	/**
	 * @param skillName set's desired skill name; skills not implemented
	 */
	public void setsSkillName(String skillName) {
		this.sSkillName = skillName;
	}
	
	/**
	 * @return multiplier for skill to be used in damage class; skill not implemented
	 */
	public int getiSkillMod() {
		return this.iSkillMod;
	}
	
	/**
	 * @param mod sets skill's damage modifier
	 */
	public void setiSkillMod(int mod) {
		this.iSkillMod = mod;
	}
	
	/**
	 * skills not implemented. potential to check allies/enemies in range of skills
	 * @param map Main Game's map
	 * @param row	row coordinate of unit
	 * @param col	column coordinate unit
	 */
	public abstract void useSkill(Map map, int row, int col);
	
	// Attack and Move counter METHODS
	/**
	 * Method created to keep track of a different type of combat; not implemented
	 */
	public void resetCounters() {
		this.iAttackCounter = true;
		this.iMoveCounter = true;
	}
	
	/**
	 * @return true if still able to attack; not implemented
	 */
	public boolean getiAttackCounter() {
		return this.iAttackCounter;
	}
	
	/**
	 * @return true if still able to move; not implemented
	 */
	public boolean getiMoveCounter() {
		return this.iMoveCounter;
	}
	
	/**
	 * set ability to attack on current turn to false; not implemented
	 */
	public void noMoreAttacks() {
		this.iAttackCounter = false;
	}
	
	/**
	 * set ability to move on current turn to false; not implemented
	 */
	public void noMoreMoves() {
		this.iMoveCounter = false;
	}

}
