package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	private Grid grid;
	private int rowIndex = -1;
	private int cellIndex = -1;

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
		this.grid = createRandomGrid(size);
	}

	/**
	 * Create a random grid for the game.
	 * 
	 * @param size A grid size between 3 and 7.
	 * @return Returns the grid.
	 */
	public Grid createRandomGrid(int size) {
		Random rand = new Random();
		// initialization
		if (size < 3 || size > 7) {
			return null;
		}

		ArrayList<Row> rows = new ArrayList<>();

		// build grid rows
		for (int ri = 0; ri < size; ri++) {
			ArrayList<Cell> cells = new ArrayList<>();

			// build cells in each row
			for (int ci = 0; ci < size; ci++) {
				CellComponents left = CellComponents.WALL;
				CellComponents right = CellComponents.WALL;
				CellComponents up = CellComponents.WALL;
				CellComponents down = CellComponents.WALL;

				// not top
				if (ri != 0) {
					// copy down from upper neighbor
					up = rows.get(ri - 1).getCells().get(ci).getDown();
				}

				// not bottom
				if (ri != size - 1) {
					down = rand.nextBoolean() ? CellComponents.APERTURE : CellComponents.WALL;
				}

				// not left
				if (ci != 0) {
					// copy right from left neighbor
					left = cells.get(ci - 1).getRight();
				}

				// not right
				if (ci != size - 1) {
					right = rand.nextBoolean() ? CellComponents.APERTURE : CellComponents.WALL;
				}

				// create cell
				Cell cell = new Cell(left, right, up, down);

				// add each cell
				cells.add(cell);
			}

			// add each row
			rows.add(new Row(cells));
		}

		// Grid Checks
		for (int ri = 0; ri < size; ri++) {
			for (int ci = 0; ci < size; ci++) {

				Cell cell = rows.get(ri).getCells().get(ci);

				// If no aperture
				if (cell.getUp() != CellComponents.APERTURE && cell.getDown() != CellComponents.APERTURE
						&& cell.getLeft() != CellComponents.APERTURE && cell.getRight() != CellComponents.APERTURE) {
					if (ri == 0) {
						cell.setDown(CellComponents.APERTURE);
						rows.get(ri + 1).getCells().get(ci).setUp(CellComponents.APERTURE);
					} else {
						cell.setUp(CellComponents.APERTURE);
						rows.get(ri - 1).getCells().get(ci).setDown(CellComponents.APERTURE);
					}
				}

			}
		}

		// EVAN -- DOUBLE CHECK CONSIST
//		for (int y = 0; y < size; y++) {
//			for (int x = 0; x < size; x++) {
//				Cell cell = rows.get(y).getCells().get(x);
//
//				// top row
//				if (y == 0) {
//					// left wall
//					if (x == 0) {
//						if (rows.get(y + 1).getCells().get(x).getUp() == CellComponents.APERTURE)
//							cell.setDown(CellComponents.APERTURE); // Down
//						if (rows.get(y).getCells().get(x - 1).getRight() == CellComponents.APERTURE)
//							cell.setLeft(CellComponents.APERTURE); // Left
//					}
//					// right wall
//					else if (x == size - 1) {
//						if (rows.get(y + 1).getCells().get(x).getUp() == CellComponents.APERTURE)
//							cell.setDown(CellComponents.APERTURE); // Down
//						if (rows.get(y).getCells().get(x + 1).getLeft() == CellComponents.APERTURE)
//							cell.setRight(CellComponents.APERTURE); // Right
//					}
//					// else
//					else {
//						if (rows.get(y + 1).getCells().get(x).getUp() == CellComponents.APERTURE)
//							cell.setDown(CellComponents.APERTURE); // Down
//						if (rows.get(y).getCells().get(x - 1).getRight() == CellComponents.APERTURE)
//							cell.setLeft(CellComponents.APERTURE); // Left
//						if (rows.get(y).getCells().get(x + 1).getLeft() == CellComponents.APERTURE)
//							cell.setRight(CellComponents.APERTURE); // Right
//					}
//				}
//				// bottom row
//				else if (y == size - 1) {
//					// left wall
//					if (x == 0) {
//						if (rows.get(y - 1).getCells().get(x).getDown() == CellComponents.APERTURE)
//							cell.setUp(CellComponents.APERTURE); // Up
//						if (rows.get(y).getCells().get(x - 1).getRight() == CellComponents.APERTURE)
//							cell.setLeft(CellComponents.APERTURE); // Left
//					}
//					// right wall
//					else if (x == size - 1) {
//						if (rows.get(y - 1).getCells().get(x).getDown() == CellComponents.APERTURE)
//							cell.setUp(CellComponents.APERTURE); // Up
//						if (rows.get(y).getCells().get(x + 1).getLeft() == CellComponents.APERTURE)
//							cell.setRight(CellComponents.APERTURE); // Right
//					}
//					// else
//					else {
//						if (rows.get(y - 1).getCells().get(x).getDown() == CellComponents.APERTURE)
//							cell.setUp(CellComponents.APERTURE); // Up
//						if (rows.get(y).getCells().get(x - 1).getRight() == CellComponents.APERTURE)
//							cell.setLeft(CellComponents.APERTURE); // Left
//						if (rows.get(y).getCells().get(x + 1).getLeft() == CellComponents.APERTURE)
//							cell.setRight(CellComponents.APERTURE); // Right
//					}
//				}
//				// middles
//				else {
//					if (rows.get(y - 1).getCells().get(x).getDown() == CellComponents.APERTURE)
//						cell.setUp(CellComponents.APERTURE); // Up
//					if (rows.get(y + 1).getCells().get(x).getUp() == CellComponents.APERTURE)
//						cell.setDown(CellComponents.APERTURE); // Down
//					if (rows.get(y).getCells().get(x - 1).getRight() == CellComponents.APERTURE)
//						cell.setLeft(CellComponents.APERTURE); // Left
//					if (rows.get(y).getCells().get(x + 1).getDown() == CellComponents.APERTURE)
//						cell.setRight(CellComponents.APERTURE); // Right
//				}
//			}
//		}

		// Create the exit.
		int exitRowIdx = rand.nextInt(size);
		rows.get(exitRowIdx).getCells().get(0).setLeft(CellComponents.EXIT);

		// return grid
		return new Grid(rows);

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

	public void printGrid() {
		for (int ri = 0; ri < grid.getRows().size(); ri++) {
			Row row = grid.getRows().get(ri);
			for (int ci = 0; ci < row.getCells().size(); ci++) {
				if (ri == rowIndex && ci == cellIndex) {
					System.out.print("A");
				} else if (ci == 0 && row.getCells().get(ci).getLeft() == CellComponents.EXIT) {
					System.out.print("E");
				} else {
					System.out.print("S");
				}
			}
			System.out.println();
		}
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

		Row row = player.getCurrentRow();
		rowIndex = 0;
		for (int i = 0;; i++) {
			if (i >= grid.getRows().size()) {
				return false;
			}

			if (grid.getRows().get(i) == row) {
				rowIndex = i;
				break;
			}

		}

		cellIndex = 0;
		Cell cell = player.getCurrentCell();
		for (int i = 0;; i++) {
			if (i >= row.getCells().size()) {
				return false;
			}

			if (row.getCells().get(i) == cell) {
				cellIndex = i;
				break;
			}
		}

		switch (movement) {
			case Movement.LEFT: {
				if (cell.getLeft() == CellComponents.WALL) {
					return false;
				}

				cellIndex--;

				break;
			}
			case Movement.RIGHT: {
				if (cell.getRight() == CellComponents.WALL) {
					return false;
				}

				cellIndex++;

				break;
			}
			case Movement.DOWN: {
				if (cell.getDown() == CellComponents.WALL) {
					return false;
				}

				rowIndex++;

				break;
			}
			case Movement.UP: {
				if (cell.getUp() == CellComponents.WALL) {
					return false;
				}

				rowIndex--;

				break;
			}
		}

		if (movement == Movement.LEFT && cell.getLeft() == CellComponents.EXIT) {
			// EXIT LOGIC
			System.out.println("Congratulations, you escaped!");
			return true;
		}

		if (rowIndex < 0 || rowIndex >= grid.getRows().size()) {
			return false;
		}
		if (cellIndex < 0 || cellIndex >= row.getCells().size()) {
			return false;
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