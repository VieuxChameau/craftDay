package com.beverage;

import com.google.common.base.Joiner;

public enum Command {
	GET {
		@Override
		public String execute(final String commandArg, final BeverageDispenserContext context) {
			double amount = Beverage.valueOf(commandArg).getAmount();
			if (amount <= context.getMoney()) {
				while (amount > 0) {
					double coin = context.popMoney();
					amount -= coin;
				}
				return commandArg;
			}
			return "";
		}
	},
	PUT {
		@Override
		public String execute(final String commandArg, final BeverageDispenserContext context) {
			final double amountPut = Double.parseDouble(commandArg);
			context.addMoney(amountPut);
			return "";
		}
	},
	COIN_RETURN("COIN-RETURN") {
		@Override
		public String execute(final String commandArg, final BeverageDispenserContext context) {
			final String result = Joiner.on(", ").join(context.getAvailableCoins());
			context.reset();
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

	public abstract String execute(final String commandArg, final BeverageDispenserContext context);

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
