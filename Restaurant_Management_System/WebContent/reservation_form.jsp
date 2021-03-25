<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Form</title>
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
   
	
	<div class="home">
	   <font style="text-decoration:none;margin-left: 100px;padding:0px;color:white;"><b><a href="home.html">home</a></b></font>
	   <font style="font-size: 23px;margin-left:370px;padding:0px;color:white">Reservation Form</font>
	</div>
	
	<form action="rservlet" method="post" >
		<table style="border-spacing: 20px; margin-top:10px">
			<tr>
				<td><font style="margin-left: 400px;font-size: 25px; "><b>Customer Name:-</b></font></td>
				<td><input type="text" name="cname"></input></td>
			</tr>
			</br>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Table Location:-<b></font></td>
				<td><input type="number" name="location"></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px; font-size: 25px;"><b>Table Sites:-<b></font></td>
				<td><input type="number" name="sites"></td>
			</tr>
			<tr>
				<td><font style="margin-left: 400px;font-size: 25px; "><b>Reservation Duration:-</b></font></td>
				<td><input type="text" name="rduration"></input></td>
			</tr>
			
			<tr>
				<td colspan="2"  align="center"><input type="submit" value="Submit "></td>
				
			</tr>
			
		</table>
	</form>
	
<br>

</body>
</html>