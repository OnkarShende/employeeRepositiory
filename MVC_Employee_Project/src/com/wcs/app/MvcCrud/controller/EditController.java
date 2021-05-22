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

@WebServlet(urlPatterns = "/edit")
public class EditController extends HttpServlet
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
			System.out.println("Edit Servlet");
			
			int empid=Integer.parseInt(req.getParameter("empid"));
			System.out.println(empid);
						
		s.setAttribute("empid", empid);
		
			EmployeeSerI emp=new EmployeeSeriImp();
			List<Employee>empdata=emp.editEmployee(empid);
				
			req.setAttribute("msg", "You can't change Username & EmployeeId");
			req.setAttribute("empdata", empdata);
			
			req.getRequestDispatcher("Edit.jsp").forward(req, resp);
		}	
	}
}
