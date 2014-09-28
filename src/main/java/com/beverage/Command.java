package com.beverage;

import com.google.common.base.Joiner;

import java.util.List;

public enum Command {
	GET {
		@Override
		public String execute(final String commandArg, final List<Double> availableCoins, final BeverageDispenserContext context) {
			double amount = Beverage.valueOf(commandArg).getAmount();
			if (amount <= context.getMoney()) {
				while (amount > 0) {
					Double coin = availableCoins.remove(0);
					amount -= coin;
					context.descreaseMoney(coin);
				}
				return commandArg;
			}
			return "";
		}
	},
	PUT {
		@Override
		public String execute(final String commandArg, final List<Double> availableCoins, final BeverageDispenserContext context) {
			final double amountPut = Double.parseDouble(commandArg);
			context.addMoney(amountPut);
			availableCoins.add(amountPut);
			return "";
		}
	},
	COIN_RETURN("COIN-RETURN") {
		@Override
		public String execute(final String commandArg, final List<Double> availableCoins, final BeverageDispenserContext context) {
			if (!context.hasMoney()) {
				return "";
			}
			final String result = Joiner.on(", ").join(availableCoins);
			context.resetMoney();
			availableCoins.clear();
			return result;
		}
	};

	private final String command;

	private Command() {
		this.command = this.name();
	}

	private Command(final String command) {
		this.command = command;
	}

	public abstract String execute(final String commandArg, final List<Double> availableCoins, final BeverageDispenserContext context);

	public String getCommand() {
		return command;
	}

	public static Command from(final String commandInput) {
		for (Command command : values()) {
			if (command.getCommand().equals(commandInput)) {
				return command;
			}
		}
		throw new IllegalArgumentException("Unknow Command");
	}
}
