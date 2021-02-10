<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Result View</title>
<style>
 
.main {
	margin-left: 500px;
	background-color: white;
	width: 250px;
	height: 20px;
}

</style>
</head>
<body>
   
   <div class="main">
	   <font style="font-size: 20px; text-align:center;"><b>Result View Form</b></font>
	</br>
	</div>
  <form action="owndetailsurl" method="post" >
   <table style="border-spacing: 20px;margin-left:400px">
         <tr>
           <td><label>class</label></td>
           <td><input type="text" name="class"></td>
         </tr>
          <tr>
           <td><label>Rollno:</label></td>
           <td><input type="number" name="rollno"></td>
         </tr>
         
         <tr>
          <td><input type="button" value="Back"></td>
         <td><input type="submit" value="submit"></td>
         </tr>
         </table>
  </form>
</body>
</html>