package adp_42_ch.implementations;

import java.util.*;

import adp_42_ch.implementations.comparators.AngleComparator;
import adp_42_ch.interfaces.Point;
import static adp_42_ch.implementations.Images.*;

public class ImageGrahamScan extends AbstractImage {

	
	private ImageGrahamScan(Collection<Point> points){
		super(points);
	}
	
	static ImageGrahamScan create(Collection<Point> points){
		return new ImageGrahamScan(points);
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
		if(points.size()<3) return new ArrayList<Point>(points);
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
		return convexHull;
	}
	


}
