package adp_42_ch.implementations;

import java.util.*;

import adp_42_ch.implementations.comparators.AngleComparator;
import adp_42_ch.interfaces.Point;

public class ImageGrahamScan extends AbstractImage {

	
	private ImageGrahamScan(Collection<Point> points){
		super(points);
	}
	
	static ImageGrahamScan create(Collection<Point> points){
		return new ImageGrahamScan(points);
	}
	

	
	private int T(Point p0, Point p1, Point p2){
		return (p1.x()-p0.x())*(p2.y()-p0.y())-(p2.x()-p0.x())*(p1.y()-p0.y());
	}
	
	private List<Point> pointsSortedByAngle(Collection<Point> points){
		SortedSet<Point> pointsSortedLexicographically=new TreeSet<Point>(points);
//		System.out.println("Lexikographische Sortierung: "+pointsSortedLexicographically);
		Point p0=pointsSortedLexicographically.first();
		
//		System.out.println("P0: "+p0);
		
		pointsSortedLexicographically.remove(p0);
		AngleComparator angleComparator=new AngleComparator(p0);
		List<Point> pointsSortedByAngle=new LinkedList<Point>(pointsSortedLexicographically);
		Collections.sort(pointsSortedByAngle, angleComparator);
		
//		System.out.println(pointsSortedByAngle);
		
//		System.out.println("PointsToRemove: "+angleComparator.pointsToRemove());
		pointsSortedByAngle.removeAll(angleComparator.pointsToRemove());
		
//		System.out.println(pointsSortedByAngle);
		List<Point> result=new LinkedList<Point>();
		result.add(p0);
		result.addAll(pointsSortedByAngle);
		return result;
	}
	
	@Override
	protected List<Point> convexHull_(Collection<Point> points) {
		if(points.size()<4) return new ArrayList<Point>(points);
		List<Point> convexHull=pointsSortedByAngle(points);
//		System.out.println("Sortierte Punkte: "+convexHull);
		int i=1;
		while(i+1 < convexHull.size()){
			if(T(convexHull.get(i-1),convexHull.get(i+1),convexHull.get(i))<0) i++;
			else {
				convexHull.remove(i);
				if(i>1)i--;
			}
		}
		Collections.sort(convexHull);
		return convexHull;
	}

	@Override
	public List<Point> innerPoints_(Collection<Point> points, List<Point> convexHull) {
		List<Point> result=new ArrayList<Point>(points);
		result.removeAll(convexHull);
		Collections.sort(result, new DistanceComparator());
		return result;
	}
	


}
