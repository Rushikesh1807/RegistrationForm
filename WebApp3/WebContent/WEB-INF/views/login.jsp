<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


<form action="./getLoginUser"  method="post">
	<div class="container">
	
		<h1>EMPLOYEE LOGIN PAGE</h1>
		<div class="row p-4">
			<div class="col-md-3">Enter LogIn-ID</div>
			<div class="col-md-3"><input type="text" name="login"  class="form-control"/></div>
		</div>
		<div class="row p-4">
			<div class="col-md-3">Enter Password</div>
			<div class="col-md-3"><input type="password" name="password"  class="form-control"/></div>
		</div>
		
		<div class="row p-4">
			<div class="col-md-3"> <a> <input type="submit"  value="LOGIN" class="btn btn-info"/></a></div>
			
			
		<div class="col-md-3"><a href="./submit"> <input type="button"  value="REGISTER" class="btn btn-info"/></a></div>
		</div>
		
		</div>
		<div class="row p-2">
			<div class="col-md-6 text-danger"><h3>${error}</h3></div>
		</div>
	
		
</form>

</body>
</html>