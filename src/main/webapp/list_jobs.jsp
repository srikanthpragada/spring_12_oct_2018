<%@include file="header.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<h1>List Of Jobs </h1>

<table border="1" cellpadding="5px" width="100%">
<tr class="heading">
<th>Job Id </th>
<th>Job Title </th>
<th>Min Salary </th>
<th>Max Salary </th>
<th> </th>
</tr>
<c:forEach var="job" items="${jobs}">
    <tr>
      <td>${job.id} </td>
      <td>${job.title} </td>
      <td>${job.minsal} </td>
      <td>${job.maxsal} </td>
      <td> 
          <a href="/jobs/delete/${job.id}" 
              onclick="return confirm('Do you really want to delete job?')">Delete</a>
          <a href="/jobs/edit/${job.id}">Edit</a>
      </td>
    </tr>  

</c:forEach>

</table>
