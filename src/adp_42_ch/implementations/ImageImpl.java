/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.implementations;

import adp_42_ch.interfaces.Image;
import adp_42_ch.interfaces.Point;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author panos
 */
public class ImageImpl extends AbstractImage {

	private ImageImpl(Collection<Point> points){
		super(points);
	}
	
	static ImageImpl create(Collection<Point> points){
		return new ImageImpl(points);
	}
	

    protected List<Point> convexHull_(Collection<Point> points) {
//TODO: Not implemented
        return null;
    }
    
    protected List<Point> innerPoints_(Collection<Point> points, List<Point> convexHull) {
    	//TODO: Not implemented
    	        return null;
    	    }

    static class LexicographicComparator implements Comparator<Point> {

        @Override
        public int compare(Point point1, Point point2) {
            return point1.x()==point2.x()?Integer.valueOf(point1.y()).compareTo(point2.y()):Integer.valueOf(point1.x()).compareTo(point2.x());
        }
    }


}
