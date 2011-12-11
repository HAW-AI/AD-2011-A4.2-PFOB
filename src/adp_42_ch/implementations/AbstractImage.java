package adp_42_ch.implementations;

import java.util.*;

import adp_42_ch.interfaces.Image;
import adp_42_ch.interfaces.Point;

public abstract class AbstractImage implements Image {


	
	protected final List<Point> convexHull;
	
	protected final List<Point> innerPoints;
	
	protected AbstractImage(Collection<Point> points){
		this.convexHull=convexHull_(points);
		this.innerPoints=innerPoints_(points, convexHull);
	}

	protected abstract List<Point> convexHull_(Collection<Point> points);
	
	protected abstract List<Point> innerPoints_(Collection<Point> points, List<Point> convexHull);

	@Override
	public List<Point> innerPoints() {
		return innerPoints;
	}
	
	@Override
	public List<Point> convexHull() {
		return convexHull;
	}
        
        @Override
	public List<Point> innerPoints(Comparator<Point> comparator) {
		return sort(innerPoints, comparator);
	}
	
	@Override
	public List<Point> convexHull(Comparator<Point> comparator) {
		return sort(convexHull, comparator);
	}        
	
    protected static class DistanceComparator implements Comparator<Point> {
        @Override
        public int compare(Point point1, Point point2) {
            return point1.distanceToOrigin()==point2.distanceToOrigin()?(point1.compareTo(point2)):Double.valueOf(point1.distanceToOrigin()).compareTo(point2.distanceToOrigin());
        }
    }
    
    private List<Point> sort(List<Point> list, Comparator<Point> comparator) {
        SortedSet<Point> sortedSet=new TreeSet<Point>(comparator);
        sortedSet.addAll(list);
        return new ArrayList<Point>(sortedSet);
    }

}
