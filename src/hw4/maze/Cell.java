package hw4.maze;

public class Cell {
	private CellComponents left, right, up, down;

	public Cell(CellComponents l, CellComponents r, CellComponents u, CellComponents d) {
		this.left = l;
		this.right = r;
		this.up = u;
		this.down = d;
	}

	@Override
	public String toString() {
		return "Cell [left=" + getLeft() + ", right=" + getRight() + ", up=" + getUp() + ", down=" + getDown() + "]";
	}

	// get/set
	public CellComponents getLeft() {
		return left;
	}

	public CellComponents getRight() {
		return right;
	}

	public CellComponents getUp() {
		return up;
	}

	public CellComponents getDown() {
		return down;
	}

	public void setLeft(CellComponents l) {
		if (l == null) {
			this.left = CellComponents.WALL;
			return;
		}

		this.left = l;
	}

	public void setRight(CellComponents r) {
		if (r == null) {
			this.right = CellComponents.WALL;
			return;
		}

		this.right = r;
	}

	public void setUp(CellComponents u) {
		if (u == null) {
			this.up = CellComponents.WALL;
			return;
		}

		this.up = u;
	}

	public void setDown(CellComponents d) {
		if (d == null) {
			this.down = CellComponents.WALL;
			return;
		}

		this.down = d;
	}

}
