/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.interfaces;

import java.util.List;

/**
 *
 * @author panos
 * @author olli
 */
public interface Image {

    public List<Point> convexHull();
    
    public List<Point> convexHullLexicographically();

    public List<Point> innerPoints();
}
