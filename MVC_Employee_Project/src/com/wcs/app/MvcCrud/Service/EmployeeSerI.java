package com.wcs.app.MvcCrud.Service;

import java.util.List;

import com.wcs.app.MvcCrud.Model.Employee;

public interface EmployeeSerI 
{
	
	void registerEmployee(Employee emp);
	
	List<Employee>getAllEmployee();
	
	List<Employee>loginEmployee(String username,String password);
	
	void deleteEmployee(int eid);
	
	List<Employee> editEmployee(int eid);
	
	void updateEmployee(Employee emp);

	
	
}
