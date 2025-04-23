package hw4.maze;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
	private ArrayList<Row> rows;

	public Grid(ArrayList<Row> rows) {
		setRows(rows);
	}

	public void setRows(ArrayList<Row> rows) {
		if (rows != null)
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

	public ArrayList<Row> getRows() {
		return rows;
	}

	public static Grid createRandomGrid(int size) {
		ArrayList<Row> rows = new ArrayList<>();
		Random rand = new Random();

		// TODO: implement grid creation logic

		return new Grid(rows);
	}
}
