package adp_42_ch.implementations;

import static adp_42_ch.implementations.Images.imageMonotoneChain;
import static adp_42_ch.implementations.Images.point;
import static adp_42_ch.implementations.Images.randomPoints;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import adp_42_ch.interfaces.Image;
import adp_42_ch.interfaces.Point;

public class ImageMonotoneChainTest {

	@Test
	public void testInnerPoints() {
		assertEquals(new ArrayList<Point>(),imageMonotoneChain(Arrays.asList(point(0,1),point(2,3))).innerPoints());
		assertEquals(new ArrayList<Point>(Arrays.asList(point(1,1))),imageMonotoneChain(Arrays.asList(point(0,0),point(1,1),point(2,2))).innerPoints());
		
	}

	@Test
	public void testConvexHull() {
		assertEquals(new ArrayList<Point>(Arrays.asList(point(0,1),point(2,3))),imageMonotoneChain(Arrays.asList(point(0,1),point(2,3))).convexHull());
		Set<Point> points=randomPoints(20,-100,100,-100,100).points();
		Image image=imageMonotoneChain(points);
		Set<Point> testSet=new HashSet<Point>(image.convexHull());
		testSet.addAll(image.innerPoints());
		assertEquals(points, testSet);
		Set<Point> points2=new HashSet<Point>(Arrays.asList(point(-1,-1),point(1,1),point(3,-1),point(-1,3),point(3,3)));
		Set<Point>convexHull=new HashSet<Point>(points2);
		convexHull.remove(point(1,1));
		assertEquals(convexHull,new HashSet<Point>(imageMonotoneChain(points2).convexHull()));
	}

	@Test
	public void testConvexHullLexicographically() {
		assertEquals(new ArrayList<Point>(Arrays.asList(point(0,1),point(1,1),point(2,3))),imageMonotoneChain(Arrays.asList(point(0,1),point(2,3),point(1,1))).convexHullLexicographically());
	}

}
