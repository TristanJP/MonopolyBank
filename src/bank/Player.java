package bank;

public class Player {
	
	private Account account;
	private String playerName;
	
	public Player(String playerName) {
		this.playerName = playerName;
		account = new Account();
	}
	
	public String getName() {
		return playerName;
	}
	
	public void addMoneyToAccount(int amount) {
		account.addMoney(amount);
	}
	
	public void removeMoneyFromAccount(int amount) {
		account.removeMoney(amount);
	}
	
	public int getMoneyInAccount() {
		return account.getMoney();
	}
	
	public boolean playerIsBankrupt() {
		return account.isBankrupt();
	}

}
