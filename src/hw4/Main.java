package hw4;

import hw4.game.Game;

public class Main {

	public static void main(String[] args) {

		Game game = new Game(7); // 3-7
		System.out.println("Game Start!");

		System.out.println("");
		game.printGrid();
	}

}
