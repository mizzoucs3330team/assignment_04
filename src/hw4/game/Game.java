package hw4.game;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
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
	 * @return Returns true on successful move, false otherwise.
	 */
	public boolean play(Movement movement, Player player) {
		if (movement == null || player == null)
			return false;

		boolean fail = false;

		Row row = player.getCurrentRow();
		int rowIndex;
		for (int i = 0;; i++) {
			if (grid.getRows().get(i) == row) {
				rowIndex = i;
				break;
			}

			if (i >= grid.getRows().size()) {
				return false;
			}
		}

		Cell cell = player.getCurrentCell();
		int cellIndex;
		for (int i = 0;; i++) {
			if (row.getCells().get(i) == cell) {
				cellIndex = i;
				break;
			}

			if (i >= row.getCells().size()) {
				return false;
			}
		}

		switch (movement) {
			case LEFT: {
				if (cell.getLeft() == CellComponents.WALL) {
					return false;
				}

				cellIndex--;

				break;
			}
			case RIGHT: {
				if (cell.getRight() == CellComponents.WALL) {
					return false;
				}

				cellIndex++;

				break;
			}
			case DOWN: {
				if (cell.getDown() == CellComponents.WALL) {
					return false;
				}

				rowIndex--;

				break;
			}
			case UP: {
				if (cell.getUp() == CellComponents.WALL) {
					return false;
				}

				rowIndex++;

				break;
			}
		}

		row = grid.getRows().get(rowIndex);
		player.setRow(row);
		cell = row.getCells().get(cellIndex);
		player.setCell(cell);

		return true;
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid.toString() + "]";
	}
}