package interfaces;

import java.util.Scanner;
import bank.Controller;
import bank.Player;

/**
 * A simple text-based user interface for the Monopoly Bank.
 * @author trisp
 * @version 1.0
 */

public class Console {

	private Controller controller;  
	private Scanner stdIn;
	private boolean gameStarted;

	public Console(Controller controller) {

		this.controller = controller;

		// Creates a Scanner object for obtaining user input
		stdIn = new Scanner(System.in);
		gameStarted = false;

		while (true) {
			if (gameStarted) {
				displayMenu();
				getAndProcessUserOption();
			}
			else {
				displayStartMenu();
				getAndProcessUserStartOption();
			}		
		}
	}

	/**
	 * Obtain user input for start menu
	 */
	private void getAndProcessUserStartOption() {
		String command = stdIn.nextLine().trim();
		switch (command) {
		case "1" : // Add a player to the game
			display("Enter the name of the player you wish to add:");
			String playerAddName = stdIn.nextLine();
			display(controller.addPlayerToGame(playerAddName));
			break;
		case "2" : // Remove a player from the game
			display("Enter the name of the player you wish to remove:");
			String playerRemName = stdIn.nextLine();
			display(controller.removePlayerFromGame(playerRemName));
			break;
		case "3" : // Play the Game
			display(startGame());
			break;
		case "4" : // Adds defualt players to game
			display("Game will add the defualt Players.");
			controller.addPlayerToGame("Tris");
			controller.addPlayerToGame("Cessie");
			controller.addPlayerToGame("Mum");
			controller.addPlayerToGame("Dad");
			break;
		case "5" : // Exits the application
			display("Goodbye!");
			System.exit(0);
			break;
		default : // Not a known command option
			display(unrecogniseCommandErrorMsg(command));
		}
	}

	/**
	 * Changes the gameStarted boolean to true
	 * @return String saying the game started
	 */
	private String startGame() {
		gameStarted = true;
		return "Game started!";
	}

	/**
	 * Displays the header of this application and a summary of menu options.
	 */
	private void displayMenu() {
		display(header());
		display(players());
		display(menu());
	}

	/**
	 * Display the header of this application and a summary of start menu options.
	 */
	private void displayStartMenu() {
		display(header());
		display(startPlayers());
		display(startMenu());
	}

	private String startPlayers() {
		return "Players:\n" + controller.getPlayersNames();
	}
	
	private String players() {
		return "Players:\n" + controller.getPlayersNamesAndMoney();
	}

	private String startMenu() {
		return "Enter the number associated with your chosen menu option.\n" +
				"1: Add players to the game.\n" +
				"2: Remove players from the game.\n" +
				"3: Start the game.\n" +
				"4: Add the defualt players.\n" +
				"5: Exit this application.\n";
	}

	/**
	 * Obtains a user option and processes it.
	 */
	private void getAndProcessUserOption() {
		String command = stdIn.nextLine().trim();
		switch (command) {
		case "1" : // Add money to account
			display("Name the player and amount to add.");
			String input = stdIn.nextLine();
			String[] inputArr = input.split(" ");
			String player = inputArr[0];
			int amount = Integer.parseInt(inputArr[1]);
			if (!playerNameValid(inputArr[0])) {
				int playerIndex = Integer.parseInt(player);
				playerIndex--;
				if (playerIndex > controller.getPlayers().size() || playerIndex < 0) {
					display("Invalid player");
				}
				else {
					display(controller.addMoneyToAccount(playerIndex, amount));
				}
			}
			else {
				display(controller.addMoneyToAccount(player, amount));
			}
			break;
		case "2" : // Remove money from an account
			display("Name the player and amount to remove.");
			String input2 = stdIn.nextLine();
			String[] inputArr2 = input2.split(" ");
			String player2 = inputArr2[0];
			int amount2 = Integer.parseInt(inputArr2[1]);
			if (!playerNameValid(inputArr2[0])) {
				int playerIndex = Integer.parseInt(player2);
				playerIndex--;
				if (playerIndex > controller.getPlayers().size() || playerIndex < 0) {
					display("Invalid player");
				}
				else {
					display(controller.removeMoneyFromAccount(playerIndex, amount2));
				}
			}
			else {
				display(controller.removeMoneyFromAccount(player2, amount2));
			}
			break;
		case "3" : // Transfer money from one account to another
			display("Name both players and amount to transfer.");
			String input3 = stdIn.nextLine();
			String[] inputArr3 = input3.split(" ");
			String playerFrom = inputArr3[0];
			String playerTo = inputArr3[1];
			int amount3 = Integer.parseInt(inputArr3[2]);
			if (!playerNameValid(inputArr3[0])) {
				int playerToIndex = Integer.parseInt(playerTo);
				playerToIndex--;
				int playerFromIndex = Integer.parseInt(playerFrom);
				playerFromIndex--;
				if ((playerToIndex > controller.getPlayers().size() || playerToIndex < 0) && (playerFromIndex > controller.getPlayers().size() || playerFromIndex < 0)) {
					display("Invalid player");
				}
				else {
					display(controller.transferMoney(playerToIndex, playerFromIndex, amount3));
				}
			}
			else {
				display(controller.transferMoney
						(playerTo, playerFrom, amount3));
			}
			break;
		case "4" : // Exits the application
			display("Goodbye!");
			System.exit(0);
			break;
		default : // Not a known command option
			display(unrecogniseCommandErrorMsg(command));
		}
	}

	private boolean playerNameValid(String playerName) {
		for (Player player : controller.getPlayers()) {
			if (player.getName().equals(playerName)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Returns a string representation of a brief title for this application as the header.
	 * @return	a header
	 */
	private static String header() {
		return "\nMonopoly Bank\n";
	}

	/**
	 * Returns a string representation of the user menu.
	 * @return	the user menu
	 */
	private static String menu() {
		return "Enter the number associated with your chosen menu option.\n" +
				"1: Add money to an account.\n" +
				"2: Remove money from an account.\n" +
				"3: Transfer money from one account to another.\n" +
				"4: Exit this application.\n";
	}

	/*
	 * Displays the specified info for the user to view.
	 * @param info	info to be displayed on the screen
	 */
	private void display(String info) {
		System.out.println(info);
	}

	/*
	 * Returns an error message for an unrecognised command.
	 * 
	 * @param error the unrecognised command
	 * @return      an error message
	 */
	private static String unrecogniseCommandErrorMsg(String error) {
		return String.format("Cannot recognise the given command: %s.%n", error);
	}

}