import java.util.Random;

public class Treasure implements GameEnder {
	
	private Coordinate pos = new Coordinate();
	
	private char symbol = 'T';

	private int gold;
	
	Random random = new Random();
	
	public Treasure(int gridSize) {
		pos.randomise(gridSize);
		gold = random.nextInt(1000); 
	}
	
	public int getGold() {
		return this.gold;
	}
	
	@Override
	public Coordinate getPosition() {
		return this.pos;
	}
	

	// NEW METHODS
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
}
