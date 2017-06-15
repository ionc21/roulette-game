package com.caci.roulette.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.caci.roulette.model.Player;

public class PlayerTest {

	@Test
	public void testCreation() {
		Player g = new Player("Robert", 1001);
		assertEquals(g.getName(), "Robert");
		assertEquals(g.getBankroll(), 1001);
	}

	@Test
	public void testSolvent() {
		Player g;

		g = new Player("Robert", 0);
		assertEquals(false, g.isSolvent());

		g = new Player("Robert", -1);
		assertEquals(false, g.isSolvent());

		g = new Player("Robert", 1);
		assertEquals(true, g.isSolvent());
	}

	@Test
	public void testUpdate() {
		Player g = new Player("Robert", 1);

		g.updateBankroll(0);
		assertEquals(1, g.getBankroll());
		g.updateBankroll(-1);
		assertEquals(0, g.getBankroll());
		g.updateBankroll(2);
		assertEquals(2, g.getBankroll());
		g.updateBankroll(13);
		assertEquals(15, g.getBankroll());
	}

}
