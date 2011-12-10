package adp_42_ch.implementations;

import java.util.*;
import java.util.List;

import adp_42_ch.interfaces.Image;
import adp_42_ch.interfaces.Point;

public class ImageImplOlli implements Image {

	private final Set<Point> points;
	
	private ImageImplOlli(Collection<Point> points){
		this.points=new HashSet<Point>(points);
	}
	
	protected static ImageImplOlli create(Collection<Point> points){
		return new ImageImplOlli(points);
	}
	
	@Override
	public List<Point> convexHull() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point> innerPoints() {
		// TODO Auto-generated method stub
		return null;
	}

}
