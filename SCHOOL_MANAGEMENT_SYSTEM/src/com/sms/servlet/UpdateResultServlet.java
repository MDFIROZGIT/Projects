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


@WebServlet("/updateresulturl")
public class UpdateResultServlet extends HttpServlet {
	private static final String RESULT_QUERY="INSERT INTO STUDENT_ATT_RESULT_DETAILS(ROLLNO,NAME,CLASS,OBTAINED_MARKS,TOTAL_MARKS,ATTENDENCE) VALUES(?,?,?,?,?,?)";
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,clazz=null;
		int rollno=0,obtained_marks=0,total_marks=0,attendence=0;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get writer
		pw=res.getWriter();
		//set contentType
		res.setContentType("text/html");
		
		try {
			rollno=Integer.parseInt(req.getParameter("rollno"));
			name=req.getParameter("name");
			clazz=req.getParameter("class");
			obtained_marks=Integer.parseInt(req.getParameter("obtainedmarks"));
			total_marks=Integer.parseInt(req.getParameter("totalmarks"));
			attendence=Integer.parseInt(req.getParameter("attendence"));
			
			//get con obj
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","HR");
			
			//create ps obj
			if(con!=null)
				ps=con.prepareStatement(RESULT_QUERY);
			
			//set values to ps obj
			if(ps!=null)
			{
				ps.setInt(1, rollno);
				ps.setString(2, name);
				ps.setString(3, clazz);
				ps.setInt(4, obtained_marks);
				ps.setInt(5, total_marks);
				ps.setInt(6, attendence);
			}
			//execute query
			if(ps!=null)
				count=ps.executeUpdate();
			
			if(count==0)
				pw.write("updation failed");
			else
				pw.write("updated successfully");
		}
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

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
