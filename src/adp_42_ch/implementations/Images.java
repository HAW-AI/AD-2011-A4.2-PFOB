package adp_42_ch.implementations;

import java.util.Collection;

import adp_42_ch.interfaces.*;

public class Images {
	
	private Images(){}
	
	public static Image image(Collection<Point> points){
		return ImageImplOlli.create(points);
	}

	public static Point point(int x, int y){
		return PointImpl.valueOf(x,y);
	}
}
