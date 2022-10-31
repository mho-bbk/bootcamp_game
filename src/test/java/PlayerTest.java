import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testRight() {
		GridController gc = new GridController(2);
		Player kitty = new Player("Kitty", 2);

		kitty.getCurrentPosition().printCoordinate();
		gc.setPosition(kitty);
		
		gc.printGrid();
		
		System.out.println(kitty.moveRight());
		kitty.getCurrentPosition().printCoordinate();
		gc.setPosition(kitty);
		
		gc.printGrid();
	}
	
	@Test
	void testLeft() {
		int gridSize = 5;
		GridController gc = new GridController(gridSize);
		Player kitty = new Player("Kitty", gridSize);

		kitty.getCurrentPosition().printCoordinate();
		gc.setPosition(kitty);
		
		gc.printGrid();
		
		System.out.println(kitty.moveLeft());
		kitty.getCurrentPosition().printCoordinate();
		gc.setPosition(kitty);
		
		gc.printGrid();
	}
	
	@Test
	void testUp() {
		int gridSize = 5;
		GridController gc = new GridController(gridSize);
		Player kitty = new Player("Kitty", gridSize);

		kitty.getCurrentPosition().printCoordinate();
		gc.setPosition(kitty);
		
		gc.printGrid();
		
		System.out.println(kitty.moveUp());
		kitty.getCurrentPosition().printCoordinate();
		gc.setPosition(kitty);
		
		gc.printGrid();
	}
	
	@Test
	void testDown() {
		int gridSize = 5;
		GridController gc = new GridController(gridSize);
		Player kitty = new Player("Kitty", gridSize);

		kitty.getCurrentPosition().printCoordinate();
		gc.setPosition(kitty);
		
		gc.printGrid();
		
		System.out.println(kitty.moveDown());
		kitty.getCurrentPosition().printCoordinate();
		gc.setPosition(kitty);
		
		gc.printGrid();
	}

}
