package hw4.game;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;
import java.util.ArrayList;
import java.util.Random;

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
		this.grid = createRandomGrid(size);
	}

	/**
	 * Create a random grid for the game.
	 * 
	 * @param size A grid size between 3 and 7.
	 * @return Returns the grid.
	 */
	public Grid createRandomGrid(int size) {
		//initialization
		if (size < 3 || size > 7) {
			return null;
		}

		ArrayList<Row> rows = new ArrayList<>();
		Random rand = new Random();

		//choose row for exit
		int exitRow = rand.nextInt(size);

		//build grid rows
		for (int y = 0; y < size; y++){
			ArrayList<Cell> cells = new ArrayList<>();

			//build cells in each row
			for (int x = 0; x < size; x++){
				//walls by default
				CellComponents left = CellComponents.WALL;
				CellComponents right = CellComponents.WALL;
				CellComponents up = CellComponents.WALL;
				CellComponents down = CellComponents.WALL;
				
				//leftmost column
				if (x == 0) {
					left = (y == exitRow) ? CellComponents.EXIT : CellComponents.WALL;
				} else {
					//copy right from left neighbor
					left = cells.get(x-1).getRight();
				}
					
				//rightmost column
				if (x == size-1) {
					right = CellComponents.WALL;
				} else {
					right = rand.nextBoolean() ? CellComponents.APERTURE : CellComponents.WALL;
				}

				//top row
				if (y == 0) {
					up = CellComponents.WALL;
				} else {
					//copy down from upper neighbor
					up = rows.get(y-1).getCells().get(x).getDown();
				}

				//bottom row
				if (y == size-1) {
					down = CellComponents.WALL;
				} else {
					down = rand.nextBoolean() ? CellComponents.APERTURE : CellComponents.WALL;
				}

				//create cell
				Cell cell = new Cell(left, right, up, down);

					
				//ensure at least one aperture per cell
				if (left != CellComponents.EXIT && 
					left != CellComponents.APERTURE && 
					right != CellComponents.APERTURE && 
					up != CellComponents.APERTURE && 
					down != CellComponents.APERTURE) 
					{
								
						//choose a valid side to convert to aperture
						ArrayList<CellComponents> candidates = new ArrayList<>();
						
						//left side (only if not exit)
						if (left != CellComponents.EXIT) {
							candidates.add(CellComponents.LEFT);
						}
						
						//right side (only if not rightmost)
						if (x < size-1) {
							candidates.add(CellComponents.RIGHT);
						}
						
						//up side (only if not top row)
						if (y > 0) {
							candidates.add(CellComponents.UP);
						}
						
						//down side (only if not bottom row)
						if (y < size-1) {
							candidates.add(CellComponents.DOWN);
						}
						
						//randomly select a candidate
						CellComponents selected = candidates.get(rand.nextInt(candidates.size()));
						
						switch(selected) {
							case LEFT:
								cell.setLeft(CellComponents.APERTURE);
								break;
							case RIGHT:
								cell.setRight(CellComponents.APERTURE);
								break;
							case UP:
								cell.setUp(CellComponents.APERTURE);
								break;
							case DOWN:
								cell.setDown(CellComponents.APERTURE);
								break;
					}
				}

				//add each cell
				cells.add(cell);
			}

			//add each row
			rows.add(new Row(cells));
		}

		//return grid
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
		for (Row row : grid.getRows()) {
			for (Cell cell : row.getCells()) {
				System.out.print("S");
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
		int rowIndex;
		for (int i = 0;; i++) {
			if (i >= grid.getRows().size()) {
				return false;
			}

			if (grid.getRows().get(i) == row) {
				rowIndex = i;
				break;
			}

		}

		Cell cell = player.getCurrentCell();
		int cellIndex;
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
		
		if (rowIndex < 0 || rowIndex >= grid.getRows().size()) return false;

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