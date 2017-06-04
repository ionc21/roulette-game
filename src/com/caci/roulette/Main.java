package com.caci.roulette;

import com.caci.roulette.game.Game;
import com.caci.roulette.model.Player;

public class Main {
	public static void main(final String[] args) throws Exception {
		Game game = new Game();
		Player player = new Player("Robert", 1000);

		System.out.println(
				"Hello " + player.getName() + ", let's play " + game.getName());
		System.out.println();

		do {
			game.play(player);
		} while (player.isSolvent());

		System.out.println();
		System.out.println(
				"Goodbye " + player.getName() + ", thanks for playing!");
	}
}
