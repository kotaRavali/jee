<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
</head>
<body>
<div align = "center">
	
	
   <form action = "<%=request.getContextPath()%>/register " method="post">

	
	<form>
		<label> First Name: </label> <input type="text" name="firstName"
			size="25" placeholder= "firstName"/> <br>
		<br> <label> Last Name: </label> <input type="text"
			name="lastName" size="25" placeholder="lastName" /> <br>
		<br> <label> User Name: </label> <input type="text"
			name="userName" size="25" placeholder="userName" /> <br>
		<br> <label> Password: </label> <input type="password"
			name="password" size="25" placeholder="***********" /> <br>
		<br> <label>Address : <br> <textarea cols="40"
				name= "address" rows="3" value="address" placeholder="address" >
        </textarea></label> <br> <br> <label> Contact : </label> <input type="text"
			name="contact" size="25" placeholder="0123456789" /> <br> <br>
		<button value="submit">Submit</button>
	</form>
	</form>
	</div>
</body>
</html>