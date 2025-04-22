package hw4.maze;

import java.util.ArrayList;
import java.util.Random;

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
        return "Grid [rows=" + rows + "]";
    }

    public static Grid createRandomGrid(int size){
        ArrayList<Row> rows = new ArrayList<>();
        Random rand = new Random();

        //TODO: implement grid creation logic

        return new Grid(rows);
    }
}
