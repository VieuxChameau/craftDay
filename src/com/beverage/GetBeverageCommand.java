package com.beverage;

import java.util.HashMap;
import java.util.Map;

public class GetBeverageCommand {
	private Map<String, Double> beverages = new HashMap<String, Double>();
	
	public void getBeverageCommand(BeverageDispenserState state, String statementParameter) {
		double amount = beverages.get(statementParameter);
		if (amount <= state.getPendingAmountOfMoney()) {
			state.appendToOutput(statementParameter);
			while (amount > 0) {
				Double coin = state.removeFirstCoin();
				amount -= coin;
			}
		}
	}
}
