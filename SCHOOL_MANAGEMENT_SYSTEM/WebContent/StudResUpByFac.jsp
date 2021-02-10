<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Result Update form</title>
<style>
  .main{
    margin-left:500px;
    margin-top:50px;
    width:300px;
    height:30px;
    background-color:white;
  }
</style>
</head>
<body>
     <div class="main">
       <h2 style="font-size:20px">Sudent Result update form</h2>
     </div>
     <form  action="updateresulturl" method="post">
         <table style="border-spacing: 20px;margin-left:400px">
         <tr>
           <td><label>Roll no:</label></td>
           <td><input type="number" name="rollno"></td>
         </tr>
          <tr>
           <td><label>Name:</label></td>
           <td><input type="text" name="name"></td>
         </tr>
          <tr>
           <td><label>Class:</label></td>
           <td><input type="text" name="class"></td>
         </tr>
         
          <tr>
           <td><label>Obtained Marks:</label></td>
           <td><input type="number" name="obtainedmarks"></td>
         </tr>
          <tr>
           <td><label>Total Marks:</label></td>
           <td><input type="number" name="totalmarks"></td>
         </tr>
          <tr>
           <td><label>Attendence:</label></td>
           <td><input type="number" name="attendence"></td>
         </tr>
         <tr>
         <td colspan=2  ><input type="submit" value="submit"></td>
         </tr>
         </table>
     </form>
</body>
</html>