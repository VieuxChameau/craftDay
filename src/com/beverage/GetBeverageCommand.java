package com.beverage;

import java.util.HashMap;
import java.util.Map;

public class GetBeverageCommand {
	private Map<String, Double> beverages = new HashMap<String, Double>();
	
	public void execute(BeverageDispenserState state, String statementParameter) {
		beverages.put("COCA", 3.0);
		beverages.put("ORANGINA", 2.5);
		beverages.put("PERRIER", 2.5);
		
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
