
public class Enemy extends IsPersonalisable implements GameEnder {
	
	private Coordinate pos = new Coordinate();

	public Enemy(String name, int gridSize) {
		setName(name);
		setSymbol('E');
		
		pos.randomise(gridSize);
	}
	
	@Override
	public Coordinate getPosition() {
		return this.pos;
	}
	
}
