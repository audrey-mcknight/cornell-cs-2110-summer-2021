//Audrey McKnight amm498

package proj_0_base_conversion;

public class BaseConversion {

	public static String toBase2(int n) {
		String output = "";
		while (n > 0) {
			output = n % 2 + output;
			//System.out.println(output);
			n = n / 2;
		}
		return output;
	}
	
	public static int toBase10(String s) {
		int output = 0;
		int power = 1;
		for (int i=0;i<s.length();i++) {
			output += Character.getNumericValue(s.charAt(s.length()-i-1)) * power;
			power = power * 2;
		}
		return output;
	}
	
	public static void main(String[] args) {
		if (args.length == 2) 
			if(args[0].equals("to2")){
				System.out.println(toBase2(Integer.parseInt(args[1])));
			}
			else {
				System.out.println(toBase10(args[1]));
			}
	}

}
