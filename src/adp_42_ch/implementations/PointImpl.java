/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.implementations;

import adp_42_ch.interfaces.Point;
import static adp_42_ch.implementations.Images.*;

/**
 *
 * @author panos
 * @author olli
 */
final class PointImpl implements Point {

    private final int x, y;

    private PointImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Point valueOf(int x, int y) {
        return new PointImpl(x, y);
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public double distanceToOrigin() {
        return distanceTo(point(0,0));
    }
    
    @Override
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x-other.x(), 2) + Math.pow(this.y-other.y(),2));
    }
    
    @Override
    public String toString(){
    	return "("+x+", "+y+")";
    }
    
    @Override
    public boolean equals(Object o){
    	if(this==o) return true;
    	if(!(o instanceof Point)) return false;
    	Point other=(Point) o;
    	return other.x()==this.x() && other.y()==this.y();
    }
    
    @Override
    public int hashCode(){
    	return Integer.valueOf(x).hashCode() + Integer.valueOf(y).hashCode();
    }

	@Override
	public int compareTo(Point other) {
		int yCompare=Integer.valueOf(this.y).compareTo(Integer.valueOf(other.y()));
		if(yCompare==0) return Integer.valueOf(this.x).compareTo(Integer.valueOf(other.x()));
		else return yCompare;
	}
}
