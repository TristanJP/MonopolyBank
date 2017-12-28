package bank;

public class Account {
	
	private int money;
	
	public Account() {
		//starting amount is 1500
		money = 1500;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void addMoney(int amount) {
		money += amount;
	}
	
	public void removeMoney(int amount) {
		money -= amount;
	}
	
	public boolean isBankrupt() {
		if (money < 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
