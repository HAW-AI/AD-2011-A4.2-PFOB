package adp_42_ch.interfaces;

import java.util.Set;

/**
 * 
 * A pseudo-random point generator
 * 
 * @author panos
 * @author olli
 */
public interface RandomPoints {

    /**
     * 
     * @return the seed used to initialize this generator
     */
    long seed();

    /**
     * 
     * @return a set of pseudo-random generated Points 
     */
    Set<Point> points();

    /**
     * 
     * @return the size of the Set that is created by this generator
     */
    int size();

    int maxX();

    int maxY();

    int minX();

    int minY();
}
