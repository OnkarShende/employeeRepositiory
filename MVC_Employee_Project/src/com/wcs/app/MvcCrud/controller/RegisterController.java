package com.wcs.app.MvcCrud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wcs.app.MvcCrud.DaoImp.EmployeeDaoImp;
import com.wcs.app.MvcCrud.Model.Employee;
import com.wcs.app.MvcCrud.Service.EmployeeSerI;
import com.wcs.app.MvcCrud.ServiceImp.EmployeeSeriImp;


@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	String name=req.getParameter("name");
	String address=req.getParameter("address");
	int age= Integer.parseInt(req.getParameter("age"));
	int empid=Integer.parseInt(req.getParameter("empid"));
	double salary= Double.parseDouble(req.getParameter("salary"));
	long mobileno= Long.parseLong(req.getParameter("mobileno"));
		
		
		Employee emp=new Employee();
			emp.setAddress(address);
			emp.setAge(age);
			emp.setEmpid(empid);
			emp.setMobileno(mobileno);
			emp.setName(name);
			emp.setPassword(password);
			emp.setSalary(salary);
			emp.setUsername(username);
			
		
		EmployeeSerI empserv=new EmployeeSeriImp();
			empserv.registerEmployee(emp);
			
			
			req.getRequestDispatcher("SignUpSuccess.jsp").forward(req, resp);
			
		
	}

}
