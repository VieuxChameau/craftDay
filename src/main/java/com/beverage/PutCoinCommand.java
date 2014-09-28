package com.beverage;

public class PutCoinCommand implements Command {

	public void execute(BeverageDispenserState state, String statementParameter) {
		double coin = Double.parseDouble(statementParameter);
		state.addCoin(coin);
	}

}
