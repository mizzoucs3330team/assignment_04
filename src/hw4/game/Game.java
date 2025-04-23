package hw4.game;

import hw4.maze.Grid;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	private Grid grid;

	/**
	 * Create a new game.
	 * 
	 * @param grid The grid to be played on.
	 */
	public Game(Grid grid) {
		this.grid = grid;
	}

	public Game(int size) {
		if (size == 3 || size == 5) {
			this.grid = Grid.createRandomGrid(size);
		} else {
			this.grid = null;
		}
	}

	/**
	 * Get the game's grid.
	 * 
	 * @return Returns the grid.
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * Set the game's grid.
	 * 
	 * @param grid The grid.
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public boolean play(Movement movement, Player player) {
		if (movement == null || player == null)
			return false;

		switch (movement) {
			// TODO: player movement methods not yet implemented
			case UP:
				// return player.moveUp(grid);
			case DOWN:
				// return player.moveDown(grid);
			case LEFT:
				// return player.moveLeft(grid);
			case RIGHT:
				// return player.moveRight(grid);
			default:
				return false;
		}
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid.toString() + "]";
	}
}