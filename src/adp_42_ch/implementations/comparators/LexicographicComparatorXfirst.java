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
public final class LexicographicComparatorXfirst implements Comparator<Point> {

    @Override
    public int compare(Point point1, Point point2) {
        return point1.x() == point2.x() ? point1.y() - point2.y() : point1.x() - point2.x();
    }
}
