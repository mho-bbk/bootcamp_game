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
	
	public String compareDistanceFromPrevious(Player p) {
		
//		int xCurrentDistance = this.pos.getCol() - p.getCurrentPosition().getCol();
//		int yCurrentDistance = this.pos.getRow() - p.getCurrentPosition().getRow();
//		
//		int xPreviousDistance = this.pos.getCol() - p.getPreviousPosition().getCol();
//		int yPreviousDistance = this.pos.getRow() - p.getPreviousPosition().getRow();
//		
//		double currentDistance = Math.sqrt((xCurrentDistance * xCurrentDistance) + (yCurrentDistance * yCurrentDistance));
		double currentDistance = getDistanceFrom(p.getCurrentPosition());
		
//		double previousDistance = Math.sqrt((xPreviousDistance * xPreviousDistance) + (yPreviousDistance * yPreviousDistance));
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
		int xDistance = this.pos.getCol() - c.getCol();
		int yDistance = this.pos.getRow() - c.getRow();
		
		//Use Pythagorus
		return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
		
	}
}
