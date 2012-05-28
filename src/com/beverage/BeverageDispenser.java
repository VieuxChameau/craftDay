package com.beverage;

import java.util.HashMap;
import java.util.Map;



public class BeverageDispenser {
	
	private Map<String, Command> commands = new HashMap<>();
	
	private void initCommands() {
		commands.put("GET", new GetBeverageCommand());
		commands.put("PUT", new PutCoinCommand());
		commands.put("COIN-RETURN", new CoinReturnCommand());
	}
	
	public String interact(String string) {
		
		initCommands();
		
		String[] list = string.split(",");
		
		BeverageDispenserState state = new BeverageDispenserState();
		
		for (String token : list) {
			try {
				String[] statement = token.trim().split(" ");
				
				String statementParameter = statement.length>1?statement[1]:"";
				
				Command command = commands.get(statement[0]);
				command.execute(state, statementParameter);
			} catch (Throwable e) {
				//Should never happen
			}
		}
		return state.dumpOutput();
	}
}
