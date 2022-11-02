import java.util.Random;

public class Coordinate {
	private int row;
	private int col;
	
	Random random = new Random();
	
	public Coordinate() {
		//empty 
	}
	
	public Coordinate(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public void randomise(int gridSize) {
		int randoRow = random.nextInt(gridSize);
		int randoCol = random.nextInt(gridSize);
		
		setRow(randoRow);
		setCol(randoCol);
	}
	
	
	public void printCoordinate() {
		System.out.println("Coordinate: " + toString());
	}
	
	@Override
	public String toString() {
		return "(" + getRow() + ", " + getCol() + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Coordinate coord = (Coordinate) o;
		
		return this.getRow() == coord.getRow() &&
				this.getCol() == coord.getCol();
	}
}
