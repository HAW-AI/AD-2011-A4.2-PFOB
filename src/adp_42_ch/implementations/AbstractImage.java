package adp_42_ch.implementations;

import java.util.*;

import adp_42_ch.interfaces.Image;
import adp_42_ch.interfaces.Point;

public abstract class AbstractImage implements Image {

//	protected final Set<Point> points;
	
	protected final List<Point> convexHull;
	
	protected final List<Point> innerPoints;
	
	protected AbstractImage(Collection<Point> points){
//		this.points=new HashSet<Point>(points);
		this.convexHull=convexHull_(points);
		this.innerPoints=innerPoints_(points, convexHull);
	}

	protected abstract List<Point> convexHull_(Collection<Point> points);
	
	protected abstract List<Point> innerPoints_(Collection<Point> points, List<Point> convexHull);

	@Override
	public List<Point> innerPoints() {
		return innerPoints;
	}
	
	@Override
	public List<Point> convexHull() {
		return convexHull;
	}

}
