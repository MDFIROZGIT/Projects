<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMISSION FORM</title>
</head>
<style>
.logo {
    margin-top: 0px
	float: left;
	background: white;
	width: 100%;
	height: 70px;
}
.home{
  
    background:brown;
    width:100%;
    height:40px;
    

}
.main {
	margin-left: 500px;
	background-color: white;
	
	width: 240px;
	height: 30px;
}



</style>
<body bgcolor="white">
   <div class="logo">
		<figure align="center"><img src="limra_public.png" height="50px"></figure>
	</div>
	
	<div class="home">
	   <font style="text-decoration:none;margin-left: 100px;padding:0px;color:white;"><b><a href="home.jsp">home</a></b></font>
	   <font style="font-size: 23px;margin-left:370px;padding:0px;color:white">ADMISSION FORM</font>
	</div>
	
	<form action="addurl" method="post" >
		<table style="border-spacing: 20px; margin-top:10px">
			<tr>
				<td><font style="margin-left: 400px;font-size: 25px; "><b>Student Name:-</b></font></td>
				<td><input type="text" name="stdname"></input></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Father's Name:-</b></font></td>
				<td><input type="text" name="fname"></input></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Mother's Name:-</b></font></td>
				<td><input type="text" name="mname"></input></td>
			</tr>
			</br>
			
			<tr>
			  <td><font style="margin-left: 400px; font-size: 25px;"><b>Date of Birth(yyyy-mm-dd):-</b></font></td>
			  <td><input type="String" name="dob" id="datefield"></td>
			</tr>
			
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Mobile:-<b></font></td>
				<td><input type="number" name="mob"></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Email:-<b></font></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Gender:-<b></font></td>
				<td><input type="text" name="gender"></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Class:-<b></font></td>
				<td><input type="text" name="class"></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Previous Marks(in %):-<b></font></td>
				<td><input type="text" name="pmarks"></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Aadhar No:-<b></font></td>
				<td><input type="number" name="aadhar"></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Leaving certificate:-<b></font></td>
				<td><input type="file" name="slc"></td>
			</tr>
			
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Marks Sheet:-<b></font></td>
				<td><input type="file" name="mks"></td>
			</tr>
			
			<tr>
				<td colspan="2"  align="center"><input type="submit" value="Submit "></td>
				
			</tr>
		</table>
	</form>
	
<br>

</body>
</html>