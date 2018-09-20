package assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapArgument_Q4 {

	
	public static boolean checkNull(Map map) {
		
		if(!(map instanceof TreeMap)) {
			if(map.containsKey(null))
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		HashMap hm = new HashMap();
		HashMap fm = new HashMap();
		TreeMap tm = new TreeMap();
		
		hm.put(2, 'f');
		hm.put(1, 'r');
		hm.put(null, 'g');
		
		fm.put(2, 'f');
		fm.put(1, 'r');
		fm.put(5, 'g');
		
		tm.put(2, 'f');
		tm.put(1, 'r');
		tm.put(2, 'g');
		
		System.out.println(MapArgument_Q4.checkNull(hm));
		System.out.println(MapArgument_Q4.checkNull(fm));
		System.out.println(MapArgument_Q4.checkNull(tm));
		
		
	}
	
	
	
}
