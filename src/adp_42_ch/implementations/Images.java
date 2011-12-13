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
}
