package com.wcs.app.MvcCrud.ServiceImp;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.wcs.app.MvcCrud.Dao.EmployeeDao;
import com.wcs.app.MvcCrud.DaoImp.EmployeeDaoImp;
import com.wcs.app.MvcCrud.Model.Employee;
import com.wcs.app.MvcCrud.Service.EmployeeSerI;
import com.wcs.app.MvcCrud.Utility.JDBCConnection;

public class EmployeeSeriImp extends HttpServlet  implements EmployeeSerI 
{
	
	@Override
	public void registerEmployee(Employee emp) {
		
		EmployeeDao empdao= new EmployeeDaoImp();
			
		empdao.registerEmployee(emp);
		
	}	

	@Override
	public List<Employee> getAllEmployee() {
		
		EmployeeDao emp= new EmployeeDaoImp();
		List<Employee> allemp=emp.getAllEmployee();		
		
		return allemp;
		
	}

	@Override
	public List<Employee> loginEmployee(String username,String password) {
		
		System.out.println("Login Employee user "+username);
		System.out.println("Login Eplloyee pass"+password);
		System.out.println("_____________________________");
		
		EmployeeDao emp= new EmployeeDaoImp();
		List<Employee> loginemp=emp.loginEmployee(username, password);
		
		return loginemp;
	}

	@Override
	public void deleteEmployee(int eid) {
	
		EmployeeDao emp=new EmployeeDaoImp();
			emp.deleteEmployee(eid);
					
	}
	
	@Override
	public List<Employee> editEmployee(int eid) {
		
		EmployeeDao emp=new EmployeeDaoImp();
		List<Employee>empdata=emp.editEmployee(eid);
		
		return empdata;
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		EmployeeDao em= new EmployeeDaoImp();
			em.updateEmployee(emp);
			
	}
}
