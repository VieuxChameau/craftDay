package com.beverage;

import org.junit.Test;

import static com.beverage.Command.COIN_RETURN;
import static com.beverage.Command.GET;
import static com.beverage.Command.PUT;
import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

	@Test
	public void from_should_return_command() throws Exception {
		assertThat(Command.from("COIN-RETURN")).isEqualTo(Command.COIN_RETURN);
	}

	@Test(expected = IllegalArgumentException.class)
	public void from_should_fail_for_unknown_command() throws Exception {
		Command.from("UNKNOW");
	}

	@Test
	public void COIN_RETURN_should_return_current_money_amount() throws Exception {
		final String commandArg = null;
		final BeverageDispenserContext context = new BeverageDispenserContext();
		context.addMoney(2);
		context.addMoney(5);

		assertThat(COIN_RETURN.execute(commandArg, context)).isEqualTo("2.0, 5.0");


		context.reset();
		assertThat(COIN_RETURN.execute(commandArg, context)).isEqualTo("");
	}

	@Test
	public void PUT_should_add_money() throws Exception {
		final String commandArg = "5";
		final BeverageDispenserContext context = new BeverageDispenserContext();

		final String result = PUT.execute(commandArg, context);

		assertThat(result).isEmpty();
		assertThat(context.getMoney()).isEqualTo(5);

	}

	@Test
	public void GET_should_return_nothing_with_enough_money() throws Exception {
		final String commandArg = "COCA";
		final BeverageDispenserContext context = new BeverageDispenserContext();

		final String result = GET.execute(commandArg, context);

		assertThat(result).isEmpty();
	}

	@Test
	public void GET_should_return_beverage() throws Exception {
		final String commandArg = "COCA";
		final BeverageDispenserContext context = new BeverageDispenserContext();
		context.addMoney(2);
		context.addMoney(2);

		final String result = GET.execute(commandArg, context);

		assertThat(result).isEqualTo("COCA");
	}
}