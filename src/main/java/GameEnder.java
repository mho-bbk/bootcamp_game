

public interface GameEnder {
	
	public Coordinate getPosition();
	
	public default boolean checkWin(Player p) {
		return getPosition().equals(p.getCurrentPosition());
	}
	
	public default String compareDistanceFromPrevious(Player p) {

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
	
	public default double getDistanceFrom(Coordinate c) {
		int xDistance = getPosition().getCol() - c.getCol();
		int yDistance = getPosition().getRow() - c.getRow();
		
		//Use Pythagorus
		return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
		
	}

}
