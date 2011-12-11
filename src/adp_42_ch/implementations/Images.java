package adp_42_ch.implementations;

import java.util.Arrays;
import java.util.Collection;

import adp_42_ch.interfaces.*;

public class Images {
	
	private Images(){}
	
	public static Image image(Collection<Point> points){
		return ImageGrahamScan.create(points);
	}
	public static Image image(Point... points){
		return image(Arrays.asList(points));
	}

	public static Point point(int x, int y){
		return PointImpl.valueOf(x,y);
	}
	
	public static RandomPoints randomPoints(int numberOfPoints, int maxX, int maxY){
		return RandomPointsImpl.create(numberOfPoints, maxX, maxY);
	}
}
