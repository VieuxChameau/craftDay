package com.beverage;

import java.util.ArrayList;
import java.util.List;

public class BeverageDispenser {
	private static final String COMMAND_SEPARATOR = ",";
	private final BeverageDispenserContext context = new BeverageDispenserContext();

	public String interact(final String customerInput) {
		final List<Double> availableCoins = new ArrayList<>();
		final StringBuilder result = new StringBuilder();
		for (String aCommand : customerInput.split(COMMAND_SEPARATOR)) {
			final String[] statement = aCommand.trim().split(" ");
			final Command command = Command.from(statement[0]);
			final String commandResult = command.execute(getCommandArgument(statement), availableCoins, context);
			addResult(commandResult, result);
		}
		return result.toString();
	}

	private void addResult(final String commandResult, final StringBuilder result) {
		if (result.length() > 0){
			result.append(", ");
		}
		result.append(commandResult);
	}

	private String getCommandArgument(final String[] statement) {
		return statement.length > 1 ? statement[1] :"";
	}
}
