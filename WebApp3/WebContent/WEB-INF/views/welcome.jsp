<%@page import="org.nlt.controller.services.model.Students"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
  
<div class="row bg-info p-2">

<table align="center">
<div class="col-md-5 text-light"><h1>EMPLOYEE WELCOME PAGE</h1></div>
</table>
<%

Students stu=(Students) session.getAttribute("LoginUser");

if(stu!=null)
{
	
%>

<table align="center">
<div class="col-md-3 text-Light"><h4>WELCOME: <%=stu.getName() %></h4></div>
<div class="col-md-2 text-light"><h4><a href="./logout"><input type="button"  value="LOGOUT" class="btn btn-info"/></a></h4></div> 
</table>
<%
}
%>

</div>

<div class="row">
	<div class="col-md-12"><hr></div>
</div>
	<div class="row">
			<div class="col-md-12">
				<table width="100%" class="table">
					<tr>
						
						<th scope="col">LOGIN-ID</th>
						<th scope="col">NAME</th>
						<th scope="col">DOB</th>
						<th scope="col">GENDER</th>
						<th scope="col">CITY</th>
						<th scope="col">STATE</th>
						
					</tr>
          <c:forEach  items="${personList}" var="per">
 						 
					<tr>
						<td>${per.login}</td>
						<td>${per.name}</td>
						<td>${per.dob}</td>
						<td>${per.gender}</td>
						<td>${per.city}</td>
						<td>${per.state}</td>
						
					</tr>
					
				</c:forEach>
				</table>			
			</div>
		</div>
		


