package com.beverage;

public enum Beverage {
	COCA(3.0),
	ORANGINA(2.5),
	PERRIER(2.5);

	private final double amount;

	private Beverage(final double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
}
