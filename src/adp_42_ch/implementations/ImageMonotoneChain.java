/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.implementations;

import adp_42_ch.implementations.comparators.LexicographicComparatorXfirst;
import java.util.Arrays;
import adp_42_ch.interfaces.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

import static adp_42_ch.implementations.Images.point;

/**
 *
 * @author panos
 */
public class ImageMonotoneChain extends AbstractImage {

    private ImageMonotoneChain(Collection<Point> points) {
        super(points);
    }

    static ImageMonotoneChain create(Collection<Point> points) {
        return new ImageMonotoneChain(points);
    }

    @Override
    protected List<Point> convexHull_(Collection<Point> pointsCollection) {
        SortedSet<Point> pointSet = new TreeSet<Point>(pointsCollection);
        List<Point> pointList = new LinkedList<Point>(pointSet);
        ListIterator<Point> li = pointList.listIterator();
        Point p;
        // lower
        List<Point> lowerHull = new ArrayList<Point>();
        while (li.hasNext()) {
            p = li.next();
            while (lowerHull.size() > 1 && T(lowerHull.get(lowerHull.size() - 2), lowerHull.get(lowerHull.size() - 1), p) > 0) {
                lowerHull.remove(lowerHull.size() - 1);
            }
            lowerHull.add(p);
        }
        lowerHull.remove(lowerHull.size() - 1);


        // upper
        List<Point> upperHull = new ArrayList<Point>();
        while (li.hasPrevious()) {
            p = li.previous();
            while (upperHull.size() > 1 && T(upperHull.get(upperHull.size() - 2), upperHull.get(upperHull.size() - 1), p) > 0) {
                upperHull.remove(upperHull.size() - 1);
            }
            upperHull.add(p);
        }
        upperHull.remove(upperHull.size() - 1);

        lowerHull.addAll(upperHull);
        return lowerHull;
    }

    @Override
    protected List<Point> innerPoints_(Collection<Point> points, List<Point> convexHull) {
        List<Point> innerPoints = new ArrayList<Point>(points);
        innerPoints.removeAll(convexHull);
        return innerPoints;
    }

    private int T(Point p0, Point p1, Point p2) {
        return (p1.x() - p0.x()) * (p2.y() - p0.y()) - (p2.x() - p0.x()) * (p1.y() - p0.y());
    }

    public static void main(String[] args) {
        SortedSet<Point> hull = new TreeSet<Point>(new LexicographicComparatorXfirst());
        hull.addAll(image(point(2, 1), point(3, 2), point(2, 3), point(1, 2), point(2, 2)).convexHull());
        System.out.println("Konvexe Hülle:" + hull + "\n\n");

        hull.clear();

        hull.addAll(image(point(2, 1), point(3, 2), point(2, 3), point(1, 2), point(2, 2), point(5, 3), point(3, 4), point(2, 4), point(4, 3)).convexHull());
        System.out.println("Konvexe Hülle:" + hull + "\n\n");

    }

    public static ImageMonotoneChain image(Point... points) {
        return new ImageMonotoneChain(Arrays.asList(points));
    }
}
