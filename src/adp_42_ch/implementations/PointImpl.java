/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.implementations;

import adp_42_ch.interfaces.Point;

/**
 *
 * @author panos
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
    public double distance() {
        return Math.sqrt(x * x + y * y);
    }
}
