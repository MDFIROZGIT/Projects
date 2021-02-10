package com.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adminloginurl")
public class AdminLoginServlet extends HttpServlet {
	private static final String AUTH_QUERY="SELECT COUNT(*)  FROM ADMINISTRATIVE_DETAILS WHERE USERNAME=? AND PASS=? AND CATEGORY='Principal' ";
	
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 	
		PrintWriter pw=null;
		String user=null;
		String pass=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int  count=0;
		//get writer
			pw=res.getWriter();
			
		//set content type
			res.setContentType("text/html");
	   	
			
			
			try {
				//read inputs
				user=req.getParameter("user");
				pass=req.getParameter("pwd");
				
				//register JDBc driver
				  // Class.forName("oracle.jdbc.driver.OracleDriver");
				//establish the connection
				   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HR", "HR");
				   //create PreparedStement object  having pre-compiled SQL query
				   if(con!=null)
					   ps=con.prepareStatement(AUTH_QUERY);
				   //set values to the params of pre-compiled SQL query
				   if(ps!=null) {
					   ps.setString(1,user);
					   ps.setString(2,pass);
					   
					    //execute query
					   rs=ps.executeQuery();
				   }
				   //process the ResultSet 
				   if(rs!=null) {
					   rs.next();
					   count=rs.getInt(1);
				   }
				   //process the Result
				   if(count==0)
					   pw.write("Invalid Credentials");
				   else
				   {
					   //pw.write("Valid Credentials");
					   res.sendRedirect("admin_edit_fac_stud_details.jsp");
					   
				   }
					   
			
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				//close jdbc objs
				try {
					if(rs!=null)
						rs.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(ps!=null)
						ps.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(con!=null)
						con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				
			}//finally
	
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
