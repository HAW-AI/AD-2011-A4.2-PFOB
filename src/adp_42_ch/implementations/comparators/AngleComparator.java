package adp_42_ch.implementations.comparators;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import adp_42_ch.interfaces.Point;
import static adp_42_ch.implementations.Images.*;

public class AngleComparator implements Comparator<Point>{

	private final Point p0;
	private final Set<Point> pointsToRemove;
	
	public AngleComparator(Point p0){
		this.p0=p0;
		this.pointsToRemove=new HashSet<Point>();
	}
	

	
	@Override
	public int compare(Point p1, Point p2) {
		int t=T(p0,p1,p2);
		if(t<0) return 1;
		else if (t>0) return -1;
		else{
			if(p1.distanceTo(p0)<p2.distanceTo(p0)) pointsToRemove.add(p1);
			else pointsToRemove.add(p2);
//			System.out.println("Hallo"+p1+p2);
			return 0;
		}
			 
	}
	
	public Set<Point> pointsToRemove(){
		return new HashSet<Point>(pointsToRemove);
	}
	
}

