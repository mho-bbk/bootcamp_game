import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreasureTest {

	@Test
	void testDistanceFrom() {
		int gridSize = 4;
//		GridController gc = new GridController(gridSize);
		
		Treasure t = new Treasure(gridSize);
		System.out.println("Test gold: " + t.getGold());
		System.out.println("Treasure position: " + t.getPosition());
		
		//TODO - mock player coordinates - current & previous
		Player p = new Player("Donald", gridSize);
		p.getCurrentPosition().printCoordinate();

//		gc.printGrid();
		
		System.out.println(t.compareDistanceFromPrevious(p));
	}

}
