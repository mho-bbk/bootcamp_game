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
//		System.out.println(randoRow);
		int randoCol = random.nextInt(gridSize);
//		System.out.println(randoCol);
		
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

	
	//TODO - make sure the player doesn't land on same square as treasure at start
	//TODO - make sure the player doesn't land on same square as enemy at start
}
