package hw4.maze;

public class Cell {
	private CellComponents left, right, up, down;

	/**
	 * Create a cell.
	 * 
	 * @param l Left Component
	 * @param r Right Component
	 * @param u Top Component
	 * @param d Bottom Component
	 */
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

	/**
	 * Get the left component.
	 * 
	 * @return Returns the left component.
	 */
	public CellComponents getLeft() {
		return left;
	}

	/**
	 * Get the right component.
	 * 
	 * @return Returns the right component.
	 */
	public CellComponents getRight() {
		return right;
	}

	/**
	 * Get the top component.
	 * 
	 * @return Returns the top component.
	 */
	public CellComponents getUp() {
		return up;
	}

	/**
	 * Get the bottom component.
	 * 
	 * @return Returns the component.
	 */
	public CellComponents getDown() {
		return down;
	}

	/**
	 * Set the left component.
	 * 
	 * @param l The left component.
	 */
	public void setLeft(CellComponents l) {
		if (l == null) {
			this.left = CellComponents.WALL;
			return;
		}

		this.left = l;
	}

	/**
	 * Set the right component.
	 * 
	 * @param l The right component.
	 */
	public void setRight(CellComponents r) {
		if (r == null) {
			this.right = CellComponents.WALL;
			return;
		}

		this.right = r;
	}

	/**
	 * Set the upper component.
	 * 
	 * @param l The upper component.
	 */
	public void setUp(CellComponents u) {
		if (u == null) {
			this.up = CellComponents.WALL;
			return;
		}

		this.up = u;
	}

	/**
	 * Set the bottom component.
	 * 
	 * @param l The bottom component.
	 */
	public void setDown(CellComponents d) {
		if (d == null) {
			this.down = CellComponents.WALL;
			return;
		}

		this.down = d;
	}

}
