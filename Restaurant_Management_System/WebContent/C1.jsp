<%@ page import="com.rms.dto.CustDTO,java.util.*"%>
<% 
//read request param value
List<CustDTO> listDTO=(List<CustDTO>)request.getAttribute("record");

//display listDTO content as html db table content 
if(listDTO!=null && listDTO.size()>0)
{
%>
   <center><b>-----:Customer Details:-----</b></center>
   <table border=1 align="center" bgcolor="cyan">
      <tr>
      <th>CID</th><th>CNAME</th><th>TABLE LOCATION</th><th>TABLE SITES</th><th>TIME</th>
      </tr>
    <%
      for(CustDTO cdto:listDTO)
      {%>
    	 <tr>
    	    <td><%=cdto.getCid() %> </td> 
    	     <td><%=cdto.getCname() %> </td>
    	    <td><%=cdto.getTlocation() %> </td> 
    	    <td><%=cdto.getTsites() %></td> 
    	    <td><%=cdto.getTime() %></td>
    	  
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