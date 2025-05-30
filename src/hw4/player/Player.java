package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	private Row row;
	private Cell cell;

	/**
	 * Create a Player object.
	 * 
	 * @param r The Row.
	 * @param c The Cell.
	 */
	public Player(Row row, Cell cell) {
		this.row = row;
		this.cell = cell;
	}

	/**
	 * Gets the current Row.
	 * 
	 * @return Returns the Row.
	 */
	public Row getCurrentRow() {
		return row;
	}

	/**
	 * Gets the current Cell.
	 * 
	 * @return Returns the Cell.
	 */
	public Cell getCurrentCell() {
		return cell;
	}

	/**
	 * Sets the current Row.
	 * 
	 * @return void
	 */
    public void setRow(Row row) {
        this.row = row;
    }

	/**
	 * Sets the current Cell.
	 * 
	 * @return void
	 */
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    @Override
	public String toString() {
		Row currentRow = getCurrentRow();
		Cell currentCell = getCurrentCell();

		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}

}
