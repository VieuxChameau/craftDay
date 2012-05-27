package com.beverage.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.beverage.BeverageDispenser;

public class BeverageDispenserTest {

	@Test
	public void checkCase1() {
		BeverageDispenser bd = new BeverageDispenser();
		String command = "PUT 1, PUT 2";
		assertThat(bd.interact(command), is(""));
	}

	@Test
	public void checkCase2() {
		BeverageDispenser bd = new BeverageDispenser();
		String command = "PUT 1, PUT 2, GET COCA";
		assertThat(bd.interact(command), is("COCA"));
	}

	@Test
	public void checkCase3() {
		BeverageDispenser bd = new BeverageDispenser();
		String command = "PUT 1, GET COCA";
		assertThat(bd.interact(command), is(""));
	}

	@Test
	public void checkCase4() {
		BeverageDispenser bd = new BeverageDispenser();
		String command = "PUT 2, PUT 2, PUT 2, PUT 2, GET COCA, GET ORANGINA";
		assertThat(bd.interact(command), is("COCA, ORANGINA"));
	}

	@Test
	public void checkCase5() {
		BeverageDispenser bd = new BeverageDispenser();
		String command = "PUT 1, PUT 2, COIN-RETURN";
		assertThat(bd.interact(command), is("1.0, 2.0"));
	}

	@Test
	public void checkCase6() {
		BeverageDispenser bd = new BeverageDispenser();
		String command = "PUT 2, PUT 2, PUT 0.5, GET COCA, COIN-RETURN";
		assertThat(bd.interact(command), is("COCA, 0.5"));
	}
}
