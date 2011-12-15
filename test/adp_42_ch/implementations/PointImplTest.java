package adp_42_ch.implementations;

import static org.junit.Assert.*;
import static adp_42_ch.implementations.Images.*;

import org.junit.Before;
import org.junit.Test;

public class PointImplTest {

	private double delta=0.01;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDistanceToOrigin() {
		assertEquals(Math.sqrt(2), point(1,1).distanceToOrigin(), delta);
		assertEquals(Math.sqrt(13), point(3,2).distanceToOrigin(), delta);
		assertEquals(Math.sqrt(10), point(-1,3).distanceToOrigin(), delta);
	}

	@Test
	public void testDistanceTo() {
		assertEquals(Math.sqrt(2), point(1,1).distanceTo(point(2,2)), 0.01);
		assertEquals(Math.sqrt(18), point(1,1).distanceTo(point(-2,-2)), 0.01);
	}

	@Test
	public void testEqualsObject() {
		assertTrue(!point(1,2).equals(point(2,1)));
		assertTrue(!point(-1,2).equals(point(1,2)));
		assertTrue(!point(1,-2).equals(point(1,2)));
		assertTrue(point(3,10).equals(point(3,10)));
	}

	@Test
	public void testCompareTo() {
		assertEquals(-1,point(1,2).compareTo(point(1,3)));
		assertEquals(2,point(3,2).compareTo(point(1,3)));
		assertEquals(0,point(3,2).compareTo(point(3,2)));
		assertEquals(2,point(3,4).compareTo(point(3,2)));
		assertEquals(-1,point(3,4).compareTo(point(4,2)));
	}

}
