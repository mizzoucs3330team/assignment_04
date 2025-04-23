package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.Row;

public class Player {
	// params
	private Grid grid;
	private int rowIndex;
	private int colIndex;

	// constructor
	public Player(Grid grid, int rowIndex, int colIndex) {
		this.grid = grid;
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}

	/**
	 * Gets the current Row.
	 * 
	 * @return Returns the Row.
	 */
	public Row getCurrentRow() {
		return grid.getRows().get(rowIndex);
	}

	/**
	 * Gets the current Cell.
	 * 
	 * @return Returns the Cell.
	 */
	public Cell getCurrentCell() {
		return grid.getRows().get(rowIndex).getCells().get(colIndex);
	}

	// move method
	public boolean move(Movement m) {
		// get current row and col indicies
		int changeInRow = rowIndex;
		int changeInCol = colIndex;

		/*
		 * get a cell position and use it in switch-case to determine in adjacent cells
		 * are valid for movement (ie. not a wall)
		 */
		// TODO
		// Cell cellTest = ???

		// use them in switch case to modify position
		// TODO
		switch (m) {
			case UP:
				/*
				 * if(cellTest.getUp != CellComponents.WALL && ...){ changeInRow--; }
				 */
				// else return false;
				break;
			case DOWN:
				// if(cellTest.getDown != CellComponents.WALL && ...){}
				// else return false;
				break;
			case LEFT:
				// if(cellTest.getLeft != CellComponents.WALL && ...){}
				// else return false;
				break;
			case RIGHT:
				// if(cellTest.getRight != CellComponents.WALL && ...){}
				// else return false;
				break;
			default:
				return false;
		}

		// update position at once afterwards
		rowIndex = changeInRow;
		colIndex = changeInCol;
		return true;
	}
}
