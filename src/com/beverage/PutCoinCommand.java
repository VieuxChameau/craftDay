package com.beverage;

public class PutCoinCommand {
	
	public void execute(BeverageDispenserState state, String statementParameter) {
		double coin = Double.parseDouble(statementParameter);
		state.addCoin(coin);
	}

}
