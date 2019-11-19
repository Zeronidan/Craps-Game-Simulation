/**
 *  Vivian Thach (33939402) Diana Sandil (10443456)
 *  
 *   CrapsSimulation: class representing all the information
 *   for a Craps simulation.  Keeps track of all the game objects
 *   (CrapsGame and CrapsMetrics Monitor objects)
 *   and user variables for the game.
 *
 */

import java.util.Scanner;


public class CrapsSimulation
{
	// Private variables: CrapsGame object, CrapsMetrics Monitor object, static username,
	// balance, bet, winStreak, loseStreak
	// These variables are passed into the constructor.
	private CrapsGame game;
	private CrapsMetricsMonitor stats;
	private static String username;
	private double balance;
	private double bet;
	private int winStreak;
	private int loseStreak;
	
	// CrapsSimulation constructor sets a new CrapsMetricMonitor and CrapsGame object
	// Initializes winStreak, loseStreak, username, balance, and bet
	public CrapsSimulation()
	{
		stats = new CrapsMetricsMonitor();
		game = new CrapsGame(stats);
		winStreak = 0;
		loseStreak = 0;
		username = "";
		balance = 0;
		bet = 0;
	}
	// Gets the CrapsMetricsMonitor object
	public CrapsMetricsMonitor getStats() {
		return stats;
	}
	
	// While running simulation, call playGame from CrapsGame object
	public void start()
	{
		// Ask User for input
		Scanner in = new Scanner(System.in);
		System.out.print("Welcome to SimCraps!  Enter your user name: ");
		username = in.nextLine();
		System.out.print("Hello " + username + "!\n");
		System.out.print("Enter the amount of money you will bring to the table: ");
		balance = in.nextInt();
		System.out.print("Enter the bet amount between $1 and $" + balance + ": ");
		bet = in.nextDouble(); 
		while(bet < 1  || bet > balance)
		{
			System.out.print("Invalid bet!  Please enter a bet between $1 and $" + balance + ": ");
			bet = in.nextDouble();
		}
		double originalBet = bet;
		stats.setMaxBalance(bet);
		
		// While the simulation is running, this while-loop will keep track of the 
		// current balance, bet, win streak, and lose streak. If the balance is equal to 0
		// the simulation will end
		System.out.println(username + " bets $" + bet);
		while (balance > 0) {			
			boolean winOrLose = game.playGame();
			
			stats.incGamesPlayed();
			if (winOrLose){ 		// If you won the game
				stats.incGamesWon();
				balance += bet;
				if (balance > stats.getMaxBalance()){ 			// Set Max Balance
					stats.setMaxBalance(balance);
					stats.setGameOfMaxBalance(stats.getGamesPlayed());
				}
				if (loseStreak > 0){ 			// If on a losing streak, and won, set to 0
					loseStreak = 0;
				}
				winStreak++;
				if (winStreak > stats.getMaxWinStreak()){		// Set Max Win Streak
					stats.setMaxWinStreak(winStreak);
				}
			}
			else {					// If you lose the game
				stats.incGamesLost();
				balance -= bet;
				if(winStreak > 0){ 				//If on a winning streak, and lost, set to 0
					winStreak = 0;
				}
				loseStreak++;
				if (loseStreak > stats.getMaxLoseStreak()) {
					stats.setMaxLoseStreak(loseStreak);
				}
			}
			if (bet != originalBet){	// Sets bet back to original
				bet = originalBet;
			}

			if (balance != 0){
				if (bet > balance) {	// Sets bet temporarily to balance if bet is greater than balance
					bet = balance;
				}
				System.out.println(username + "'s balance: " + balance + ". Playing a new game...");
				System.out.println(username + " bets $" + bet);
			}
		}
		System.out.println(username + "'s balance: " + balance);
		stats.printStatistics();
		
	}
}
