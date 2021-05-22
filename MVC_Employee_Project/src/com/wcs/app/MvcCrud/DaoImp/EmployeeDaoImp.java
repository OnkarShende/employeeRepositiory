package com.wcs.app.MvcCrud.DaoImp;
	
import java.security.Principal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wcs.app.MvcCrud.Dao.EmployeeDao;
import com.wcs.app.MvcCrud.Model.Employee;
import com.wcs.app.MvcCrud.Utility.JDBCConnection;

public class EmployeeDaoImp implements EmployeeDao
{
	PreparedStatement pr=null;
	@Override
	public void registerEmployee(Employee emp) 
	{
		try
		{
		 pr=JDBCConnection.getPreparedStatement("insert into employeedata values(?,?,?,?,?,?,?,?)");
			pr.setInt(1, emp.getEmpid());
			pr.setString(2, emp.getUsername());
			pr.setString(3, emp.getPassword());
			pr.setString(4, emp.getName());
			pr.setString(5, emp.getAddress());
			pr.setInt(6, emp.getAge());
			pr.setLong(7, emp.getMobileno());
			pr.setDouble(8, emp.getSalary());
			
			pr.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee>emplist=new ArrayList<Employee>();
		
		try
		{
		
		pr=JDBCConnection.getPreparedStatement("select * from employeedata");
		
		ResultSet rs=pr.executeQuery();
		
		while(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setAddress(rs.getString("address"));
			emp.setAge(rs.getInt("age"));
			emp.setEmpid(rs.getInt("empid"));
			emp.setMobileno(rs.getLong("mobileno"));
			emp.setName(rs.getString("name"));
			emp.setPassword(rs.getString("password"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setUsername(rs.getString("username"));
							
			emplist.add(emp);
							
		}						
	}						
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return emplist;
	}
	
	@Override
	public List<Employee> loginEmployee(String username,String password) {
	
		List<Employee> emplist=new ArrayList<Employee>();
		System.out.println("Login Employee user "+username);
		System.out.println("Login Eplloyee pass"+password);
		System.out.println("_______________________________");
		try
		{
		pr=JDBCConnection.getPreparedStatement("select * from employeedata where username=?");
		
		pr.setString(1, username);
		
		ResultSet rs=pr.executeQuery();
		
		if(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setAddress(rs.getString("address"));
			emp.setAge(rs.getInt("age"));
			emp.setEmpid(rs.getInt("empid"));
			emp.setMobileno(rs.getLong("mobileno"));
			emp.setName(rs.getString("name"));
			emp.setPassword(rs.getString("password"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setUsername(rs.getString("username"));
			
			emplist.add(emp);
			
		}	
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("List Returned");
		return emplist;
	}
	
	@Override
	public void deleteEmployee(int eid) {
	
		try
		{
			System.out.println("Dao"+eid);
			
		pr=JDBCConnection.getPreparedStatement("delete from employeedata where empid=?");
		
		pr.setInt(1, eid);
		
	int i=pr.executeUpdate();
	
	System.out.println("Query"+i);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Employee> editEmployee(int eid) {
	
		List<Employee>emplist=new ArrayList<Employee>();
		try
		{
			System.out.println("Dao"+eid);
		
		pr=JDBCConnection.getPreparedStatement("select * from employeedata where empid=?");
		
		pr.setInt(1, eid);
		
		ResultSet rs=pr.executeQuery();
		
		if(rs.next())
		{
			Employee emp=new Employee();
			
			emp.setAddress(rs.getString("address"));
			emp.setAge(rs.getInt("age"));
			emp.setEmpid(rs.getInt("empid"));
			emp.setMobileno(rs.getLong("mobileno"));
			emp.setName(rs.getString("name"));
			emp.setPassword(rs.getString("password"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setUsername(rs.getString("username"));
			
			emplist.add(emp);
				
		}
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return emplist;
	}
	
	@Override
	public void updateEmployee(Employee emp) {
		
		try
		{
		pr=JDBCConnection.getPreparedStatement("update employeedata set password=?, name=?, address=?, age=?, mobileno=?, salary=? where empid=?");
		
		pr.setString(1, emp.getPassword());
		pr.setString(2, emp.getName());
		pr.setString(3, emp.getAddress());
		pr.setInt(4, emp.getAge());
		pr.setLong(5, emp.getMobileno());
		pr.setDouble(6, emp.getSalary());
		pr.setInt(7, emp.getEmpid());
		
		int i=pr.executeUpdate();
		
		System.out.println("Update Query"+i);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
}	
