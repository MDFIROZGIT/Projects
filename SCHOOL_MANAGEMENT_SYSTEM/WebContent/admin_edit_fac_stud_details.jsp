<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin GUI</title>
<style>
#col1 {
     margin-top: 0px;
	float: right;
	background: green;
	width: 100%;
	height: 50px;
}
  h3{
   
    text-align:center;
  }
   h4{
   
    text-align:center;
  }
</style>
</head>
<body bgcolor="grey">
<div id="col1">
     <a href="home.jsp" >logout</a>
  </div>
      <h3>Student Detail Links:-</h3>
        <h4><a href="byadminurl?class=ten">class Ten</a></h4>
       <h4><a href="byadminurl?class=nine">class Nine</a></h4>
      
      <h3>faculty Details Links:-</h3>
      <h4><a href="factdetailurl">Link1</a></h4>
</body>

</html>