package com.beverage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeverageDispenser {
	private double money = 0;
	private Map<String, Double> beverages = new HashMap<String, Double>();

	public String Interact(String string) {
		beverages.put("COCA", 3.0);
		beverages.put("ORANGINA", 2.5);
		beverages.put("PERRIER", 2.5);
		List<Double> COINS = new ArrayList<Double>();
		StringBuilder result = new StringBuilder();
		String[] list = string.split(",");
		for (String token : list) {
			try {
				String[] statement = token.trim().split(" ");
				if (statement[0].equals("GET")) {
					double amount = beverages.get(statement[1]);
					if (amount <= money) {
						if (!result.toString().equals("")) {
							result.append(", ");
						}
						result.append(statement[1]);
						while (amount > 0) {
							Double coin = COINS.remove(0);
							amount -= coin;
							money -= coin;
						}
					}
				} else if (statement[0].equals("PUT")) {
					money += Double.parseDouble(statement[1]);
					COINS.add(Double.parseDouble(statement[1]));
				} else if (statement[0].equals("COIN-RETURN") && money != 0) {
					money = 0;
					for (Double coin : COINS) {
						if (!result.toString().equals("")) {
							result.append(", ");
						}
						result.append(coin);
					}
					COINS.clear();
				}
			} catch (Throwable e) {
				//Should never happen
			}
		}
		return result.toString();
	}
}
