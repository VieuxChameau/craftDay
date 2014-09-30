package com.beverage;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeverageDispenserTest {

	private BeverageDispenser beverageDispenser = new BeverageDispenser();

	@Test
	public void should_execute_all_commands() {
		final String command = "PUT 2, PUT 2, PUT 2, PUT 2, GET COCA, GET ORANGINA, COIN-RETURN";

		final String result = beverageDispenser.interact(command);

		assertThat(result).isEqualTo("COCA, ORANGINA");
	}
}
