/**
 * 
 * Vivian Thach (33939402) Diana Sandil (10443456)
 * 
 * CrapsMetricsMonitor: Contains all the game statistics
 * of a single simulation.  The user can reset the simulation
 * after completing one.
 *
 */

import java.util.Scanner;

public class CrapsMetricsMonitor {
	
	// Private variables: gamesPlayed, gamesWon, gamesLost, maxRoll,
	// naturalRollCount, crapsRollCount, maxWinStreak, maxLoseStreak,
	// maxBalance, gameOfMaxBalance
	// These variables are passed into the constructor.
	
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int maxRoll;
	private int naturalRollCount;
	private int crapsRollCount;
	private int maxWinStreak;
	private int maxLoseStreak;
	private double maxBalance;
	private int gameOfMaxBalance;
	
	// CrapsMetricsMonitor constructor to initialize all private variables.
	// This will also monitor the total number of: games played/won/lost,
	// the maximum amount of rolls, natural/craps roll count, the winning/losing
	// streak, the max balance and the game that had the max balance. 
	
	public CrapsMetricsMonitor() {
		gamesPlayed = 0;
		gamesWon = 0;
		gamesLost = 0;
		maxRoll = 0;
		naturalRollCount = 0;
		crapsRollCount = 0;
		maxWinStreak = 0;
		maxLoseStreak = 0;
		maxBalance = 0;
		gameOfMaxBalance = 0;
	}
	
	// Prints out the simulation statistics for all the games that have been played
	public void printStatistics() {
		System.out.println("*****************************");
		System.out.println("*** SIMULATION STATISTICS ***");
		System.out.println("*****************************");
		System.out.println("Games played: " + gamesPlayed);
		System.out.println("Games won: " + gamesWon);
		System.out.println("Games lost: " + gamesLost);
		System.out.println("Maximum Rolls in a single game: " + maxRoll);
		System.out.println("Natural Count: " + naturalRollCount);
		System.out.println("Craps Count: " + crapsRollCount);
		System.out.println("Maximum Winning Streak: " + maxWinStreak);
		System.out.println("Maximum Losing Streak: " + maxLoseStreak);
		System.out.println("Maximum balance: " + maxBalance + " during game " + gameOfMaxBalance);
		System.out.println();
	}
	
	// This sets gamesPlayed, gamesWon, gamesLost, maxRoll, naturalRollCount, crapsRollCount
	// maxWinStreak, maxLoseStreak to 0 if the user wishes to play the game again.
	
	public void reset() {
		gamesPlayed = 0;
		gamesWon = 0;
		gamesLost = 0;
		maxRoll = 0;
		naturalRollCount = 0;
		crapsRollCount = 0;
		maxWinStreak = 0;
		maxLoseStreak = 0;
		maxBalance = 0;
		gameOfMaxBalance = 0;
	}
	
	// Starting from here, this will be all the increment methods for:
	// gamesPlayed, gamesWon, gamesLost, naturalRollCount, and crapsRollCount
	
	public void incGamesPlayed(){
		gamesPlayed++;
	}
	
	public void incGamesWon(){
		gamesWon++;
	}
	
	public void incGamesLost(){
		gamesLost++;
	}
	
	public void incNaturalRollCount(){
		naturalRollCount++;
	}
	
	public void incCrapsRollCount(){
		crapsRollCount++;
	}
	
	// Starting from here, this will be all the setter methods for private variables
	
	public void setMaxRoll(int max){
		maxRoll = max;
	}
	
	public void setMaxWinStreak(int streak){
		maxWinStreak = streak;
	}
	
	public void setMaxLoseStreak(int streak){
		maxLoseStreak = streak;
	}
	
	public void setMaxBalance(double bal){
		maxBalance = bal;
	}
	
	public void setGameOfMaxBalance(int game){
		gameOfMaxBalance = game;
	}
	
	// Starting from here, this will be all the get methods for private variables
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
	
	public int getGamesLost() {
		return gamesLost;
	}
	
	public int getNaturalRollCount() {
		return naturalRollCount;
	}
	
	public int getCrapsRollCount() {
		return crapsRollCount;
	}
	
	public int getMaxRoll() {
		return maxRoll;
	}
	
	public int getMaxWinStreak() {
		return maxWinStreak;
	}
	
	public int getMaxLoseStreak() {
		return maxLoseStreak;
	}
	
	public double getMaxBalance() {
		return maxBalance;
	}
	
	public int getGameOfMaxBalance() {
		return gameOfMaxBalance;
	}
}
