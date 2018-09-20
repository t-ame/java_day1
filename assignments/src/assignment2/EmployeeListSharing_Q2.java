package assignment2;

import java.util.LinkedList;

class Employee{
	
	
}


public class EmployeeListSharing_Q2 {

	private LinkedList<Employee> employeeList;
	
	public EmployeeListSharing_Q2(LinkedList<Employee> list){
		super();
		employeeList = new LinkedList<Employee>(list);
	}

	
	public LinkedList<Employee> getEmployeeList() {
		return employeeList;
	}
	
	
}
