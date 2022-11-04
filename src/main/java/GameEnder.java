
public interface GameEnder {
	
	public Coordinate getPosition();
	public char getSymbol();
	
	public default boolean checkWin(Player p) {
		return getPosition().equals(p.getCurrentPosition());
	}
	
	public default String compareDistanceFromPrevious(Player p) {

		double currentDistance = getDistanceFrom(p.getCurrentPosition());
		System.out.println("Current dist: " + currentDistance);
		double previousDistance = getDistanceFrom(p.getPreviousPosition());
		System.out.println("Previous dist: " + previousDistance);
		
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
	
	public default double getDistanceFrom(Coordinate c) {
		int xDistance = getPosition().getCol() - c.getCol();
		System.out.println("xDistance: " + xDistance);
		int yDistance = getPosition().getRow() - c.getRow();
		System.out.println("yDistance: " + yDistance);
		
		//Use Pythagorus
		return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
		
	}

}
