package adp_42_ch.implementations;

import java.util.HashSet;

import java.util.Set;
import static adp_42_ch.implementations.Images.*;

import adp_42_ch.interfaces.Point;
import adp_42_ch.interfaces.RandomPoints;
/*
 * Diese Klasse erzeugt vordefinierte Bilder zu Testzwecken
 * 
 */
public class RandomPointsDebugImpl implements RandomPoints {

	private final long seed;
	
	private final int maxX;
	
	private final int maxY;
	
	private final int minX;
	
	private final int minY;
	
	private final Set<Point> points;
	
	private RandomPointsDebugImpl (long seed, int numberOfPoints, int minX, int maxX, int minY, int maxY){
		this.seed=seed;
		this.points=calculatePoints(numberOfPoints, minX, maxX, minY, maxY);
		this.maxX=maxX;
		this.maxY=maxY;
		this.minX=minX;
		this.minY=minY;
	}
	protected static RandomPoints create(int numberOfPoints, int minX, int maxX, int minY, int maxY){
		return create(System.currentTimeMillis(), numberOfPoints, minX, maxX, minY, maxY);
	}
	
	static RandomPoints create(long seed, int numberOfPoints, int minX, int maxX, int minY, int maxY){
		if(numberOfPoints<=0 || minX>maxX || minY>maxY || 
				maxX==Integer.MAX_VALUE || maxY==Integer.MAX_VALUE || maxX+1-minX<0 || maxY+1-minY<0
				|| ((long)(maxX+1-minX)*(long)(maxY+1-minY))<numberOfPoints) return NaRP();
		return new RandomPointsDebugImpl(seed, numberOfPoints, minX, maxX, minY, maxY);
	}
	
	private Set<Point> calculatePoints(int numberOfPoints, int minX, int maxX, int minY, int maxY) {
		Set<Point> result=new HashSet<Point>();
//		for(int i=0; i<numberOfPoints; i++){
//			result.add(point(random.nextInt(maxX-minX+1)+minX, random.nextInt(maxY-minY+1)+minY));
//		}
                switch(numberOfPoints) {
                    case 3: {
                        result.add(point(-50,-50));
                    }
                    case 2: {
                        result.add(point(0,0));
                    }
                    case 1: {
                        result.add(point(50,50));
                    }
                    default:
                }
                return result;
        }


	@Override
	public long seed() {
		return seed;
	}

	@Override
	public Set<Point> points() {
		return new HashSet<Point>(points);
	}

	@Override
	public int size() {
		return points.size();
	}

	@Override
	public int maxX() {
		return maxX;
	}

	@Override
	public int maxY() {
		return maxY;
	}
	@Override
	public int minX() {
		return minX;
	}
	@Override
	public int minY() {
		return minY;
	}

}
