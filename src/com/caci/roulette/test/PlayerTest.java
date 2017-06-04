package com.caci.roulette.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		assertTrue(!g.isSolvent());

		g = new Player("Robert", -1);
		assertTrue(!g.isSolvent());

		g = new Player("Robert", 1);
		assertTrue(g.isSolvent());
	}

	@Test
	public void testUpdate() {
		Player g = new Player("Robert", 1);

		g.updateBankroll(0);
		assertEquals(g.getBankroll(), 1);
		g.updateBankroll(-1);
		assertEquals(g.getBankroll(), 0);
		g.updateBankroll(2);
		assertEquals(g.getBankroll(), 2);
		g.updateBankroll(13);
		assertEquals(g.getBankroll(), 15);
	}

}
