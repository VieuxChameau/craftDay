package com.beverage;

import java.util.HashMap;
import java.util.Map;


public class BeverageDispenser {
	
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
		
		String[] list = string.split(",");
		
		BeverageDispenserState state = new BeverageDispenserState();
		
		for (String token : list) {
			try {
				String[] statement = token.trim().split(" ");
				
				String statementParameter = statement.length>1?statement[1]:"";
				
				if("GET".equals(statement[0])) {
					GetBeverageCommand command = new GetBeverageCommand();
					command.getBeverageCommand(state, statementParameter);
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
