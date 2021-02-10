package com.sms.servlet;

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

import com.nt.dto.StudDTO;


@WebServlet("/byadminurl")
public class StudDetailsByAdminServlet extends HttpServlet {
	private static final String ADMIN_QUERY="SELECT SID,SNAME,FNAME,DOB,MOB,EMAIL,CLASS,AADHAR FROM STUDENT_DETAILS WHERE CLASS=?";
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String clazz=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StudDTO sDTO=null;
		List<StudDTO> listDTO=null;
		SimpleDateFormat sdf=null;
		RequestDispatcher rd=null;
		
		//get writer
		pw=res.getWriter();
		
		//set contentType
		res.setContentType("text/html");
		
		try {
			//read req param values
			clazz=req.getParameter("class");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HR", "HR");
			
			//create ps obj
			if(con!=null)
				ps=con.prepareStatement(ADMIN_QUERY);
			//set values to ps param
			if(ps!=null)
			{
				ps.setString(1, clazz);
			}
			
			//execute the query
			if(ps!=null)
			{
				rs=ps.executeQuery();
			}
			
			listDTO=new ArrayList<StudDTO>();
			//read value from rs and set to StudDTO
			while(rs.next())
			{
				sDTO=new StudDTO();
				//copy the value of rs to sDTO
				sDTO.setSid(rs.getInt(1));
				sDTO.setSname(rs.getString(2));
				sDTO.setFname(rs.getString(3));
				
				//convert java.sql.Date  date values from rs  into String date 
				 sdf=new SimpleDateFormat("dd-MM-yyyy");
				 sDTO.setDob(sdf.format(rs.getDate(4)));
				 sDTO.setMob(rs.getLong(5));
				 sDTO.setEmail(rs.getString(6));
				 sDTO.setClazz(rs.getString(7));
				 sDTO.setAadhar(rs.getLong(8));
				 
				 listDTO.add(sDTO);				
			}//while
			
			//set listDTO to request obj
			req.setAttribute("record", listDTO);
			rd=req.getRequestDispatcher("StudDetailByAdmin.jsp");
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
