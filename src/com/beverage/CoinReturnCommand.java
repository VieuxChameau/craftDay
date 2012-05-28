package com.beverage;

public class CoinReturnCommand {
	public void execute(BeverageDispenserState state, String statementParameter) {
		for (Double coin : state.getCoins()) {
			state.appendToOutput(coin.toString());
		}
		
		state.removeCoins();
	}
}
