package hw4.game;

import hw4.maze.Grid;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	private Grid grid;

	/**
	 * Create a new game with an existing grid.
	 * 
	 * @param grid The grid to be played on.
	 */
	public Game(Grid grid) {
		this.grid = grid;
	}

	/**
	 * Create a new game with a random grid.
	 * 
	 * @param size The size of the grid to be made.
	 */
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

	/**
	 * Move the player.
	 * 
	 * @param movement LEFT, RIGHT, UP, or DOWN.
	 * @param player   The player object.
	 * 
	 * @return Returns true on success, false otherwise.
	 */
	public boolean play(Movement movement, Player player) {
		if (movement == null || player == null)
			return false;

		switch (movement) {
			case UP: {
				// return player.moveUp(grid);
				break;
			}
			case DOWN: {
				// return player.moveDown(grid);
				break;
			}
			case LEFT: {
				// return player.moveLeft(grid);
				break;
			}
			case RIGHT: {
				// return player.moveRight(grid);
				break;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid.toString() + "]";
	}
}