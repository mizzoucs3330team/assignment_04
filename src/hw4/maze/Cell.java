package hw4.maze;

public class Cell {
    private CellComponents left, right, up, down;

    public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }

    public CellComponents getLeft() { return left; }
    public CellComponents getRight() { return right; }
    public CellComponents getUp() { return up; }
    public CellComponents getDown() { return down; }
}
    
}
