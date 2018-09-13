package com.cg.eis.pl;

import com.cg.eis.bean.Employee;
import com.cg.eis.pl.UserComm.Designation;
import com.cg.eis.service.EmployeeServiceImpl;

public class EmployeeMain {

	public static void main(String[] args) {

		EmployeeServiceImpl im = new EmployeeServiceImpl();
		
		Employee employee = new Employee("Henry Cho", 2345424, 32000);
		
		employee.setInsuranceScheme();
		
		im.displayEmployeeDetails(employee);;
	
//		UserComm us = new UserComm();
//		
//		us.getEmployeeScheme();
		
		
		
			
		
		
	}
	
}
