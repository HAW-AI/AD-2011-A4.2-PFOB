package adp_42_ch.interfaces;

import java.util.Comparator;

/**
 *
 * @author panos
 * @author olli
 */
public interface Point extends Comparable<Point> {

    public final static Comparator<Point> COMPARATOR = new adp_42_ch.implementations.comparators.LexicographicComparatorXfirst();

    public int x();

    public int y();

    public double distanceToOrigin();

    public double distanceTo(Point other);
}
