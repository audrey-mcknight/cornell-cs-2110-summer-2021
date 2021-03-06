package problemset2;

public class NumOfIterations {

	  public static int countMeasure1(int n) {
	    int counter = 0;
	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < n; j++)
		counter++;
	      for (int j = 0; j < n; j++)
		counter++;
	      for (int j = 0; j < n; j++)
		counter++;
	    }
	    return counter;
	  }

	  public static int countMeasure2(int n) {
	    int counter = 0;
	    for (int i = 0; i < n * n; i++)
	      for (int j = i; j < n; j++)
		counter++;
	    return counter;
	  }

	  public static int countMeasure3(int n) {
	    int counter = 0;
	    for (int i = 0; i < n; i++) {
	      for (int j = i; j < n; j++)
		counter++;
	      for (int j = 0; j < n; j++)
		counter++;
	      for (int j = 0; j < n; j++)
		counter++;
	    }
	    return counter;
	  }

	  public static int countMeasure4(int n) {
	    int counter = 0;
	    for (int i = 0; i < n; i++)
	      for (int j = i; j < n * n; j++)
		counter++;
	    return counter;
	  }

	  public static int countMeasure5(int n) {
	    int counter = 0;
	    for (int i = 0; i < n; i = i + 2) {
	      for (int j = i; j < n; j++)
		counter++;
	      for (int j = 0; j < n; j++)
		counter++;
	      for (int j = 0; j < n; j++)
		counter++;
	    }
	    return counter;
	  }

	  public static int countMeasure6(int n) {
	    int counter = 0;
	    for (int i = 0; i < n; i++)
	      for (int j = 0; j < n; j = j + 3)
		counter++;
	    return counter;
	  }

	  public static int countMeasure7(int n) {
	    int counter = 0;
	    for (int i = 1; i <= n; i++)
	      for (int j = 1; j <= i; j++)
		if (j % i == 0)
		  for (int k = 0; k < j; k++)
		    counter++;
	    return counter;
	  }

	  public static int countMeasure8(int n) {
	    int counter = 0;
	    for (int i = 0; i < n * n; i = i + 5)
	      for (int j = 0; j < n; j = j + 10)
		counter++;
	    return counter;
	  }

	  public static void main(String[] args) {
	    System.out.println("n\tcm1\tcm2\tcm3\tcm4\tcm5\tcm6\tcm7\tcm8");
	    for (int n = 50; n < 1000; n = n + 50) {
	      System.out.println(n + "\t" + //
				 countMeasure1(n) + "\t" + //
				 countMeasure2(n) + "\t" + //
				 countMeasure3(n) + "\t" + //
				 countMeasure4(n) + "\t" + //
				 countMeasure5(n) + "\t" + //
				 countMeasure6(n) + "\t" + //
				 countMeasure7(n) + "\t" + //
				 countMeasure8(n) + "\t");
	    }
	  }
	}
