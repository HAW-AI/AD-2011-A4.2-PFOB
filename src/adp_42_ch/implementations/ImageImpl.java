/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.implementations;

import adp_42_ch.interfaces.Image;
import adp_42_ch.interfaces.Point;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author panos
 */
public class ImageImpl implements Image {

    private final Set<Point> points;

    private ImageImpl(Set<Point> points) {
        this.points = new TreeSet<Point>(points);
    }

    @Override
    public List<Point> convexHull() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Point> innerPoints() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<Point> convexHull_grahamScan() {

        return null;
    }

    static class LexicographicComparator implements Comparator<Point> {

        @Override
        public int compare(Point point1, Point point2) {
            return point1.x()==point2.x()?Integer.valueOf(point1.y()).compareTo(point2.y()):Integer.valueOf(point1.x()).compareTo(point2.x());
        }
    }

    static class DistanceComparator implements Comparator<Point> {

        @Override
        public int compare(Point point1, Point point2) {
            return point1.distance()==point2.distance()?(new LexicographicComparator()).compare(point1, point2):Double.valueOf(point1.distance()).compareTo(point2.distance());
        }
    }
}
