package com.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/administrativeurl")
public class AdministrativeServlet extends HttpServlet {
	private static final String INSERT_QUERY="INSERT INTO ADMINISTRATIVE_DETAILS(name,mob,gender,username,pass,category) values(?,?,?,?,?,?)";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		String name=null,gender=null,username=null,pass=null,category=null;
		long mobile=0L;
		Connection con=null;
		int count=0;
		PreparedStatement ps=null;
		
		//get writer
		pw=res.getWriter();
		//set ContentType
		res.setContentType("text/html");
		try {
			category=req.getParameter("category");
			name=req.getParameter("name");
			mobile=Long.parseLong(req.getParameter("mobile"));
			gender=req.getParameter("gender");
			username=req.getParameter("name");
			pass=req.getParameter("mobile");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HR", "HR");
			
			//create PreparedStatement object
			if(con!=null)
			{
				ps=con.prepareStatement(INSERT_QUERY);
			}
			//set values to ps
			if(ps!=null)
			{
				ps.setString(1, name);
				ps.setLong(2, mobile);
				ps.setString(3, gender);
				ps.setString(4, username);
				ps.setString(5, pass);
				ps.setString(6, category);
			}
			//execute the query
			if(ps!=null)
			{
			  count=ps.executeUpdate();	
			}
			if(count==0)
				pw.write("registration failed");
			else
				pw.write("registration success with username is "+name+"  and  password is"+pass);
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
			    if(ps!=null)
				   ps.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
				}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}//finally
	}//doGet

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		doGet(req, res);
	}

}
