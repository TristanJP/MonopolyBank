package bank;

import java.util.ArrayList;

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
	public Controller() {
		players = new ArrayList();
		console = new Console(this);
	}

	//MAIN
	public static void main(String[] args) {
		cont = new Controller();
	}

	//METHODS

	public String addMoneyToAccount(String playerName, int amount) {
		for (Player player : players) {
			if (player.getName().equals(playerName)) {
				player.addMoneyToAccount(amount);
			}
		}
		return amount + " added to " + playerName + "'s account.";
	}
	
	public String addMoneyToAccount(int index, int amount) {
		Player player = players.get(index);
		player.addMoneyToAccount(amount);
		return amount + " added to " + player.getName() + "'s account.";
	}
	
	public String removeMoneyFromAccount(int index, int amount) {
		Player player = players.get(index);
		player.removeMoneyFromAccount(amount);
		return amount + " removed from " + player.getName() + "'s account.";
	}

	public String removeMoneyFromAccount(String playerName, int amount) {
		for (Player player : players) {
			if (player.getName().equals(playerName)) {
				player.removeMoneyFromAccount(amount);
			}
		}
		return amount + " removed from " + playerName + "'s account.";
	}
	
	public String addPlayerToGame(String playerName) {
		players.add(new Player(playerName));
		return playerName + " has been added to the Game.";
	}

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
	
	public String getPlayersNames() {
		String output = "";
		int count = 1;
		for (Player player: players) {
			output += count + ") " + player.getName() + "\n";
			count++;
		}
		return output;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public String getPlayersNamesAndMoney() {
		String output = "";
		int count = 1;
		for (Player player: players) {
			output += count + ") " + player.getName() + ": " + player.getMoneyInAccount() +"\n";
			count++;
		}
		return output;
	}

	public String transferMoney(int playerToIndex, int playerFromIndex, int amount3) {
		removeMoneyFromAccount(playerFromIndex, amount3);
		addMoneyToAccount(playerToIndex, amount3);
		return "Money Transferred.";
	}

	public String transferMoney(String playerTo, String playerFrom, int amount3) {
		removeMoneyFromAccount(playerFrom, amount3);
		addMoneyToAccount(playerTo, amount3);
		return "Money Transferred.";
	}

}
