package com.caci.roulette.bets;

import java.util.Set;
import java.util.TreeSet;

import com.caci.roulette.enums.BetColor;
import com.caci.roulette.game.ConsoleReader;
import com.caci.roulette.game.Wheel;

public class BlackRedBet extends Bet {

	public static final int bleacRedWinMultiplierAmount = 36;

	public BlackRedBet(final String description, final int payout) {
		super(description, payout);

	}

	@Override
	public boolean determineWin(final String whichBet, final Wheel wheel) {
		String color = wheel.getColor();
		return color.equalsIgnoreCase(whichBet);
	}

	@Override
	public String placeBetPrompt(final int whichBet) {
		Set<String> choices = new TreeSet<String>();
		choices.add(BetColor.BLACK.name());
		choices.add(BetColor.RED.name());
		System.out.println();
		return ConsoleReader.enterYourChoice("Please bet", choices);
	}

	@Override
	public int getPayout() {
		return bleacRedWinMultiplierAmount;
	}

}
