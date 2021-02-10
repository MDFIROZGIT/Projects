<%@ page import="com.nt.dto.StudDTO,java.util.*"%>
<% 
//read request param value
List<StudDTO> listDTO=(List<StudDTO>)request.getAttribute("record");

//display listDTO content as html db table content 
if(listDTO!=null && listDTO.size()>0)
{
%>
   <center><b>-----:Student Details:-----</b></center>
   <table border=1 align="center" bgcolor="cyan">
      <tr>
      <th>SID</th><th>NAME</th><th>FATHER'S NAME</th><th>DOB</th><th>MOBILE</th><th>EMAIL</th><th>CLASS</th><th>AADHAR</th>
      </tr>
    <%
      for(StudDTO sdto:listDTO)
      {%>
    	 <tr>
    	    <td><%=sdto.getSid() %> </td> 
    	     <td><%=sdto.getSname() %> </td>
    	    <td><%=sdto.getFname() %> </td> 
    	    <td><%=sdto.getDob() %></td> 
    	    <td><%=sdto.getMob() %></td>
    	    <td><%=sdto.getEmail() %></td> 
    	    <td><%=sdto.getClazz() %></td> 
    	    <td><%=sdto.getAadhar() %></td>  
    	  </tr>
      <%}//for
      %>
      </table>
      <%}//if
       else{ %>
         <h1 style="color:red;text-align:center">No record found</h1>
         <%}//else
        %>
       <script type="text/javascript" src="js/printresult.js">
       </script>
       <a href="javascript:doPrint()">print</a>
    
    
   
   
   </table>