import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridControllerTest {

	@Test
	void test() {
		GridController grid = new GridController(4);
		Player rizwan = new Player("Riz", 4);
		
		grid.setPosition(rizwan);
		grid.printGrid();
	}

}
