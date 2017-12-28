package bank;

import interfaces.*;

/**
 * Controls the bank account program and user interaction
 * @author trisp
 * @version 1.0
 *
 */

public class Controller {
	
	//FIELDS
	
	/**
	 * boolean to control whether the program is running
	 */
	private boolean run;
	/**
	 * field to hold the console
	 */
	private Console console;
	/**
	 * array of players in game
	 */
	private Player[] players;
	
	
	//METHODS
	
	/**
	 * Main mathod for running of the program
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	/**
	 * Constructor for Controller object, Singleton
	 */
	private Controller() {
		
	}

}
