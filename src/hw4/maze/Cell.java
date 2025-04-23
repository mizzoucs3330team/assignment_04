package hw4.maze;

public class Cell {
    //constructors
    private CellComponents left, right, up, down;

    public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }

    @Override
    public String toString(){
        return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
    }

    //get/set
    public CellComponents getLeft() { return left; }
    public CellComponents getRight() { return right; }
    public CellComponents getUp() { return up; }
    public CellComponents getDown() { return down; }
    
    public void setLeft(CellComponents left) { this.left = left; }
    public void setRight(CellComponents right) { this.right = right; }
    public void setUp(CellComponents up) { this.up = up; }
    public void setDown(CellComponents down) { this.down = down; }

}
