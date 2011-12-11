/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.implementations.comparators;

import adp_42_ch.interfaces.Point;
import java.util.Comparator;

/**
 *
 * @author panos
 */
public final class DistanceComparator implements Comparator<Point> {

    @Override
    public int compare(Point point1, Point point2) {
        return point1.distanceToOrigin() == point2.distanceToOrigin() ? new LexicographicComparatorXfirst().compare(point1, point2) : (int) Math.signum(point1.distanceToOrigin() - point2.distanceToOrigin());
    }
}
