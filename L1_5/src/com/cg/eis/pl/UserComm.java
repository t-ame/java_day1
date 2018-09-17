package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.*;

public class UserComm {
	
	public enum Designation {
		System_Associate, Programmer, Manager, Clerk
	}
	
	public enum InsuranceScheme {
		Scheme_A, Scheme_B, Scheme_C, No_Scheme
	}
	

	public InsuranceScheme getEmployeeScheme() {
		Scanner scanner = new Scanner(System.in);
		String name;
		int salary;
		long id;
		System.out.println("Enter Employee details.\nName: ");
		name = scanner.nextLine();
		System.out.println("ID number: ");
		id = scanner.nextLong();
		System.out.println("Salary: ");
		salary = scanner.nextInt();
		
		Employee employee = new Employee(name, id, salary);
		EmployeeServiceImpl im = new EmployeeServiceImpl();
		InsuranceScheme scheme = im.getInsuranceScheme(employee);
		

		System.out.println("Scheme: "+scheme);
		
		scanner.close();
		
		return scheme;
	}
	
	public Designation desGen(String designation) {
		
		String des = designation.toLowerCase();
		Designation design = null;
		
		if(des == "system_associate") {
			design = Designation.System_Associate;
		} else if (des == "programmer") {
			design = Designation.Programmer;
		} else if (des == "manager") {
			design = Designation.Manager;
		} else if (des == "clerk") {
			design = Designation.Clerk;
		} else {
			System.out.println("Invalid designation.");
		}
		return design;
	}
	
	
}
