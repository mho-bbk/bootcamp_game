import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TreasureTest {
	

	@Test
	void testCompareDistanceFromPrevious() {
		Treasure t = Mockito.mock(Treasure.class);
		Player p = Mockito.mock(Player.class);
		
		Mockito.when(t.getPosition()).thenReturn(new Coordinate(2,2));
		
		Mockito.when(p.getCurrentPosition()).thenReturn(new Coordinate(0,1));
		Mockito.when(p.getPreviousPosition()).thenReturn(new Coordinate(1,1));
		
		Mockito.when(t.compareDistanceFromPrevious(p)).thenCallRealMethod();
		Mockito.when(t.getDistanceFrom(p.getCurrentPosition())).thenCallRealMethod();
		Mockito.when(t.getDistanceFrom(p.getPreviousPosition())).thenCallRealMethod();
		
		assertEquals("Getting colder!", t.compareDistanceFromPrevious(p));
		
		System.out.println(t.compareDistanceFromPrevious(p));
	}

}
