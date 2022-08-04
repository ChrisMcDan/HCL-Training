<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please Register</title>
</head>
<body>
	<div align="center">
		<h1>Employee Register Form</h1>
		<form action="<%=request.getContextPath()%>/Register" method="post">
			<table style="with: 80%">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullName" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><input type="text" name="state" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" /></td>
				</tr>
			</table>
			<input type="submit" value="Register" />
		</form>
	</div>
</body>
</html>