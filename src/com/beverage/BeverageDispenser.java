package com.beverage;

import java.util.HashMap;
import java.util.Map;


public class BeverageDispenser {

	private Map<String, Double> beverages = new HashMap<String, Double>();
	
	private void getBeverageCommand(BeverageDispenserState state, String statementParameter) {
		double amount = beverages.get(statementParameter);
		if (amount <= state.getPendingAmountOfMoney()) {
			state.appendToOutput(statementParameter);
			while (amount > 0) {
				Double coin = state.removeFirstCoin();
				amount -= coin;
			}
		}
	}
	
	private void putCoinCommand(BeverageDispenserState state, String statementParameter) {
		double coin = Double.parseDouble(statementParameter);
		state.addCoin(coin);
	}
	
	private void coinReturnCommand(BeverageDispenserState state) {
		for (Double coin : state.getCoins()) {
			state.appendToOutput(coin.toString());
		}
		
		state.removeCoins();
	}
	
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
					getBeverageCommand(state, statementParameter);
				} else if("PUT".equals(statement[0])) {
					putCoinCommand(state, statementParameter);
				} else if("COIN-RETURN".equals(statement[0])) {
					coinReturnCommand(state);
				}
			} catch (Throwable e) {
				//Should never happen
			}
		}
		return state.dumpOutput();
	}
}
