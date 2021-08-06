package problemset2;
import java.util.Stack;

public class ProblemOne {
	public static final String STARTERS = "([{<";
	public static final String ENDERS = ")]}>";
	
	public static boolean isBalanced(String str) {
		Stack<Character> starterstack= new Stack<Character>();
		 
		for (int i = 0; i < str.length(); i++){
		    Character c = str.charAt(i);
			if(STARTERS.contains(c.toString())){
				starterstack.push(c);
		    }
			else {
				if(starterstack.size()==0) {return false;}
				if(!starterstack.pop().equals(STARTERS.charAt(ENDERS.indexOf(c))))
					return false;
			}
		    
		}
		if(starterstack.size()>0) {return false;}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(isBalanced(args[0]));
	}

}
