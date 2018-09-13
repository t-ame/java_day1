package com.cg.eis.bean;

import com.cg.eis.pl.UserComm.Designation;
import com.cg.eis.pl.UserComm.InsuranceScheme;
import com.cg.eis.service.EmployeeServiceImpl;


public class Employee {

	public String name;
	public long ID;
	public int salary;
	public Designation designation;
	public InsuranceScheme insuranceScheme;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, long iD, int salary) {
		super();
		this.name = name;
		ID = iD;
		this.salary = salary;
		this.setDesignation();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Designation getDesignation() {
		return designation;
	}


	
	public void setDesignation() {
		
		if(salary>5000 && salary<20000)
			this.designation = Designation.System_Associate;
		else if(salary>=20000 && salary<40000 )
			this.designation = Designation.Programmer;
		else if (salary>=40000)
			this.designation =  Designation.Manager;
		else
			this.designation =  Designation.Clerk;
		
	}

	public InsuranceScheme getInsuranceScheme() {
		return insuranceScheme;
	}

	public void setInsuranceScheme() {
		EmployeeServiceImpl im = new EmployeeServiceImpl();
		InsuranceScheme t = im.getInsuranceScheme(this);
		this.insuranceScheme = t;
	}
	
	
	
}


