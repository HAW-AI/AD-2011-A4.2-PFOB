package adp_42_ch.implementations;

import adp_42_ch.implementations.comparators.LexicographicComparatorXfirst;
import java.util.*;

import adp_42_ch.interfaces.Image;
import adp_42_ch.interfaces.Point;

public abstract class AbstractImage implements Image {

    protected final List<Point> convexHull;
    protected final List<Point> innerPoints;

    protected AbstractImage(Collection<Point> points) {
        this.convexHull = convexHull_(points);
        this.innerPoints = innerPoints_(points, convexHull);
    }

    protected abstract List<Point> convexHull_(Collection<Point> points);

//	protected abstract List<Point> innerPoints_(Collection<Point> points, List<Point> convexHull);
    protected List<Point> innerPoints_(Collection<Point> points, List<Point> convexHull) {
        List<Point> innerPoints = new LinkedList<Point>(points);
        innerPoints.removeAll(convexHull);
        return innerPoints;
    }

    @Override
    public List<Point> innerPoints() {
        return innerPoints;
    }

    @Override
    public List<Point> convexHull() {
        return convexHull;
    }

    protected static class DistanceComparator implements Comparator<Point> {

        @Override
        public int compare(Point point1, Point point2) {
            return point1.distanceToOrigin() == point2.distanceToOrigin() ? (point1.compareTo(point2)) : Double.valueOf(point1.distanceToOrigin()).compareTo(point2.distanceToOrigin());
        }
    }
    
    @Override
    public List<Point> convexHullLexicographically() {
        List<Point> result=new ArrayList<Point>(convexHull);
        Collections.sort(result, new LexicographicComparatorXfirst());
        return result;
    }
}
