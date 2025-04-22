package hw4.maze;
import java.util.ArrayList;

public class Row {
    //constructors
    private ArrayList<Cell> cells;

    public Row(ArrayList<Cell> cells){
        this.cells = cells;
    }
    
    //get/set
    public ArrayList<Cell> getCells(){
        return cells;
    }

    public void setCells(ArrayList<Cell> cellList){
        this.cells = cellList;
    }
}
