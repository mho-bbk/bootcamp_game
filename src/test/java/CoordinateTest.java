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

}
