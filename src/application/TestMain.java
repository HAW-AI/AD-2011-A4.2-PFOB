package application;

import static adp_42_ch.implementations.Images.*;
import adp_42_ch.interfaces.*;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Konvexe Hülle:"+image(point(2,1), point(3,2), point(2,3), point(1,2), point(2,2)).convexHull()+"\n\n");
		System.out.println("Konvexe Hülle:"+image(point(2,1), point(3,2), point(2,3), point(1,2), point(2,2), point(5,3), point(3,4), point(2,4), point(4,3)).convexHull()+"\n\n");
		System.out.println("Konvexe Hülle:"+image(randomPoints(20, -100, 100, -100, 100).points()).convexHull()+"\n\n");
		System.out.println("Konvexe Hülle:"+image(point(2,4), point(2,1), point(3,2), point(2,3), point(1,2), point(2,2)).convexHull());
		
	}

}
