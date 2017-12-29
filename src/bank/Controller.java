package bank;

import java.util.ArrayList;

import interfaces.*;

/**
 * Controls the bank account program and user interaction
 * @author trisp
 * @version 1.1
 * 
 * Changelog:
 * 1.0 - Made first working instance of controller
 * 1.1 - Added logic to check whether players are valid before adding, removing and transferring. Added all comment/docs
 *
 */

public class Controller {

	//FIELDS
	/**
	 * array of players in game
	 */
	private ArrayList<Player> players;
	/**
	 * console for user interaction
	 */
	private Console console;
	/**
	 * controller
	 */
	private static Controller cont;

	//CONSTRUCTOR
	/**
	 * Inits the arraylist of players and creates a console
	 */
	public Controller() {
		players = new ArrayList();
		console = new Console(this);
	}

	//MAIN
	public static void main(String[] args) {
		cont = new Controller();
	}

	//METHODS

	/**
	 * Adds money to a specified players account
	 * @param playerName Name of the player
	 * @param amount amount of money to add
	 * @return A string stating that the amount was added to the players account
	 */
	public String addMoneyToAccount(String playerName, int amount) {
		Player addP = null;
		for (Player player : players) {
			if (player.getName().equals(playerName)) {
				addP = player;
			}
		}
		if (addP != null) {
			addP.addMoneyToAccount(amount);
			return amount + " added to " + playerName + "'s account.";
		}
		else {
			return "Player not found";
		}
	}

	/**
	 * Adds money to a specified players account
	 * @param index The index of the player
	 * @param amount amount of money to add
	 * @return A string stating that the amount was added to the players account
	 */
	public String addMoneyToAccount(int index, int amount) {
		if (index < players.size() && index >= 0) {
			Player player = players.get(index);
			player.addMoneyToAccount(amount);
			return amount + " added to " + player.getName() + "'s account.";
		}
		else {
			return "Player not found.";
		}
	}

	/**
	 * Removes money from a players account
	 * @param index The index of the player
	 * @param amount The amount to remove
	 * @return A string stating that the amount was removed
	 */
	public String removeMoneyFromAccount(int index, int amount) {
		if (index < players.size() && index >= 0) {
			Player player = players.get(index);
			player.removeMoneyFromAccount(amount);
			return amount + " removed from " + player.getName() + "'s account.";
		}
		else {
			return "Player not found.";
		}
	}

	/**
	 * Removes money from a players account
	 * @param playerName The name of the player
	 * @param amount The amount to remove
	 * @return A string stating that the amount was removed
	 */
	public String removeMoneyFromAccount(String playerName, int amount) {
		Player remP = null;
		for (Player player : players) {
			if (player.getName().equals(playerName)) {
				remP = player;
			}
		}
		if (remP != null) {
			remP.removeMoneyFromAccount(amount);
			return amount + " removed from " + playerName + "'s account.";
		}
		else {
			return "Player not found.";
		}
	}

	/**
	 * Creates a new player with the specified name and adds it to the arraylist of players
	 * @param playerName The name of the player being added
	 * @return A string stating the player was added
	 */
	public String addPlayerToGame(String playerName) {
		players.add(new Player(playerName));
		return playerName + " has been added to the Game.";
	}

	/**
	 * Removes a specified player from the arraylist of players in the game
	 * @param playerName The name of the player to be removed
	 * @return A string stating that the player was removed
	 */
	public String removePlayerFromGame(String playerName) {
		Player rem = null;
		for (Player player : players) {
			if (player.getName().equals(playerName)) {
				rem = player;
			}
		}
		if (rem == null) {
			return "Player not found.";
		}
		else {
			players.remove(rem);
			return playerName + " removed from game.";
		}
	}

	/**
	 * Removes a player from the arraylist of players in game
	 * @param index The index of the player to remove
	 * @return A string stating the player was removed
	 */
	public String removePlayerFromGame(int index) {
		if (index < players.size() && index >= 0) {
			Player rem = players.get(index);
			players.remove(rem);
			return rem.getName() + " removed from game.";
		}
		else {
			return "Player not found.";
		}
	}

	/**
	 * Gets a list of all players currently in game
	 * @return A formatted string of all players in the game currently
	 */
	public String getPlayersNames() {
		String output = "";
		int count = 1;
		for (Player player: players) {
			output += count + ") " + player.getName() + "\n";
			count++;
		}
		return output;
	}

	/**
	 * Gets the arraylist of players in game
	 * @return players ArrayList containing the players in game
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Gets a formatted string list of all the players in game and the amount of money in their accounts
	 * @return A formatted string of players and their money
	 */
	public String getPlayersNamesAndMoney() {
		String output = "";
		int count = 1;
		for (Player player: players) {
			output += count + ") " + player.getName() + ": " + player.getMoneyInAccount() +"\n";
			count++;
		}
		return output;
	}

	/**
	 * Transfers money from one player to another
	 * @param playerToIndex The index of the player where the money is being transferred from
	 * @param playerFromIndex The index of the player where the money is being transferred too
	 * @param amount The amount of money to be transferred
	 * @return A string stating that the money was transferred
	 */
	public String transferMoney(int playerToIndex, int playerFromIndex, int amount) {
		if ((playerToIndex <= players.size() && playerToIndex >= 0) && (playerFromIndex < players.size() && playerFromIndex >= 0)) {
			removeMoneyFromAccount(playerFromIndex, amount);
			addMoneyToAccount(playerToIndex, amount);
			return "Money Transferred from " + players.get(playerFromIndex).getName() + " to " + players.get(playerToIndex).getName() + ".";
		}
		else {
			return "Invalid player";
		}
	}

	/**
	 * transferres money from one players account to another
	 * @param playerTo Name of player where money is transferred from
	 * @param playerFrom Name of payer where money is transferred to
	 * @param amount3 amount of money to transfer
	 * @return A string stating that the money was transferred
	 */
	public String transferMoney(String playerTo, String playerFrom, int amount3) {
		boolean playerToValid = false, playerFromValid = false;
		for (Player player : players) {
			if (player.equals(playerTo)) {
				playerToValid = true;
			}
			if (player.equals(playerFrom)) {
				playerFromValid = true;
			}
		}
		if (playerToValid && playerFromValid) {
			removeMoneyFromAccount(playerFrom, amount3);
			addMoneyToAccount(playerTo, amount3);
			return "Money Transferred from " + playerFrom + " to " + playerTo + ".";
		}
		else {
			return "Invalid player/s";
		}
	}

}
