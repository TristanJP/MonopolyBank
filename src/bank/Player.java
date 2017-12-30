package bank;

/**
 * A PLayer object in the game, has a bank account
 * @author trisp
 * @version 1.0
 *
 * Changelog:
 * 1.0 - Created first iteration of the player
 */

public class Player {
	
	//FIELDS
	/**
	 * Holds the players bank account
	 */
	private Account account;
	/**
	 * Holds the name of the player
	 */
	private String playerName;
	
	//CONSTRUCTOR
	
	/**
	 * Creates the player with the given name and a new account
	 * @param playerName
	 */
	public Player(String playerName) {
		this.playerName = playerName;
		account = new Account();
	}
	
	//METHODS
	
	/**
	 * Gets the name of the player
	 * @return the players name
	 */
	public String getName() {
		return playerName;
	}
	
	/**
	 * Adds money to this players account
	 * @param amount the amount of money to add
	 */
	public void addMoneyToAccount(int amount) {
		account.addMoney(amount);
	}
	
	/**
	 * Removes money from this players account
	 * @param amount the amount of money to remove
	 */
	public void removeMoneyFromAccount(int amount) {
		account.removeMoney(amount);
	}
	
	/**
	 * Gets the amount of money in this players account
	 * @return the amount of money in the plaeyrs account
	 */
	public int getMoneyInAccount() {
		return account.getMoney();
	}
	
	/**
	 * Gets whether the player is out of money
	 * @return true if player has less than 0 money
	 */
	public boolean playerIsBankrupt() {
		return account.isBankrupt();
	}

}
