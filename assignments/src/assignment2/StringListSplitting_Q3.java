package assignment2;

import java.util.LinkedList;
import java.util.List;



public class StringListSplitting_Q3 {

	public LinkedList<String> insert(LinkedList<String> list, char character){
		
		String newStr = "";
		LinkedList<String> newlist = new LinkedList<String>();
		
		for(int j=0; j<list.size(); ++j) {
			String temp = list.get(j);
			newStr += temp.replace(' ', character);
			if(j == list.size()-1)
				newlist.add(newStr);
			newStr += character;
		}
		
		return newlist;
	}
	
	
	public static void main(String[] args) {
		
		StringListSplitting_Q3 str = new StringListSplitting_Q3();
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("cat mat bat");
		list.add("rat sat bat");
		list.add("wat fat got");
		
		System.out.println(str.insert(list, ','));
		
		
	}
	
	
	
}
