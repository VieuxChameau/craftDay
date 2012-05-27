package com.beverage;
import java.util.ArrayList;
import java.util.List;

public class BeverageDispenserState {

	private List<Double> coins = new ArrayList<Double>();
	private double pendingAmountOfMoney = 0;
	private StringBuilder output = new StringBuilder();

	public List<Double> getCoins() {
		return coins;
	}

	public void removeCoins() {
		coins.clear();
		pendingAmountOfMoney = 0;
	}

	public void addCoin(double coin) {
		pendingAmountOfMoney += coin;
		coins.add(coin);
	}
	
	public void appendToOutput(String str){
		if(output.length() > 0){
			output.append(", ");
		}
		output.append(str);
	}
	
	public String dumpOutput(){
		return output.toString();
	}
	
	public double getPendingAmountOfMoney(){
		return pendingAmountOfMoney;
	}

	public double removeFirstCoin() {
		double firstCoin = coins.remove(0);
		pendingAmountOfMoney -= firstCoin;
		return firstCoin;
	}

}
