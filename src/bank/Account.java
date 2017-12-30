package bank;

/**
 * A bank account for a player, stores the players money
 * @author trisp
 * @version 1.0
 * 
 * Changelog:
 * 1.0 - Created base iteration with default value for starting money
 */

public class Account {
	
	//FIELDS
	/**
	 * Stores the players current money
	 */
	private int money;
	
	//CONSTRUCTOR
	
	/**
	 * Creates the bank account with 1500
	 */
	public Account() {
		//starting amount is 1500
		money = 1500;
	}
	
	//METHODS
	
	/**
	 * Gets the current amount of money in the players account
	 * @return The amount of money in the players account
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * Adds money to the players account
	 * @param amount THe amount of money to add to the players account
	 */
	public void addMoney(int amount) {
		money += amount;
	}
	
	/**
	 * Removes money from the players account
	 * @param amount The amount of money to remove from the players account
	 */
	public void removeMoney(int amount) {
		money -= amount;
	}
	
	/**
	 * Gets whether the account has less than 0 funds and is therefore bankrupt
	 * @return true if account has less than 0 funds, otherwise false
	 */
	public boolean isBankrupt() {
		if (money < 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
