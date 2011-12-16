package adp_42_ch.interfaces;

import java.util.List;

/**
 * A set of Points in a 2-dimensional coordinate system
 * 
 * @author panos
 * @author olli
 */
public interface Image {

    /**
     * 
    @return A list of Points forming the convex hull
     */
    public List<Point> convexHull();

    /**
     * 
    @return A list of Points forming the convex hull in lexicographical order
     */
    public List<Point> convexHullLexicographically();

    /**
     * 
    @return A list of all points that do not form the convex hull
     */
    public List<Point> innerPoints();
}
