package com.beverage;

import java.util.ArrayList;
import java.util.List;

public class BeverageDispenserContext {
	private double money = 0;
	final List<Double> availableCoins = new ArrayList<>();

	public double getMoney() {
		return money;
	}

	public List<Double> getAvailableCoins() {
		return availableCoins;
	}

	public void addMoney(final double amount) {
		money += amount;
		availableCoins.add(amount);
	}

	public double popMoney() {
		final double coin = this.availableCoins.remove(0);
		money -= coin;
		return coin;
	}

	public void reset() {
		money = 0;
		availableCoins.clear();
	}
}
