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

import com.nt.dto.ResultDTO;

@WebServlet("/owndetailsurl")
public class StudDetailByStudServlet extends HttpServlet {
	private static final String FETCH_DETAIL_QUERY="SELECT ROLLNO,NAME,CLASS,OBTAINED_MARKS,TOTAL_MARKS,ATTENDENCE FROM STUDENT_ATT_RESULT_DETAILS WHERE ROLLNO=? AND CLASS=?";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int rollno=0;
		String clazz=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ResultDTO rdto=null;
		RequestDispatcher rd=null;
		
		//get writer
		pw=res.getWriter();
		
		//set content type
		res.setContentType("text/html");
		
		try {
			//get req param values
			rollno=Integer.parseInt(req.getParameter("rollno"));
			clazz=req.getParameter("class");
			
			//get connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","HR");
			
			//create ps obj
			if(con!=null)
				ps=con.prepareStatement(FETCH_DETAIL_QUERY);
			
			//set values to ps obj param
			if(ps!=null)
			{
				ps.setInt(1, rollno);
				ps.setString(2, clazz);
			}
			//execute query
			if(ps!=null)
			{
				rs=ps.executeQuery();
			}
			//create ResultDTO obj
			rdto=new ResultDTO();
			//set values to ResultDTO obj
			if(rs!=null)
			{
				while(rs.next())
				{
					rdto.setRollno(rs.getInt(1));
					rdto.setName(rs.getString(2));
					rdto.setClazz(rs.getString(3));
					rdto.setObtained_marks(rs.getInt(4));
					rdto.setTotal_marks(rs.getInt(5));
					rdto.setAttendence(rs.getInt(6));
				}
			}
			//keep rdto in request scope
			   req.setAttribute("ResultInfo",rdto);  
			  //forward to the result page
			   rd=req.getRequestDispatcher("/result_print.jsp");
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
			
				try {
					if(rs!=null)
					{
					rs.close();
					}
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				
				try {
					if(ps!=null)
					{
					ps.close();
					}
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				try {
					if(con!=null)
					{
					con.close();
					}
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
		
		}
		
	}//doGet

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
