<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please Create</title>
</head>
<body>
	<div align="center">
		<h1>New Employee Form</h1>
		<form action="<%=request.getContextPath()%>/new" method="post">
			<table style="with: 80%">
				<tr>
					<td>Full-name</td>
					<td><input type="text" name="fullname" /></td>
				</tr>
				<tr>
					<td>Username</td>
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
			<input type="submit" value="New" />
		</form>
	</div>
</body>
</html>