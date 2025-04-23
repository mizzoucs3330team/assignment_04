package hw4.maze;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class Grid {
    private ArrayList<Row> rows;

    public Grid(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    @Override
    public String toString() {

		String str = "Grid [rows=[";

		for (Row row : rows) {
			str += row.toString();
		}

		str += "]]";

		return str;
    }

    public static Grid createRandomGrid(int size){
        ArrayList<Row> rows = new ArrayList<>();
        Random rand = new Random();

        //TODO: implement grid creation logic

        return new Grid(rows);
    }
}
