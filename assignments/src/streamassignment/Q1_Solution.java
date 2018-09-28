package streamassignment;

import java.util.Random;

public class Q1_Solution {

	
	int arbInt(int N) {
		
		return new Random().ints(N+1, (int)Math.pow(10, 9)).findAny().getAsInt();
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Q1_Solution().arbInt(40));
	}
	
}
