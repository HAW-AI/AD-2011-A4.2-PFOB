package adp_42_ch.interfaces;

import java.util.Comparator;

/**
 *
 * A Point in 2-dimensional coordinate system
 * 
 * @author panos
 * @author olli
 */
public interface Point extends Comparable<Point> {

    /**
     * The comparator used to define a natural order
     */
    public final static Comparator<Point> COMPARATOR = new adp_42_ch.implementations.comparators.LexicographicComparatorXfirst();

    /**
     * 
    @return the x-Value of this Point
     */
    public int x();

    /**
     * 
    @return the y-Value of this Point
     */
    public int y();

    /**
     * 
    @return the distance to the coordinate system origin
     */
    public double distanceToOrigin();

    /**
     * 
    @param other the Point to calculate the distance
     * 
    @return the distance to the Point other
     */
    public double distanceTo(Point other);
}
