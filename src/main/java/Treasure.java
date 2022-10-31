import java.util.Random;

public class Treasure {
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
