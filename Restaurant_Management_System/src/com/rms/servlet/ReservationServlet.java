package com.rms.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/rservlet")
public class ReservationServlet extends HttpServlet {
	private static final String INSERT_CUST_DETAILS="INSERT INTO CUSTOMER_DETAILS(CID,CNAME,TLOCATION,TSITES,TIME) VALUES( RCNO.NEXTVAL,?,?,?,?)";	
     
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		
		String cname=null;
		int tlocation;
		int tsites;
		String time;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get writer
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");

		try {
			//read  query param
			cname=req.getParameter("cname");
			tlocation=Integer.parseInt(req.getParameter("location"));
			tsites=Integer.parseInt(req.getParameter("sites"));
			time=req.getParameter("rduration");
			

			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","HR");

			//create prepared statement obj
			if(con!=null)
			{
				ps=con.prepareStatement(INSERT_CUST_DETAILS);
			}
			

			//set query param values
			if(ps!=null)
			{
				ps.setString(1,cname);
				ps.setInt(2, tlocation);
				ps.setInt(3, tsites);
				ps.setString(4, time);
			}

			//execute query
			if(ps!=null)
			{
				count=ps.executeUpdate();
			}

			//display the message
			if(count==0)
				pw.write("form not submitted successfully");
			else
				pw.write("form submitted successfully ");
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

	}//doGet()


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}


}
