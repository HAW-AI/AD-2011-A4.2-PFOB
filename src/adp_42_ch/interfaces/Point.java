/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.interfaces;

/**
 *
 * @author panos
 */
public interface Point extends Comparable<Point> {

    public int x();

    public int y();

    public double distanceToOrigin();
}
