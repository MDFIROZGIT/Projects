<%@ page  import="com.nt.dto.ResultDTO,java.util.*"%>
<%
  //read request attribute vlaue
   ResultDTO rdto=(ResultDTO)request.getAttribute("ResultInfo");
  
if(rdto!=null){
    %>
<center><b>Result</b></center><br><br>
<table border="1"  align="center" bgcolor="cyan">
  <tr>
      <th>RollNo </th> <th>Name </th> <th>Class </th><th>Obtained_Marks </th><th>Total_Marks </th><th>Attendence </th>  
  </tr>

    <tr>
        <td><%=rdto.getRollno() %> </td>
        <td><%=rdto.getName() %> </td>
        <td><%=rdto.getClazz() %> </td>
        <td><%=rdto.getObtained_marks() %> </td>
        <td><%=rdto.getTotal_marks() %> </td>
        <td><%=rdto.getAttendence() %> </td>
   </tr>
  <%}//if
  else{%>
	  <h1 style="color:red; text-align:center">No record found</h1>
   <%  }//else
       %>
 
   <script  language="javascript" src="js/printresult.js">
   </script>
   <a href="javascript:doPrint()">print</a>

</table>