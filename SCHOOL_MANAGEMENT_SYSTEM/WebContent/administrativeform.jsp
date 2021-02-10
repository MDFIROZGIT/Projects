<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrative Form </title>
</head>
<style>
 .main{
   margin-left:500px;
   background-color:white;
   margin-top: 50px;
	width: 240px;
	height: 30px;
 }
  .main1{
   margin-left:400px;
   background-color:#666633;
   margin-top: 30px;
	width: 260px;
	
 }
</style>
<body bgcolor="white" >
<div class="main">
 <font style="font-size: 25px; text-align:center;"><b>Registration Form</b></font>
	</br>
</div>
  <form action="administrativeurl" method="post" class="main1">
    <table style="border-spacing: 1px;">
      <tr>
        <td style="width: 101px; height: 14px">select status</td>
        <td>
        <select name="category">
          <option value="">---select status---</option>
          <option value="faculty">Faculty</option>
          <option values="principal">Principal</option>
        </select>
        </td>
      </tr>
      <tr>
         <td><label>Name:-</label></td>
         <td><input type="text" name="name"></td>
      </tr>
       <tr>
         <td><label>Mobile No:-</label></td>
         <td><input type="number" name="mobile"></td>
      </tr>
      <tr>
         <td><label>Gender:-</label></td>
         <td><input type="text" name="gender"> </td>
      </tr>
     <tr>
      <td colspan="2"  align="center"><input type="submit" value="submit "></td>
	 </tr>
    </table>
     
  </form>
  <a href="home.jsp">home</a>
 </body>
</html>