package streamassignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Q5_Solution {

	
	List<Integer> listSort(LinkedList<Integer> list){
		
		return list.stream().sorted((x,y) -> x-y).collect(Collectors.toList());
	}
	
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(13,22,46,50));
		LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(3,14,16,48));

		System.out.println(list1);
		System.out.println(list2);
		
		list2.addAll(list1);
		
		System.out.println(list2);
		System.out.println(new Q5_Solution().listSort(list2));
		
	}
	
}
