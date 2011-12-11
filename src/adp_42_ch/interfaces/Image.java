/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.interfaces;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author panos
 */
public interface Image {

    public List<Point> convexHull();

    public List<Point> innerPoints();

    public List<Point> convexHull(Comparator<Point> comparator);

    public List<Point> innerPoints(Comparator<Point> comparator);
}
