package com.caci.roulette.bets;

import com.caci.roulette.exception.RouletteGameException;
import com.caci.roulette.game.Wheel;

public abstract class Bet {

	private String description;
	private int payout;

	/**
	 * Constructs a bet with the given name and odds.
	 * 
	 * @param description
	 *            name of this kind of bet
	 * @param payout
	 *            payout given by the house for this kind of bet
	 */
	public Bet(final String description, final int payout) {
		this.description = description;
		this.payout = payout;
	}

	/**
	 * @return odds given by the house for this kind of bet
	 */
	public int getPayout() {
		return payout;
	}

	/**
	 * @return name of this kind of bet
	 */
	public String getDescription() {
		return description;
	}

	public abstract boolean determineWin(String whichBet, Wheel wheel);

	public abstract String placeBetPrompt(int whichBet)
			throws RouletteGameException;

}
