package com.beverage;

import java.util.HashMap;
import java.util.Map;


public class BeverageDispenser {

	private Map<String, Double> beverages = new HashMap<String, Double>();
	
	public String interact(String string) {
		
		beverages.put("COCA", 3.0);
		beverages.put("ORANGINA", 2.5);
		beverages.put("PERRIER", 2.5);
		
		String[] list = string.split(",");
		
		BeverageDispenserState state = new BeverageDispenserState();
		
		for (String token : list) {
			try {
				String[] statement = token.trim().split(" ");
				
				String statementParameter = statement.length>1?statement[1]:"";
				
				if("GET".equals(statement[0])) {
					double amount = beverages.get(statementParameter);
					if (amount <= state.getPendingAmountOfMoney()) {
						state.appendToOutput(statementParameter);
						while (amount > 0) {
							Double coin = state.removeFirstCoin();
							amount -= coin;
						}
					}
				} else if("PUT".equals(statement[0])) {
					double coin = Double.parseDouble(statementParameter);
					state.addCoin(coin);
				} else if("COIN-RETURN".equals(statement[0])) {
					for (Double coin : state.getCoins()) {
						state.appendToOutput(coin.toString());
					}
					
					state.removeCoins();
				}
			} catch (Throwable e) {
				//Should never happen
			}
		}
		return state.dumpOutput();
	}
}
