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

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
	HttpSession s=req.getSession();
		
		if(!s.isNew())
		{
			System.out.println("Old Session Destroy it & Create New One");
			s.invalidate();
			s=req.getSession();
		}
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		s.setAttribute("lusername", username);
		s.setAttribute("lpassword", password);
		
		if("admin".equals(username) && "admin".equals(password))
		{
			
			EmployeeSerI emplog= new EmployeeSeriImp();
			List<Employee>empdata=emplog.getAllEmployee();
			
			req.setAttribute("empdata", empdata);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
			
		}
		else
		{

		EmployeeSerI emplog= new EmployeeSeriImp();
		List<Employee> empdata=emplog.loginEmployee(username, password);
		
		if(!empdata.isEmpty())
		{
		
		req.setAttribute("empdata", empdata);
		
		req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
		
		}
		else
		{
			req.setAttribute("msg", "Enter Correct Username & Password");
			
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		
		}		
	}		
}
