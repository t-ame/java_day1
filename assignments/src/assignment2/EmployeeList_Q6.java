package assignment2;

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeList_Q6 {

	
	
	
	
	public static void main(String[] args) {
		
		
		/*
		 * This failed initially because of the syntax errors and the List type being used instead of 
		 * ArrayList...
		 * 
		*/
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("A");
		strings.add("B");
		strings.add("C");
		
		for (String s: strings)
		{
		    if (s == "B")
		    {
		        strings.remove("B");
		        break;
		    }
		}
		System.out.println(strings);

		
		
		
		
		//SORTING THE EMPLOYEES BASED ON THE FIRST LETTER OF THE FIRST NAME.
		//I'M NOT YET SURE HOW TO OVERLOAD THE '<' AND '>' OPERATORS FOR AN ENTIRE STRING...
		ArrayList<Employees> emplist = new ArrayList<Employees>();
		
		emplist.add(new Employees("Yash","Sundar"));
		emplist.add(new Employees("Payal","Bansal"));
		emplist.add(new Employees("Krishna","Raju"));
		emplist.add(new Employees("Navneet","Singh"));
		emplist.add(new Employees("Huy","Thai"));
		
		
		emplist.sort(new ComparatorImpl());
		
		System.out.println(emplist);
		
		
		
	}
	
	
	
}






class ComparatorImpl implements Comparator<Employees>{

	@Override
	public int compare(Employees o1, Employees o2) {
		
		if(o1.firstName.toLowerCase().charAt(0) > o2.firstName.toLowerCase().charAt(0))
			return 1;
		else if(o1.firstName.toLowerCase().charAt(0) < o2.firstName.toLowerCase().charAt(0))
			return -1;
		
		return 0;
	}
	
}




class Employees{
	
	String firstName;
	String lastName;
	
	public Employees(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}

	@Override
	public String toString() {
		return "'" + firstName + " " + lastName + "'" ;
	}
	
}








