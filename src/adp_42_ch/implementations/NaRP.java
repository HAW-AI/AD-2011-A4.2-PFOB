package adp_42_ch.implementations;

import java.util.HashSet;
import java.util.Set;

import adp_42_ch.interfaces.Point;
import adp_42_ch.interfaces.RandomPoints;

public class NaRP implements RandomPoints {

    private static NaRP instance;
    
    protected static NaRP create(){
    	if(instance==null) instance=new NaRP();
    	return instance;
    }
	
	@Override
	public long seed() {
		return -1;
	}

	@Override
	public Set<Point> points() {
		return new HashSet<Point>();
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public int minX() {
		return 0;
	}
	
	@Override
	public int maxX() {
		return 0;
	}

	@Override
	public int minY() {
		return 0;
	}
	
	@Override
	public int maxY() {
		return 0;
	}

}
