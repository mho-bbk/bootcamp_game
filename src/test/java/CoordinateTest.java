import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoordinateTest {

	@Test
	void testRandomise() {
		Coordinate coord = new Coordinate();
		
		coord.randomise(3);
		
		assertTrue(coord.getRow() < 3);
		System.out.println(coord.getRow());
		
		assertTrue(coord.getCol() >= 0);
		System.out.println(coord.getCol());
		
		coord.randomise(20);
		assertTrue(coord.getRow() < 20);
		System.out.println(coord.getRow());
		
		assertTrue(coord.getCol() >= 0);
		System.out.println(coord.getCol());
	}
	
	@Test
	void testEquality() {
		Coordinate coord1 = new Coordinate(2,1);
		Coordinate coord2 = new Coordinate(1,2);
		
		assertFalse(coord1.equals(coord2));
		
		Coordinate coord3 = new Coordinate(2,1);
		
		assertTrue(coord1.equals(coord3));
		assertTrue(!coord2.equals(coord3));
	}

}
