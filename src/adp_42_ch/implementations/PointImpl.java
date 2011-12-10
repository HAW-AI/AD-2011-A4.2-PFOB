/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.implementations;

import adp_42_ch.interfaces.Point;

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
        return Math.sqrt(x * x + y * y);
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
		int xCompare=Integer.valueOf(this.x).compareTo(Integer.valueOf(other.x()));
		if(xCompare==0) return Integer.valueOf(this.y).compareTo(Integer.valueOf(other.y()));
		else return xCompare;
	}
}
