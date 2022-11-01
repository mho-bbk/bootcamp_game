import java.util.Random;

public class Enemy {
	private Coordinate pos = new Coordinate();
	private String message;
	private String name;
	private char symbol = 'E';
	
	Random random = new Random();

	public Enemy(String name, int gridSize) {
		pos.randomise(gridSize);
		setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public char getSymbol() {
		   return this.symbol;
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
