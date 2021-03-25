package com.rms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.rms.dto.CustDTO;

/**
 * Servlet implementation class CustomerDetailsServlet1
 */
@WebServlet("/c2")
public class CustomerDetailsServlet2 extends HttpServlet {
	private static final String C1_QUERY="SELECT CID,CNAME,TLOCATION,TSITES,TIME FROM CUSTOMER_DETAILS WHERE TIME=?";
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String time;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		CustDTO cDTO=null;
		List<CustDTO> listDTO=null;
		
		RequestDispatcher rd=null;
		
		//get writer
		pw=res.getWriter();
		
		//set contentType
		res.setContentType("text/html");
		
		try {
			//read req param values
			time=req.getParameter("sites");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HR", "HR");
			
			//create ps obj
			if(con!=null)
				ps=con.prepareStatement(C1_QUERY);
			//set values to ps param
			if(ps!=null)
			{
				ps.setString(1, time);
			}
			
			//execute the query
			if(ps!=null)
			{
				rs=ps.executeQuery();
			}
			
			listDTO=new ArrayList<CustDTO>();
			//read value from rs and set to StudDTO
			while(rs.next())
			{
				cDTO=new CustDTO();
				//copy the value of rs to sDTO
				cDTO.setCid(rs.getInt(1));
				cDTO.setCname(rs.getString(2));
				cDTO.setTlocation(rs.getInt(3));
				cDTO.setTsites(rs.getInt(4));
				cDTO.setTime(rs.getString(5));
				
				
				 
				 listDTO.add(cDTO);				
			}//while
			
			//set listDTO to request obj
			req.setAttribute("record", listDTO);
			rd=req.getRequestDispatcher("C1.jsp");
			rd.forward(req, res);
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//finally
		finally {
			//close all connections
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
		
	}//doGet

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
