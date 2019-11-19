import java.util.Scanner;

/**
 *  Vivian Thach (33939402) Diana Sandil (10443456)
 *  
 *  Lab2: Contains the main method to run the Craps Simulation Game.
 *
 */


public class Lab2 {
	public static void main(String []args) {
		CrapsSimulation simulation = new CrapsSimulation();
		Scanner in = new Scanner(System.in);
		String response;
		// Starts simulation, then at the end, check the replay response
		// If response equals to "y" it will reset, and run the simulation again
		// If response equals to "n" the simulation will stop
		do{
			simulation.start();
			System.out.println("Replay? Enter 'y' or 'n': ");
			response = in.next();
			while (!response.equals("y") && !response.equals("n")) { 
				System.out.println("Invalid response. Please enter 'y' or 'n' if you wish to replay.");
				response = in.next();
			}
			if (response.toLowerCase().equals("y")) {
				simulation.getStats().reset();
			}
		}
		while (!response.equals("n"));		
	}
	
}
