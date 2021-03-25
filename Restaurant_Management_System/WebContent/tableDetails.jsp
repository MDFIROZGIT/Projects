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
 <font style="font-size: 25px; text-align:center;"><b>Fetch table Status</b></font>
	</br>
</div>
  <form action="c1" method="post" class="main1">
    <table style="border-spacing: 1px; ">
      <tr>
        <td style="width: 200px; height: 14px">select Table Sites</td>
        <td>
        <select name="sites">
          <option value="">---select Table Sites---</option>
          <option value="1">1</option>
          <option values="2">2</option>
          <option values="3">3</option>
          <option values="4">4</option>
          <option values="5">5</option>
        </select>
        </td>

     
     <tr>
      <td colspan="2"  align="center"><input type="submit" value="submit "></td>
	 </tr>
    </table>
     
  </form>
  <h5 style="margin-left:400px">OR</h5>
  <form action="c2" method="post" class="main1">
    <table style="border-spacing: 1px; ">
      
      <tr>
        <td style="width: 200px; height: 14px">select Reservation Timing</td>
        <td>
        <select name="sites">
          <option value="">---select Timing---</option>
          <option value="11AM">10AMto11AM</option>
          <option values="12PM">11AMto12PM</option>
        </select>
        </td>
      </tr>
     <tr>
      <td colspan="2"  align="center"><input type="submit" value="submit "></td>
	 </tr>
    </table>
     
  </form>
  <a href="home.html">home</a>
 </body>
</html>