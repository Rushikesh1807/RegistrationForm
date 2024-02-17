<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="res/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<style type="text/css">

.row
{
padding:10px;
}
</style>

<body>
<%-- <h1>Index Page ${buttonValue} ${action}</h1> --%>

<form action="${action}" method="post">
<div class="container">

<div class="row">
<div class="col-md-3"> <input type="hidden" name="id" value="${idValue}" class="form-control"/></div>
</div>
<h1>APPLICATION FORM</h1>
<div class="row">  
<div class="col-md-3">Enter Name</div>
<div class="col-md-3"> <input type="text" name="name" value="${nameValue}" class="form-control"/></div>
</div>

<div class="row">
<div class="col-md-3">Enter Age</div>
<div class="col-md-3"> <input type="number" name="age" value="${ageValue}"  min="10" max="100" class="form-control"/></div>
</div>

<div class="row">
<div class="col-md-3">Select Gender</div>
<div class="col-md-3">
Male <input type="radio" name="gender" value="male" ${genderValue eq 'male'?'checked':''}/> 
Female <input type="radio" name="gender" value="female" ${genderValue eq 'female'?'checked':''}/>
</div>
</div>

<div class="row">
<div class="col-md-3">Select Hobbies</div>
<div class="col-md-3">
Reading <input type="checkbox" name="hobbies" value="reading" ${fn:contains(hobbiesValue, 'reading')?'checked':''}/>
Dancing <input type="checkbox" name="hobbies" value="dancing" ${fn:contains(hobbiesValue, 'dancing')?' checked':''}/> 
Playing <input type="checkbox" name="hobbies" value="playing" ${fn:contains(hobbiesValue, 'playing')?'checked':''}/>
</div>
</div>

<div class="row">
<div class="col-md-3">Enter Address</div>
<div class="col-md-3">
<textarea name="address" class="form-control">${addressValue}</textarea>
</div>
</div>

<div class="row">
<div class="col-md-3">Select City</div>
 <div class="col-md-3">
<select name="city" class="form-control">
<option value="-1">Select</option>
<option value="nagpur" ${cityValue eq 'nagpur'?'selected':''}>Nagpur</option>
<option value="pune" ${cityValue eq 'pune'?'selected' :''}>Pune</option>
<option value="mumbai" ${cityValue eq 'mumbai'?'selected' :''}>Mumbai</option> 
<option value="wardha" ${cityValue eq 'wardha'?'selected' :''}>Wardha</option>
<option value="chandrapur" ${cityValue eq 'chandrapur'?'selected' :''}>Chandrapur</option>
<option value="sangli" ${cityValue eq 'sangli'?'selected' :''}>Sangli</option>
<option value="shivaji nagar" ${cityValue eq 'shivaji nagar'?'selected' :''}>Shivaji Nagar</option>
<option value="thane" ${cityValue eq 'thane'?'selected' :''}>Thane</option>
<option value="kolhapur" ${cityValue eq 'kolhapur'?'selected' :''}>Kolhapur</option>
<option value="NANDED" ${cityValue eq 'NANDED'?'selected' :''}>NANDED</option>

</select>
</div>
</div>

<div class="row">
<div class="col-md-3">Select DOB</div>
<div class="col-md-3">
<input type="date" name="dob" value="${dobValue}"class="form-control">
</div>
</div>

<div class="row">
<div class="col-md-3">
<input type="submit"value="${buttonValue}"class="btn btn-info">
</div>
</div>

<div class="row text-danger">
<div class="col-md-3">
<h4>${ error }</h4>
</div>
</div>


<div class="row text-success">
<div class="col-md-3">
<h4>${ success }</h4>
</div>
</div>
	<div class="row">
			<div class="col-md-12">
				<table  class="table">
					<tr>
						<th>ACTION</th>
						<th>Sr.No</th>
						<th>NAME</th>
						<th>AGE</th>
						<th>CITY</th>
						<th>HOBBIES</th>
					</tr>
					
					<c:forEach  items="${personList}" var="person">
					<tr>
						<td><a href="./getPersonForEdit?id=${person.id}">Edit</a> || 
						<a href="./getPersonForDelete?id=${person.id}">DELETE</a></td>
						<th>${person.id}</th>
						<th>${person.name}</th>
						<th>${person.age}</th>
						<th>${person.city}</th>
						<th>${person.hobbies}</th>
					</tr>
					</c:forEach>
				</table>			
			</div>
		</div>
</div>

</form>
</body>
</html>