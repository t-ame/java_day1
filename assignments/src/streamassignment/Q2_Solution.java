package streamassignment;

import java.util.stream.Stream;

public class Q2_Solution {

	String firstChar(String x) {
		if(Character.isDigit(x.charAt(0))) {
			return "digit";
		} else if(Character.isLowerCase(x.charAt(0))) {
			return "lowercase";
		} else if (Character.isUpperCase(x.charAt(0))) {
			return "uppercase";
		} else {
			return "other";
		}
	}
	
	
	String examine(String s) {
		Stream<String> stream = Stream.of(s);
		
		return stream.map(x->firstChar(x)).findFirst().get();
	}
	
	
	public static void main(String[] args) {
		
		Q2_Solution str = new Q2_Solution();
		
		System.out.println(str.examine("Hello"));
		System.out.println(str.examine("12dhisd"));
		System.out.println(str.examine("jjiasd"));
		System.out.println(str.examine("**sdfbod"));
		
	}
	
}
