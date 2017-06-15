package com.caci.roulette.bets;

import java.util.Set;
import java.util.TreeSet;

import com.caci.roulette.enums.NumberType;
import com.caci.roulette.game.ConsoleReader;
import com.caci.roulette.game.Wheel;

public class EvenOddBet extends Bet {

	public static final int evenOddWinAmountMultiplier = 2;

	public EvenOddBet(final String description, final int payout) {
		super(description, payout);

	}

	@Override
	public boolean determineWin(final String whichBet, final Wheel wheel) {
		int number = wheel.getNumber();
		return ((number != 0) && !isOdd(number)
				&& whichBet.equalsIgnoreCase(NumberType.EVEN.name())
				|| isOdd(number)
						&& whichBet.equalsIgnoreCase(NumberType.ODD.name()));
	}

	@Override
	public String placeBetPrompt(final int whichBet) {
		Set<String> choices = new TreeSet<String>();
		choices.add(NumberType.ODD.name());
		choices.add(NumberType.EVEN.name());
		System.out.println();
		return ConsoleReader.enterYourChoice("Please bet", choices);
	}

	// right most bit always is 1 for odd numbers
	public boolean isOdd(final long number) {
		return (number & 0X1) == 1;
	}

	@Override
	public int getPayout() {
		return evenOddWinAmountMultiplier;
	}

}
