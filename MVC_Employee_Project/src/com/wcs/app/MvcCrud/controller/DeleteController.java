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

@WebServlet(urlPatterns = "/delete")
public class DeleteController extends HttpServlet
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
			int empid=Integer.parseInt(req.getParameter("empid"));

			System.out.println(empid);
			
			Object o=s.getAttribute("lusername");
			String username=(String) o;
			System.out.println("Attribute"+username);
			
			Object o1=s.getAttribute("lpassword");
			String password=(String)o1;
			System.out.println("Attribute"+password);
			
		if("admin".equals(username) && "admin".equals(password))
		{
		
			System.out.println("if loop");
			
			EmployeeSerI empdata=new EmployeeSeriImp();
			empdata.deleteEmployee(empid);
			
			EmployeeSerI empdata1=new EmployeeSeriImp();
			List<Employee>allemp=empdata1.getAllEmployee();
				
			req.setAttribute("msg", "Successfully Deleted Employee Data");
			req.setAttribute("empdata", allemp);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
		}
		
		else
		{
			System.out.println("else loop");
			
			EmployeeSerI empdata=new EmployeeSeriImp();
			empdata.deleteEmployee(empid);
			
			req.setAttribute("msg", "Your Account Deleted Successfully");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		}
	}

}
