<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<div align="center">
		<h1>Employee Delete Form</h1>
		<form action="<%=request.getContextPath()%>/delete" method="post">
			<table style="with: 80%">
				<tr>
					<td>Id</td>
					<td><input type="text" name="id" /></td>
				</tr>
			</table>
			<input type="submit" value="Delete" />
		</form>
	</div>
</body>
</html>