package com.sms.servlet;

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


@WebServlet("/addurl")
public class AdmissionServlet extends HttpServlet {
	private static final String INSERT_STD_DETAILS="INSERT INTO STUDENT_DETAILS(SID,SNAME,FNAME,MNAME,DOB,MOB,EMAIL,GENDER,CLASS,PREVIOUS_MARKS,AADHAR,USERNAME,PASS,LEAVING_CERTIFICATE,PREVIOUS_MARKS_SHEET) VALUES( STUD_SEQ_NO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String sname=null,fname=null,mname=null,email=null,sclass=null,gender=null,username=null,pass=null;
		String sdob=null;
		Date sqldob=null;
		Long mob=0L,aadharno=0L;
		Float marks=0.0f;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		String slclocation=null,marksheetlocation=null;
		InputStream slcIS=null,marksheetIS=null;
		
		//get writer
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");

		try {
			//read  query param
			sname=req.getParameter("stdname");
			fname=req.getParameter("fname");
			mname=req.getParameter("mname");
			email=req.getParameter("email");
			sclass=req.getParameter("class");
			gender=req.getParameter("gender");
			username=req.getParameter("email");
			pass=req.getParameter("dob");
			sdob=req.getParameter("dob");
			mob=Long.parseLong(req.getParameter("mob"));
			aadharno=Long.parseLong(req.getParameter("aadhar"));
			marks=Float.parseFloat(req.getParameter("pmarks"));
			slclocation=req.getParameter("slc");
			marksheetlocation=req.getParameter("mks");

			
			//create InputSTreams rerpresenting   slc file and marksheet file
			 slcIS=new FileInputStream(slclocation);
			 marksheetIS=new FileInputStream(marksheetlocation);
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","HR");

			//create prepared statement obj
			if(con!=null)
			{
				ps=con.prepareStatement(INSERT_STD_DETAILS);
			}
			//convert string dob(yyyy-mm-dd) into sql dob(yyyy-mm-dd)
			sqldob=java.sql.Date.valueOf(sdob);

			//set query param values
			if(ps!=null)
			{
				ps.setString(1,sname);
				ps.setString(2, fname);
				ps.setString(3, mname);
				ps.setDate(4, sqldob);
				ps.setLong(5, mob);
				ps.setString(6, email);
				ps.setString(7, gender);
				ps.setString(8, sclass);
				ps.setFloat(9, marks);
				ps.setLong(10,aadharno);
				ps.setString(11, username);
				ps.setString(12, pass);
				ps.setBinaryStream(13, slcIS);
				ps.setBinaryStream(14, marksheetIS);


			}

			//execute query
			if(ps!=null)
			{
				count=ps.executeUpdate();
			}

			//display the mesage
			if(count==0)
				pw.write("form not submitted successfully");
			else
				pw.write("form submitted successfully with username:-"+email+" and password :-"+pass);
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
