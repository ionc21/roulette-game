package com.caci.roulette.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.caci.roulette.enums.BetColor;
import com.caci.roulette.game.Game;
import com.caci.roulette.game.Wheel;
import com.caci.roulette.model.Player;

public class GameAndWheelTest {

	Player dude;
	Wheel wheel;
	Game game;
	Wheel clone;

	@Before
	public void setUp() {
		dude = new Player("The Dude", 5000);
		wheel = new Wheel();
		game = new Game();
		clone = wheel.clone(1);
	}

	@Test
	public void testWheelGetters() {
		assertEquals(1, clone.getNumber());
		assertEquals(BetColor.RED.name(), clone.getColor());
		wheel.spin();
		assertEquals(1, wheel.getNumSpins());
	}

}
