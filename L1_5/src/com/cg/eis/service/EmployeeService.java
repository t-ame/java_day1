package com.cg.eis.service;

import com.cg.eis.bean.*;
import com.cg.eis.pl.UserComm.InsuranceScheme;

public interface EmployeeService {

	InsuranceScheme getInsuranceScheme(Employee employee);
	void displayEmployeeDetails(Employee employee);
	
}

