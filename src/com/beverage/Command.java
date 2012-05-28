package com.beverage;

public interface Command {

	public abstract void execute(BeverageDispenserState state,
			String statementParameter);

}