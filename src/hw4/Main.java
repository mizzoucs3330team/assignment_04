package hw4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Main {

	public static void main(String[] args) {

		System.out.println("===================================");
		System.out.println();
		Game game = new Game(3); // 3-7
		Grid grid = game.getGrid();
		ArrayList<Row> rows = grid.getRows();
		Player player = new Player(rows.getLast(), rows.getLast().getCells().getLast());
		game.play(Movement.DOWN, player);
		System.out.println("Game Start!");

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println();
			game.printGrid();
			System.out.println();

			System.out.println("Type a movement. (WASD)");

			String input = s.nextLine();
			input = input.toUpperCase();
			if (input.equals("A"))
				input = "LEFT";
			else if (input.equals("D"))
				input = "RIGHT";
			else if (input.equals("W"))
				input = "UP";
			else if (input.equals("S"))
				input = "DOWN";

			System.out.println("===================================");
			System.out.println();

			boolean success;
			if (input.equals("LEFT"))
				success = game.play(Movement.LEFT, player);
			else if (input.equals("RIGHT"))
				success = game.play(Movement.RIGHT, player);
			else if (input.equals("UP"))
				success = game.play(Movement.UP, player);
			else if (input.equals("DOWN"))
				success = game.play(Movement.DOWN, player);
			else {
				System.out.println("Inavlid Input");
				continue;
			}

			String str;
			if (success) {
				str = "Moved!";
			} else {
				str = "BONK!";
			}
			int num = new Random().nextInt(10);
			for (int i = 0; i < num; i++) {
				str += "!";
			}
			System.out.println(str);

		}

	}

}
