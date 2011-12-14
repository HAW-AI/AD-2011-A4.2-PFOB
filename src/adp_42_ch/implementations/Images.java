package adp_42_ch.implementations;

import java.util.Arrays;
import java.util.Collection;

import adp_42_ch.interfaces.*;

public class Images {
	
	private Images(){}
	
	public static Image image(Collection<Point> points){
		return ImageMonotoneChain.create(points);
	}
	public static Image image(Point... points){
		return image(Arrays.asList(points));
	}

	public static Point point(int x, int y){
		return PointImpl.valueOf(x,y);
	}
	
	public static RandomPoints randomPoints(int numberOfPoints, int minX, int maxX, int minY, int maxY){
		return RandomPointsImpl.create(numberOfPoints, minX, maxX, minY, maxY);
//		return RandomPointsDebugImpl.create(numberOfPoints, minX, maxX, minY, maxY);
	}
	
	public static RandomPoints randomPoints(long seed, int numberOfPoints, int minX, int maxX, int minY, int maxY){
		return RandomPointsImpl.create(seed, numberOfPoints, minX, maxX, minY, maxY);
//		return RandomPointsDebugImpl.create(seed, numberOfPoints, minX, maxX, minY, maxY);
	}

        public static RandomPoints NaRP(){
		return NaRP.create();
	}
        
        public static int T(Point p0, Point p1, Point p2){
		return (p1.x()-p0.x())*(p2.y()-p0.y())-(p2.x()-p0.x())*(p1.y()-p0.y());
	}
}
