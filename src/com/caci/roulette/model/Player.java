package com.caci.roulette.model;

public class Player {

	private String name;
	private int money;

	/**
	 * Constructs a gambler with the given name and an initial bank roll.
	 * 
	 * @param name
	 *            used to refer to the gambler
	 * @param money
	 *            initial amount of the money the gambler has to spend
	 */
	public Player(final String name, final int money) {
		this.name = name;
		this.money = money;
	}

	/**
	 * @return name of the gambler
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return amount of money the gambler has left
	 */
	public int getBankroll() {
		return money;
	}

	/**
	 * @return true if the gambler has money left to spend, false otherwise
	 */
	public boolean isSolvent() {
		return (money > 0);
	}

	/**
	 * Changes the gambler's bank roll to reflect the given amount won or lost.
	 * 
	 * @param amount
	 *            money won (positive) or lost (negative) by the gambler
	 */
	public void updateBankroll(final int amount) {
		money += amount;
	}
}
