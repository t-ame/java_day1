package assignment2;


import java.util.*;
import java.util.ArrayList;
import java.util.Collection;


public class ExceptionFix_Q8 {

	
	public static void main(String[] args) {
		
		

        ArrayList<String> srcstr = new ArrayList<String>();

        srcstr.add("New York");
        srcstr.add("Atlanta");
        srcstr.add("Dallas");
        srcstr.add("Madison");
        System.out.println("Number of elements: " + srcstr.size());
        srcstr.forEach(s->System.out.println(s));
        ArrayList<String> deststr = new ArrayList<String>();
        deststr.add("Delhi");
        deststr.add("Mumbai");
        
        //DESTINATION LIST WASN'T BIG ENOUGH. HAD TO ADD 2 MORE ELEMENTS
        
        deststr.add("Mumbai");
        deststr.add("Mumbai");
        Collections.copy(deststr,srcstr);
        deststr.forEach(s->System.out.println(s));
		
		
	}
	
}



