package com.beverage;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeverageDispenserTest {

	private BeverageDispenser beverageDispenser = new BeverageDispenser();

	@Test
	public void checkCase1() {
		final String command = "PUT 1, PUT 2";

		final String result = beverageDispenser.interact(command);

		assertThat(result).isEmpty();
	}

	@Test
	public void checkCase2() {
		final String command = "PUT 1, PUT 2, GET COCA";

		final String result = beverageDispenser.interact(command);

		assertThat(result).isEqualTo("COCA");
	}

	@Test
	public void checkCase3() {
		final String command = "PUT 1, GET COCA";

		final String result = beverageDispenser.interact(command);

		assertThat(result).isEmpty();
	}

	@Test
	public void checkCase4() {
		final String command = "PUT 2, PUT 2, PUT 2, PUT 2, GET COCA, GET ORANGINA";

		final String result = beverageDispenser.interact(command);

		assertThat(result).isEqualTo("COCA, ORANGINA");
	}

	@Test
	public void checkCase5() {
		final String command = "PUT 1, PUT 2, COIN-RETURN";

		final String result = beverageDispenser.interact(command);

		assertThat(result).isEqualTo("1.0, 2.0");
	}

	@Test
	public void checkCase6() {
		final String command = "PUT 2, PUT 2, PUT 0.5, GET COCA, COIN-RETURN";

		final String result = beverageDispenser.interact(command);

		assertThat(result).isEqualTo("COCA, 0.5");
	}
}
