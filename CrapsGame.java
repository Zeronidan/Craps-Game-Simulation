/**
 * Vivian Thach (33939402) Diana Sandil (10443456)
 * 
 *  CrapsGame: Class that represents all the information
 *  for a SINGLE craps game.  Has the algorithm for the 
 *  actual game.
 *
 */

import java.util.ArrayList;
import java.util.Random;
public class CrapsGame {
	// Private variables: numRolls and CrapsMetricsMonitor object
	// that is passed into the constructor
	
	private int numRolls;
	private CrapsMetricsMonitor stats;
	//Static variables to store rolls for craps and natural
	private static ArrayList<Integer> craps = new ArrayList<Integer>(3);
	private static ArrayList<Integer> natural = new ArrayList<Integer>(2);
	
	// CrapsGame constructor to set numRolls in game to 0 and
	// this monitor to the simulation's monitor
	public CrapsGame(CrapsMetricsMonitor monitor){
		numRolls = 0;
		stats = monitor;
		craps.add(2);
		craps.add(3);
		craps.add(12);
		natural.add(7);
		natural.add(11);
	}
	
	// Plays the actual game (the actual algorithm for the game)
	public boolean playGame() {
		Random generator = new Random();
		int point = 0;
		while (true){
			int die1 = 1 + generator.nextInt(6);
			int die2 = 1 + generator.nextInt(6);
			numRolls++;
			if(numRolls>stats.getMaxRoll()){
				stats.setMaxRoll(numRolls);
			}
			int totalRoll = die1+die2;
			System.out.println("Rolled a "+ totalRoll);
			if (numRolls == 1){ 								// If on first roll
				if (natural.contains(totalRoll)){				// If the first roll is NATURAL
					stats.incNaturalRollCount();
					System.out.println("*****Natural! You Win!*****");
					numRolls = 0; 								// Set to 0 before new game
					return true;
				}
				else if (craps.contains(totalRoll)){			// If the first roll is CRAPS
					stats.incCrapsRollCount();
					System.out.println("*****Craps! You lose!*****");
					numRolls = 0; 								// Set to 0 before new game
					return false;
				}
				else{
					point = totalRoll;							// If the first roll is any OTHER number
				}
			}
			else{
				if (totalRoll == 7){							// If totalRoll equals 7 after first roll, you lose
					System.out.println("*****Crap out! You lose!*****");
					numRolls = 0; 								// Set to 0 before new game
					return false;
				}
				else if (totalRoll == point){					// If totalRoll equals to point, you win 
					System.out.println("*****Rolled the point! You win!*****");
					numRolls = 0; 								// Set to 0 before new game
					return true;
				}
			}
		}	
	}
}
