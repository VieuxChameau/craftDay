package com.beverage;



public class BeverageDispenser {
	
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
					PutCoinCommand command = new PutCoinCommand();
					command.putCoinCommand(state, statementParameter);
				} else if("COIN-RETURN".equals(statement[0])) {
					CoinReturnCommand command = new CoinReturnCommand();
					command.coinReturnCommand(state);
				}
			} catch (Throwable e) {
				//Should never happen
			}
		}
		return state.dumpOutput();
	}
}
