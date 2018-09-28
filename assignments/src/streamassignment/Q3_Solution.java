package streamassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Q3_Solution {

	static int tracker;
	
	
	List<String> removeStrings(List<String> strings, long stop){
		
		Iterator<String> it = strings.iterator();
		
		for(int i=0; i< stop; ++i) {
			strings.remove(0);
		}
		
		return strings;
	}
	
	int streamString(String text, int k) {
		
		List<String> strings = new ArrayList<>(Arrays.asList(text.split(" ")));
		
		for(String s : strings) {
			if (s.length()>k)
				return -1;
		}
		
		int  count = 0;
		
		while(strings.size() > 0) {
			
			long counter = strings.stream().map(x -> {
				Q3_Solution.tracker += x.length()+1;
				return new Support(x,Q3_Solution.tracker);
			}).filter(x -> x.length-1 <= k).count();
			
			Q3_Solution.tracker = 0;
			++count;
			strings = removeStrings(strings, counter);
		}
		
		return count;
	}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(new Q3_Solution().streamString("sms messages are really short", 12));
		
		System.out.println(new Q3_Solution().streamString("Yashoda just walked into class!!! woooww!", 12));
		
		System.out.println(new Q3_Solution().streamString("Yashoda just walked into class!!! woooww!", 7));
	}
	
}



class Support {
	
	String s;
	int length;
	
	Support(String s, int len){
		this.s = s;
		this.length = len;
	}
	
}




