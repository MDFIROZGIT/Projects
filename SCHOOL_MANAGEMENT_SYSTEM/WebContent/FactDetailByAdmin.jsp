<%@ page import="com.nt.dto.FactDTO,java.util.*"%>
<%
//read req param values
List<FactDTO> listDTO=(List<FactDTO>)request.getAttribute("factDetail");

if(listDTO!=null && listDTO.size()>0)
{
%>
  <center><b>----:Faculty Details:---</b></center><br>
  <table align="center" border=1 bgcolor="cyan">
     <tr>
        <th>NAME</th><th>MOBILE</th><th>CATEGORY</th><th>SUBJECT</th>
     </tr>
     <tr>
     <%for(FactDTO fDTO:listDTO){ %>
        <th><%=fDTO.getName() %></th>
        <th><%=fDTO.getMobile() %></th>
        <th><%=fDTO.getCategory() %></th>
        <th><%=fDTO.getSubject() %></th>
     </tr>
    <%}//for %>

</table>
<%}//if
else {   %>
   <h1 style="color:red;text-align:center">Record not found</h1>
<%} %>

<script type="text/javascript" src="js/printresult.js">
</script>
<a href="javascript:doPrint()">print</a>
  