package adp_42_ch.interfaces;

import java.util.Set;

public interface RandomPoints {

	long seed();
	
	Set<Point> points();
	
	int size();
	
	int maxX();
	
	int maxY();
	
	int minX();
	
	int minY();
	
}
