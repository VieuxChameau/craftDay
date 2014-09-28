package com.beverage;

public class BeverageDispenserContext {
	private double money = 0;

	public double getMoney() {
		return money;
	}

	public void addMoney(final double amount) {
		money += amount;
	}

	public void descreaseMoney(final double amount) {
		money -= amount;
	}

	public void resetMoney() {
		money = 0;
	}

	public boolean hasMoney() {
		return money != 0;
	}
}
