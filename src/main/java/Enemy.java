
public class Enemy extends IsPersonalisable {
	
	private Coordinate pos = new Coordinate();

	public Enemy(String name, int gridSize) {
		setName(name);
		setSymbol('E');
		
		pos.randomise(gridSize);
	}
	
	public Coordinate getPosition() {
		return this.pos;
	}
	
	public boolean checkWin(Player p) {
		return this.getPosition().equals(p.getCurrentPosition());
	}
	
	public String compareDistanceFromPrevious(Player p) {

		double currentDistance = getDistanceFrom(p.getCurrentPosition());
		double previousDistance = getDistanceFrom(p.getPreviousPosition());
		
		String res = "";
		if (currentDistance > previousDistance) {
			res = "Getting colder!";
		} else if (currentDistance < previousDistance) {
			res = "Getting warmer!";
		} else {
			//they are the same
			res = "You are the same distance from the treasure :(";
		}
		
		return res;
	}
	
	private double getDistanceFrom(Coordinate c) {
		int xDistance = getPosition().getCol() - c.getCol();
		int yDistance = getPosition().getRow() - c.getRow();
		
		//Use Pythagorus
		return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
		
	}
}
