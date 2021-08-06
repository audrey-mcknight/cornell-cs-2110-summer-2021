//Audrey McKnight amm498
package proj_1_polling_place_v2;

import java.io.File;
import java.util.List;
import edu.princeton.cs.algs4.Queue;

public class Counter {
	public static void main(String[] args) throws Exception {
		
		int containedPoints = 0;
		if (args.length > 0) {
			Queue<Double> locationsX = new Queue<Double>();
			Queue<Double> locationsY = new Queue<Double>();
			District.readCoordinates(Defaults.pkg + File.separatorChar + args[0], locationsX, locationsY);
			List<Point> locations = District.doublesToPoints(locationsX, locationsY);
			for(int i = 1; i<args.length;i++) {
				District district = new District(Defaults.pkg + File.separatorChar + args[i]);
				containedPoints += district.countContained(locations);
			}
		}
		System.out.println(containedPoints);
		
	}
}
