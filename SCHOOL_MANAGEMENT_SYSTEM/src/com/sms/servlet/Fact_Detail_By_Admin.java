package com.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.FactDTO;


@WebServlet("/factdetailurl")
public class Fact_Detail_By_Admin extends HttpServlet {
	private static final String FETCH_QUERY=" SELECT NAME,MOB,CATEGORY,SUBJECT FROM ADMINISTRATIVE_DETAILS";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw =null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<FactDTO> listDTO=null;
		FactDTO fDTO=null;
		RequestDispatcher rd=null;
		
		//get writer obj
		pw=res.getWriter();
		
		//set ContentType
		res.setContentType("text/html");
		
		try {
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HR", "HR");
			
			//create ps obj
			if(con!=null)
				ps=con.prepareStatement(FETCH_QUERY);
			
			//execute the query
			if(ps!=null)
			{
				rs=ps.executeQuery();
			}
			
			//create list obj
			listDTO=new ArrayList<FactDTO>();
			//copy each record to fDTO and store in list
			while(rs.next())
			{
				fDTO=new FactDTO();
				fDTO.setName(rs.getString(1));
				fDTO.setMobile(rs.getLong(2));
				fDTO.setCategory(rs.getString(3));
				fDTO.setSubject(rs.getString(4));
				listDTO.add(fDTO);
				
			}//while
			
			//add listDTO to req param
			req.setAttribute("factDetail", listDTO);
			
			//create RequestDispatcher obj
			rd=req.getRequestDispatcher("FactDetailByAdmin.jsp");
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
	}//doPost

}
