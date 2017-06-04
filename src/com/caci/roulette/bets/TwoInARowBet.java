package com.caci.roulette.bets;

import com.caci.roulette.exception.RouletteGameException;
import com.caci.roulette.game.ConsoleReader;
import com.caci.roulette.game.Wheel;

public class TwoInARowBet extends Bet {

	public TwoInARowBet(final String description, final int payout) {
		super(description, payout);
	}

	@Override
	public boolean determineWin(final String whichBet, final Wheel wheel) {
		int start = Integer.parseInt(whichBet);
		return (start <= wheel.getNumber() && wheel.getNumber() < start + 2);
	}

	@Override
	public String placeBetPrompt(final int whichBet)
			throws RouletteGameException {
		String result = "" + ConsoleReader
				.enterRange("Enter first of two consecutive numbers", 1, 34);
		System.out.println();
		return result;
	}

}
