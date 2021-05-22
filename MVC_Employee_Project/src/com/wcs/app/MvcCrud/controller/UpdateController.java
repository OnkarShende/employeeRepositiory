package com.wcs.app.MvcCrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wcs.app.MvcCrud.Model.Employee;
import com.wcs.app.MvcCrud.Service.EmployeeSerI;
import com.wcs.app.MvcCrud.ServiceImp.EmployeeSeriImp;

@WebServlet(urlPatterns = "/update")
public class UpdateController extends HttpServlet
{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession s=req.getSession(false);
		
		if(s==null)
		{
			System.out.println("New Object");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}		

		else
		{
			
		Object o1=s.getAttribute("lusername");
		Object o2=s.getAttribute("lpassword");	
		Object o3=s.getAttribute("empid");
		
		int empid=(int) o3;
		String lusername=(String) o1;
		String lpassword=(String) o2;
		
		String address=req.getParameter("address");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		int age=Integer.parseInt(req.getParameter("age"));
		double salary=Double.parseDouble(req.getParameter("salary"));
		long mobileno=Long.parseLong(req.getParameter("mobileno"));
		
		Employee emp=new Employee();
			emp.setAddress(address);
			emp.setAge(age);
			emp.setEmpid(empid);
			emp.setMobileno(mobileno);
			emp.setName(name);
			emp.setPassword(password);
			emp.setSalary(salary);
			
			
			if("admin".equals(lusername) && "admin".equals(lpassword))
			{
				
				EmployeeSerI em=new EmployeeSeriImp();
				em.updateEmployee(emp);
				
				EmployeeSerI em1=new EmployeeSeriImp();
				List<Employee>empdata=em1.getAllEmployee();
				
				req.setAttribute("msg", "Details Updated Successfully");
				req.setAttribute("empdata", empdata);
				
				req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
					
			}
			else
			{
				EmployeeSerI em=new EmployeeSeriImp();
				em.updateEmployee(emp);
				
				EmployeeSerI em1=new EmployeeSeriImp();
				List<Employee>empdata=em1.loginEmployee(lusername, lpassword);
				
				req.setAttribute("msg", "Details Updated Successfully");
				req.setAttribute("empdata", empdata);
				
				req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);		
			}			
		}	
	}
}
