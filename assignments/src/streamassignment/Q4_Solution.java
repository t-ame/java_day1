package streamassignment;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Q4_Solution {

	
	String intStream(int digit, int start, int end) {
		
		if(digit<0 || digit>9)
			return "";
		
		return IntStream.range(start-1, end+1).mapToObj(x->{
			if(Integer.toString(x).contains(Integer.toString(digit))) {
				return Integer.toString(x);
			} else {
				return "";
			}
		}).filter(x -> x!="").collect(Collectors.joining(","));
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(new Q4_Solution().intStream(3, 5, 23));
	
	}
	
}
