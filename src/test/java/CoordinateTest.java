import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoordinateTest {

	@Test
	void test() {
		Coordinate coord = new Coordinate();
		
//		coord.randomise(3);
//		System.out.println(coord.getRow());
//		System.out.println(coord.getCol());
		
		coord.randomise(20);
		System.out.println(coord.getRow());
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
