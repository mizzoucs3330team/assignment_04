package hw4.maze;

import java.util.ArrayList;

public class Row {
	private ArrayList<Cell> cells;

	/**
	 * Create a Row.
	 * 
	 * @param cells The row's cells.
	 */
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	/**
	 * Get row cells.
	 * 
	 * @return Returns the cells.
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cellList) {
		if (cells != null)
			this.cells = cellList;
	}

	public String toString() {
		String str = "Row [cells=[";

		for (Cell cell : cells) {
			str += cell.toString() + ", ";
		}

		// Remove trailing comma.
		str = str.substring(0, str.length() - 2);

		str += "]]";

		return str;
	}
}