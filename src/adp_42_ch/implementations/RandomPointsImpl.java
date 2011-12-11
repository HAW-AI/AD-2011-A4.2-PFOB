package adp_42_ch.implementations;

import java.util.HashSet;

import java.util.Random;
import java.util.Set;
import static adp_42_ch.implementations.Images.*;

import adp_42_ch.interfaces.Point;
import adp_42_ch.interfaces.RandomPoints;

public class RandomPointsImpl implements RandomPoints {

	private final long seed;
	
	private final int maxX;
	
	private final int maxY;
	
	private final Set<Point> points;
	
	private final Random random;
	
	private RandomPointsImpl (long seed, int numberOfPoints, int maxX, int maxY){
		this.seed=seed;
		this.random=new Random(seed);
		this.points=calculatePoints(numberOfPoints, maxX, maxY);
		this.maxX=maxX;
		this.maxY=maxY;
	}
	protected static RandomPointsImpl create(int numberOfPoints, int maxX, int maxY){
		return new RandomPointsImpl(System.currentTimeMillis(), numberOfPoints, maxX, maxY);
	}
	
	private Set<Point> calculatePoints(int numberOfPoints, int maxX, int maxY) {
		Set<Point> result=new HashSet<Point>();
		for(int i=0; i<numberOfPoints; i++){
			result.add(point(random.nextInt(maxX), random.nextInt(maxY)));
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

}
