package com.caci.roulette.bets;

import com.caci.roulette.exception.RouletteGameException;
import com.caci.roulette.game.ConsoleReader;
import com.caci.roulette.game.Wheel;

public class SingleNumberBet extends Bet {

	public SingleNumberBet(final String description, final int payout) {
		super(description, payout);
	}

	@Override
	public boolean determineWin(final String whichBet, final Wheel wheel) {
		String number = "" + wheel.getNumber();
		return whichBet.equals(number);
	}

	@Override
	public String placeBetPrompt(final int whichBet)
			throws RouletteGameException {
		String result = "" + ConsoleReader.enterRange("Enter a number", 1, 34);
		System.out.println();
		return result;
	}

}
