package com.caci.roulette.bets;

import java.util.Set;
import java.util.TreeSet;

import com.caci.roulette.enums.BetType;
import com.caci.roulette.game.ConsoleReader;
import com.caci.roulette.game.Wheel;

public class HighLowBet extends Bet {

	public HighLowBet(final String description, final int payout) {
		super(description, payout);
	}

	@Override
	public boolean determineWin(final String whichBet, final Wheel wheel) {
		int number = wheel.getNumber();
		return (number > 18 && whichBet.equalsIgnoreCase(BetType.HIGH.name()))
				|| (number <= 18
						&& whichBet.equalsIgnoreCase(BetType.LOW.name()));
	}

	@Override
	public String placeBetPrompt(final int whichBet) {
		Set<String> choices = new TreeSet<String>();
		choices.add(BetType.HIGH.name());
		choices.add(BetType.LOW.name());
		System.out.println();
		return ConsoleReader.enterYourChoice("Please bet", choices);
	}

}
