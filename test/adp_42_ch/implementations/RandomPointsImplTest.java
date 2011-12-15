package adp_42_ch.implementations;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import adp_42_ch.interfaces.Point;
import static adp_42_ch.implementations.Images.*;

public class RandomPointsImplTest {

	
	@Before
	public void setUp() throws Exception {
		
	}



	@Test
	public void testPoints() {
		Set<Point> points=randomPoints(10,-10,20,40,70).points();
		for(Point p: points){
			assertTrue(p.x()>=-10 && p.x()<=20 && p.y()>=40 && p.y()<=70);
		}
	}

	@Test
	public void testSize() {
		assertEquals(10,randomPoints(10, 1,10,1,10).size());
		assertEquals(1,randomPoints(1, 1,1,2,2).size());
		assertEquals(0,randomPoints(2, 1,1,2,2).size());
	}

	@Test
	public void testMaxX() {
		assertEquals(2,randomPoints(2, 1,2,3,4).maxX());
		assertEquals(NaRP(),randomPoints(10, Integer.MIN_VALUE,10,3,4));
		assertEquals(NaRP(),randomPoints(10, 1,Integer.MAX_VALUE,3,4));
	}

	@Test
	public void testMaxY() {
		assertEquals(4,randomPoints(2, 1,2,3,4).maxY());
	}

	@Test
	public void testMinX() {
		assertEquals(1,randomPoints(4, 1,2,3,4).minX());
	}

	@Test
	public void testMinY() {
		assertEquals(3,randomPoints(4, 1,2,3,4).minY());
	}

}
