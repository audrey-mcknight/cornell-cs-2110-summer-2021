//Audrey McKnight amm498

package problemset1;

import java.util.Random;

public class ReducedTerms {

	public static boolean isReduced(int a, int b) {
		if (b == 0) 
			return a == 1;
		else
			return isReduced(b, a % b);
	}
	
	public static void main(String[] args) { 
		System.out.println(6/Math.pow(3.14159,2));
		int numTrials = 100000000;
		int reduced = 0;
		Random random = new Random();
		for(int i=0;i<numTrials;i++) {
			int a = random.nextInt(10000) + 1;
			int b = random.nextInt(10000) + 1;
			if (isReduced(a,b))
				reduced++;
		}
		double ratio = (double)reduced/numTrials;
		System.out.println(ratio);
}

}
