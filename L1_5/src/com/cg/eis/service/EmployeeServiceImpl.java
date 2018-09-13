package com.cg.eis.service;

import com.cg.eis.bean.Employee;
import com.cg.eis.pl.UserComm.Designation;
import com.cg.eis.pl.UserComm.InsuranceScheme;


public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public InsuranceScheme getInsuranceScheme(Employee employee) {
		
		int salary = employee.getSalary();
		InsuranceScheme scheme = null;
		
		if(salary>5000 && salary<20000)
			scheme = InsuranceScheme.Scheme_C;
		else if (salary>=20000 && salary<40000)
			scheme = InsuranceScheme.Scheme_B;
		else if (salary>=40000)
			scheme = InsuranceScheme.Scheme_A;
		else  
			scheme = InsuranceScheme.No_Scheme;
		
		return scheme;
	}

	@Override
	public void displayEmployeeDetails(Employee employee) {
		
		System.out.println("Name: "+employee.getName());
		System.out.println("ID: "+employee.getID());
		System.out.println("Salary: "+employee.getSalary());
		System.out.println("Designation: "+employee.getDesignation());
		System.out.println("Insurance scheme: "+employee.getInsuranceScheme());
		
	}
	
	
	
}
