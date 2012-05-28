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
					Command command = new GetBeverageCommand();
					command.execute(state, statementParameter);
				} else if("PUT".equals(statement[0])) {
					Command command = new PutCoinCommand();
					command.execute(state, statementParameter);
				} else if("COIN-RETURN".equals(statement[0])) {
					Command command = new CoinReturnCommand();
					command.execute(state, "");
				}
			} catch (Throwable e) {
				//Should never happen
			}
		}
		return state.dumpOutput();
	}
}
