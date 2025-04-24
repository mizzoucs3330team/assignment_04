package hw4.maze;

import java.util.ArrayList;

public class Grid {
	private ArrayList<Row> rows;

	public Grid(ArrayList<Row> rows) {
		setRows(rows);
	}

	/**
	 * Set the grid's rows.
	 * 
	 * @param rows The rows.
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {

		String str = "Grid [rows=[";

		for (Row row : rows) {
			str += row.toString();
			str += ", ";
		}

		// Remove trailing comma.
		str = str.substring(0, str.length() - 2);

		str += "]]";

		return str;
	}

	/**
	 * Get rows.
	 * 
	 * @return Returns the rows.
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}

}
