package com.caci.roulette.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.caci.roulette.bets.BlackRedBet;
import com.caci.roulette.bets.EvenOddBet;
import com.caci.roulette.bets.HighLowBet;
import com.caci.roulette.bets.SingleNumberBet;
import com.caci.roulette.bets.ThreeInARowBet;
import com.caci.roulette.bets.TwoInARowBet;
import com.caci.roulette.enums.BetColor;
import com.caci.roulette.enums.BetType;
import com.caci.roulette.enums.NumberType;
import com.caci.roulette.game.Wheel;

public class BetTest {

	Wheel wheel;
	Wheel clone;

	@Before
	public void setUp() {
		wheel = new Wheel();
		clone = wheel.clone(23);
	}

	@Test
	public void testBlackRedBet() {
		BlackRedBet b = new BlackRedBet("Bet", 1);
		String whichBet = BetColor.RED.name();
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 1);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = BetColor.BLACK.name();
		assertEquals(b.determineWin(whichBet, clone), false);

	}

	@Test
	public void testEvenOddBet() {
		EvenOddBet b = new EvenOddBet("Bet", 1);
		String whichBet = NumberType.ODD.name();
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 1);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = NumberType.EVEN.name();
		assertEquals(b.determineWin(whichBet, clone), false);

	}

	@Test
	public void testThreeInARowBet() {
		ThreeInARowBet b = new ThreeInARowBet("Bet", 11);
		String whichBet = "21";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 11);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "20";
		assertEquals(b.determineWin(whichBet, clone), false);

	}

	@Test
	public void testTwoInARowBet() {
		TwoInARowBet b = new TwoInARowBet("Bet", 17);
		String whichBet = "22";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 17);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "20";
		assertEquals(b.determineWin(whichBet, clone), false);

	}

	@Test
	public void testHighLowBet() {
		HighLowBet b = new HighLowBet("Bet", 1);
		String whichBet = BetType.HIGH.name();
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 1);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = BetType.LOW.name();
		assertEquals(b.determineWin(whichBet, clone), false);

	}

	@Test
	public void testSingleNumberBet() {
		SingleNumberBet b = new SingleNumberBet("Bet", 35);
		String whichBet = "23";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 35);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "20";
		assertEquals(b.determineWin(whichBet, clone), false);

	}
}
