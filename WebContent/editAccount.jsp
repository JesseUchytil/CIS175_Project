<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Account</title>
</head>
<body>
	<form action = "editAccountServlet" method="post">
		Account name: <input type = "text" name = "name" value="${accountToEdit.account_name}">
		Account balance: <input type = "text" name = "balance" value="${accountToEdit.account_balance}">
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>